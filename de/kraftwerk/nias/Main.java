/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kraftwerk.nias;

import java.awt.SplashScreen;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
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
     */
    public static void main(String[] args) throws SlickException {

        System.setProperty("java.library.path", "lib");
        System.setProperty("org.lwjgl.librarypath", new File("lib/native/linux").getAbsolutePath());

        AppGameContainer game = new AppGameContainer(new Nias("History of Nias"));
        game.setDisplayMode(1280, 720, false);
        game.setShowFPS(false);
        game.setUpdateOnlyWhenVisible(false);
        game.setAlwaysRender(true);
        try {
            Thread.sleep(450);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        SplashScreen.getSplashScreen().close();
        game.start();
    }
}
