/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.states;

import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.level.Level;
import de.kraftwerk.player.Player;
import de.kraftwerk.ui.Component;
import de.kraftwerk.ui.Menu;
import de.kraftwerk.ui.Menu.MenuType;
import de.kraftwerk.ui.Notation;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author kainianer
 */
public class Game extends State {

    public static final int ID = 3;
    private final List<Component> compList = new ArrayList<>();

    private int x;
    private int y;

    private final Level level;

    public Game(GameContainer gc, StateBasedGame sbg) {
        super(Game.ID, gc, sbg);

        this.level = new Level(32, new Player("kainianer"));
        this.level.create();
        Menu inventory = new Menu(32, 64, gc.getWidth() * 13 / 46, gc.getHeight() - 128, MenuType.MENU_DARK);
        inventory.addCloseButton();
        inventory.setHeader("Inventory");

        Notation note = new Notation("Raheria", 2000, gc);
        note.setActive(true);

        this.addComponent(inventory);
        this.addComponent(note);

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        this.level.draw(grphcs, gc);
        super.render(gc, sbg, grphcs);
        int xOff = (gc.getWidth() - 5 * UserInterface.SPELLBAR.getWidth() - 25) / 2;
        int yOff = gc.getHeight() - UserInterface.SPELLBAR.getHeight();
        for (int i = 0; i < 5; i++) {
            UserInterface.SPELLBAR.getTexture().draw(xOff + i * UserInterface.SPELLBAR.getWidth() + i * 5, yOff);
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        super.update(gc, sbg, delta);
        this.level.update(delta, this.x, this.y);

        if (gc.getInput().isKeyDown(Input.KEY_S)) {
            this.y += 1000 * delta / 1000 / 4;
        }
        if (gc.getInput().isKeyDown(Input.KEY_D)) {
            this.x += 1000 * delta / 1000 / 4;
        }
        if (gc.getInput().isKeyDown(Input.KEY_W)) {
            this.y -= 1000 * delta / 1000 / 4;
        }
        if (gc.getInput().isKeyDown(Input.KEY_A)) {
            this.x -= 1000 * delta / 1000 / 4;
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_ESCAPE) {
            State state = new Pause(this, this.gc, this.sbg);
            try {
                state.init(this.sbg.getContainer(), this.sbg);
            } catch (SlickException ex) {
                Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            this.sbg.addState(state);
            this.sbg.enterState(Pause.ID);
        }
    }
}
