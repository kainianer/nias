/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kraftwerk.states;

import de.kraftwerk.buttons.QuitButton;
import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.ui.Menu;
import de.kraftwerk.ui.Menu.MenuType;
import de.kraftwerk.util.Layout;
import java.util.logging.Level;
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
public class Pause extends State {

    public static final int ID = 4;

    private final Game game;

    public Pause(Game game, GameContainer gc, StateBasedGame sbg) {
        super(Pause.ID, gc, sbg);
        this.game = game;

        Menu menu = new Menu(new Layout(gc.getWidth() / 2 - 150, -32, 300, gc.getHeight() + 64), MenuType.MENU_DARK);
        menu.setActive(true);
        menu.add(new QuitButton(menu.getX() + (menu.getWidth() - UserInterface.BUTTON_NORMAL.getWidth()) / 2, 450, menu, gc));
        this.addComponent(menu);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        this.game.render(gc, sbg, grphcs);
        grphcs.setColor(new Color(0, 0, 0, 150));
        grphcs.fillRect(0, 0, gc.getWidth(), gc.getHeight());
        super.render(gc, sbg, grphcs);
    }

    @Override
    public void keyPressed(int key, char c) {
        if (this.sbg.getCurrentState().getID() == Pause.ID) {
            if (key == Input.KEY_ESCAPE) {
                try {
                    this.sbg.getState(Game.ID).init(this.gc, this.sbg);
                } catch (SlickException ex) {
                    Logger.getLogger(Pause.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.sbg.enterState(Game.ID);
            }
        }
    }
}
