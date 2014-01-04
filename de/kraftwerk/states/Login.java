/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kraftwerk.states;

import de.kraftwerk.graphics.Background;
import de.kraftwerk.menu.LoginMenu;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author kainianer
 */
public class Login extends State {

    public static final int ID = 1;
    private final Background bg;

    public Login(GameContainer gc, StateBasedGame sbg) {
        super(Login.ID, gc, sbg);

        this.bg = new Background(gc);
        LoginMenu loginMenu = new LoginMenu(gc, sbg);
        loginMenu.setActive(true);
        this.addComponent(loginMenu);
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        super.init(gc, sbg);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        this.bg.draw(grphcs);
//        grphcs.setColor(new Color(0,0,0,150));
//        grphcs.fillRect(0, 0, gc.getWidth(), gc.getHeight());
        super.render(gc, sbg, grphcs);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        super.update(gc, sbg, i);
    }
}
