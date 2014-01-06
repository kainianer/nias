/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.states;

import de.kraftwerk.sfx.Sounds;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author kainianer
 */
public class Splash extends State {

    public static final int ID = 0;

    private final Image screen;
    private final Sound sound;

    public Splash(GameContainer gc, StateBasedGame sbg) throws SlickException {
        super(0, gc, sbg);
        this.screen = new Image("/res/splash/screen.png");
        this.sound = Sounds.START.getSound();
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.sound.play(1f, 0.25f);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        this.screen.draw(0, 0, gc.getWidth(), gc.getHeight());
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        if (!this.sound.playing()) {
            State state = new Login(gc, sbg);
            state.init(gc, sbg);
            sbg.addState(state);
            sbg.enterState(Login.ID);
        }
    }

}
