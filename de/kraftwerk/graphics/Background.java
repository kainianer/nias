/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.graphics;

import de.kraftwerk.stateability.Renderable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author kainianer
 */
public class Background implements Renderable {

    private final Animation an;
    private final GameContainer sbg;

    public Background(GameContainer sbg) {
        this.sbg = sbg;

        Image[] images = new Image[7];
        for (int i = 0; i < 7; i++) {
            try {
                Image image = new Image("res/background/frame_" + i + ".png");
                image.setFilter(Image.FILTER_NEAREST);
                images[i] = image;
            } catch (SlickException ex) {
                Logger.getLogger(Background.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.an = new Animation(images, 150, true);
    }

    @Override
    public void draw(Graphics grphcs) {
        this.an.draw(0, 0, sbg.getWidth(), sbg.getHeight());
    }

}
