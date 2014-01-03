/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.states;

import de.kraftwerk.level.Level;
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
    private final Level level = new Level(16);

    public Game(GameContainer gc, StateBasedGame sbg) {
        super(Game.ID, gc, sbg);

        this.level.create();

        Menu inventory = new Menu(32, 64, gc.getWidth() * 13 / 46, gc.getHeight() - 128, MenuType.MENU_DARK);
        inventory.addCloseButton();
        inventory.setActive(true);
        inventory.setHeader("Inventory");

        Notation note = new Notation("Raheria City", 2000, gc);
        note.setActive(true);

        this.addComponent(inventory);
        this.addComponent(note);

    }

    @Override
    public int getID() {
        return 3;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        this.level.draw(grphcs);
        super.render(gc, sbg, grphcs);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        super.update(gc, sbg, delta);
        this.level.update(delta);
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
