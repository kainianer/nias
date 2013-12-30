/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk;

import de.kraftwerk.states.Game;
import de.kraftwerk.states.Title;
import java.io.File;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author kainianer
 */
public class nias extends StateBasedGame {

    /**
     * @param args the command line arguments
     * @throws org.newdawn.slick.SlickException
     */
    public static void main(String[] args) throws SlickException {

        System.setProperty("java.library.path", "lib");
        System.setProperty("org.lwjgl.librarypath", new File("lib/native/linux").getAbsolutePath());

        AppGameContainer game = new AppGameContainer(new nias("History of Nias"));
        game.setDisplayMode(1280, 720, false);
        game.setShowFPS(false);
        game.setUpdateOnlyWhenVisible(false);
        game.setAlwaysRender(true);

        game.start();
    }

    /**
     *
     * @param title
     * @throws org.newdawn.slick.SlickException
     */
    public nias(String title) throws SlickException {
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
        this.addState(new Title(gc));
        this.addState(new Game(gc));
        this.createCursor(gc);
    }
}
