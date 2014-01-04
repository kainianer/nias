/*
 * Copyright 2013 by Kraftwerk Productions
 * Do not distribute!
 */
package de.kraftwerk.sfx;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 *
 * @author kainianer
 */
public enum Sounds {

    START("start.wav"),
    CLICK1("click1.wav"),
    CLICK2("click2.wav"),
    LOGIN_FAIL("gong.wav"),
    DROPDOWN("test.wav");

    private Sound sound;

    private Sounds(String res) {
        try {
            this.sound = new Sound("/res/sfx/" + res);
        } catch (SlickException ex) {
            Logger.getLogger(Sounds.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Sound getSound() {
        return this.sound;
    }

}
