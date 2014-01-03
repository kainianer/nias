/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.graphics;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 *
 * @author kainianer
 */
public class FpsHud {

    public FpsHud() {
    }

    public void draw(Graphics grphcs, int fps) {
        grphcs.setColor(Color.white);
        grphcs.drawString("History of Nias - Developer client", 10, 10);
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd.MM.yy, kk:mm");
        grphcs.drawString("TIME: " + s.format(d), 10, 30);
        grphcs.drawString("FPS: " + fps, 10, 50);
    }
}
