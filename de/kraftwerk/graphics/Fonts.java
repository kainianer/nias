/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.graphics;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

/**
 *
 * @author kainianer
 */
public enum Fonts {

    HEADER("Fruce.ttf", 32),
    SUB("Fruce.ttf", 22),
    TEXT("Fruce.ttf", 16);

    private Font font;
    private final TrueTypeFont trueType;

    private Fonts(String res, float f) {
        try {
            this.font = Font.createFont(Font.TRUETYPE_FONT, ResourceLoader.getResourceAsStream("res/fonts/" + res));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Fonts.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.trueType = new TrueTypeFont(this.font.deriveFont(f), false);
    }

    public Font getFont() {
        return this.font;
    }

    public TrueTypeFont getTrueTypeFont() {
        return this.trueType;
    }
}
