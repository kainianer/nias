/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.nias;

import de.kraftwerk.states.Game;
import de.kraftwerk.states.Title;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author kainianer
 */
public class Nias extends StateBasedGame {

    /**
     *
     * @param title
     * @throws org.newdawn.slick.SlickException
     */
    public Nias(String title) throws SlickException {
        super(title);
    }

    public void createCursor(GameContainer gc) throws SlickException {
        Image cursor = new Image("res/cursor.png");
        cursor.setFilter(Image.FILTER_NEAREST);
        cursor = cursor.getScaledCopy(2f);
        gc.setMouseCursor(cursor, 0, 0);
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.createCursor(gc);
        this.addState(new Title(gc, this));
    }
}
