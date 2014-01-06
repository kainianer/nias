/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.states;

import de.kraftwerk.gameinterface.GameInterface;
import de.kraftwerk.level.Level;
import de.kraftwerk.player.Player;
import de.kraftwerk.ui.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
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

    private final Level level;
    private final Player player;
    private final GameInterface gameInterface;

    public Game(GameContainer gc, StateBasedGame sbg, String name) {
        super(Game.ID, gc, sbg);
        this.player = new Player(name);
        this.gameInterface = new GameInterface(this.player);
        this.level = new Level(32, player, gc, "Raheria");
        this.level.create();
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        super.init(gc, sbg);
        this.gameInterface.initListener(gc);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        this.level.draw(grphcs, gc);
        for (int x = 0; x < gc.getWidth() / 40; x++) {
            for (int y = 0; y < gc.getHeight() / 40; y++) {
                int centerX = (this.player.getRealX() - this.player.getX() + gc.getWidth()) / 40 / 2;
                int centerY = (this.player.getRealY() - this.player.getY() + gc.getHeight()) / 40 / 2;
                int maxDistance = 4;
                int distance = (int) Math.sqrt(Math.abs((x - (centerX - maxDistance)) * (x - (centerX + maxDistance)) + (y - (centerY - maxDistance)) * (y - (centerY + maxDistance))));
                int alpha = (distance - maxDistance * 2) * 10;
                grphcs.setColor(new Color(0, 0, 0, alpha));
                grphcs.fillRect(x * 40, y * 40, 40, 40);
            }
        }

        this.gameInterface.draw(grphcs);
        this.level.getNote().draw(grphcs);
        super.render(gc, sbg, grphcs);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        super.update(gc, sbg, delta);

        int x = this.player.getRealX();
        int y = this.player.getRealY();
        if (gc.getInput().isKeyDown(Input.KEY_S)) {
            y += 900 * delta / 1000 / 4;
        }
        if (gc.getInput().isKeyDown(Input.KEY_D)) {
            x += 900 * delta / 1000 / 4;
        }
        if (gc.getInput().isKeyDown(Input.KEY_W)) {
            y -= 900 * delta / 1000 / 4;
        }
        if (gc.getInput().isKeyDown(Input.KEY_A)) {
            x -= 900 * delta / 1000 / 4;
        }
        this.level.update(delta, x, y);
    }

    @Override
    public void keyPressed(int key, char c) {
        switch (key) {
            case Input.KEY_ESCAPE:

                State state = new Pause(this, this.gc, this.sbg);
                try {
                    state.init(this.sbg.getContainer(), this.sbg);
                } catch (SlickException ex) {
                    Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                this.sbg.addState(state);
                this.sbg.enterState(Pause.ID);
                break;
            case Input.KEY_B:
                this.gameInterface.setInventoryVisibility(!this.gameInterface.getInventoryVisibility());
                break;
            case Input.KEY_L:
                this.gameInterface.setTreeVisibility(!this.gameInterface.getTreeVisibility());
                break;
        }
    }
}
