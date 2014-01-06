/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.nias;

import org.lwjgl.LWJGLException;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/**
 *
 * @author kainianer
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws org.newdawn.slick.SlickException
     * @throws org.lwjgl.LWJGLException
     */
    public static void main(String[] args) throws SlickException, LWJGLException {
        AppGameContainer game = new AppGameContainer(new Nias("History of Nias"));
        game.setDisplayMode(1280, 720, false);
        game.setShowFPS(false);
        game.setUpdateOnlyWhenVisible(false);
        game.setAlwaysRender(true);
        game.start();
    }
}
