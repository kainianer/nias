/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.nias;

import java.io.File;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
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

        System.setProperty("java.library.path", "lib");
        System.setProperty("org.lwjgl.librarypath", new File("lib/native/linux").getAbsolutePath());

        AppGameContainer game = new AppGameContainer(new Nias("History of Nias"));
        game.setDisplayMode(1280, 720, false);
        game.setShowFPS(false);
        game.setUpdateOnlyWhenVisible(false);
        game.setAlwaysRender(true);
        game.start();
    }
}
