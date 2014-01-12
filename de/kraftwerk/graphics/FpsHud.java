/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.graphics;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 *
 * @author kainianer
 */
public class FpsHud {

    private final GameContainer gc;

    public FpsHud(GameContainer gc) {
        this.gc = gc;
    }

    public void draw(Graphics grphcs, int fps) {
        grphcs.setFont(Fonts.TEXT.getTrueTypeFont());
        grphcs.setColor(Color.white);
        grphcs.drawString("History of Nias - Developer client", 5, 0);
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd.MM.yy, kk:mm");
        grphcs.drawString("TIME: " + s.format(d), 5, 20);
        grphcs.drawString("FPS: " + fps, 5, 40);
        grphcs.drawString("Version pre Alpha", gc.getWidth() - 5 - Fonts.TEXT.getTrueTypeFont().getWidth("Version pre Alpha"), 0);
    }
}
