/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.player;

import de.kraftwerk.stateability.Renderable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author kainianer
 */
public class Player implements Renderable {

    private Animation an;
    private String name;
    private Image shadow;

    public Player(String name) {
        this.name = name;
        try {
            this.shadow = new Image("/res/sprite.png").getSubImage(32, 80, 16, 16).getScaledCopy(5f);
            SpriteSheet sprite = new SpriteSheet(new Image("/res/sprite.png").getSubImage(0, 80, 32, 16).getScaledCopy(5f), 80, 80);
            this.an = new Animation(sprite, 1500);
        } catch (SlickException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void draw(Graphics grphcs) {
        this.an.draw(200, 50);
        this.shadow.draw(200,65);
    }

}
