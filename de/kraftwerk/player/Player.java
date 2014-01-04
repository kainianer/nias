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

    private int x;
    private int y;

    private int xOff;
    private int yOff;

    private Animation an;
    private String name;

    private boolean bound;
    
    public Player(String name) {
        this.name = name;
        try {
            SpriteSheet sprite = new SpriteSheet(new Image("/res/sprite.png").getSubImage(0, 80, 32, 16).getScaledCopy(5f), 80, 80);
            this.an = new Animation(sprite, 1500);
        } catch (SlickException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void draw(Graphics grphcs) {
        this.an.draw(640 + this.xOff, 360 + this.yOff);
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the xOff
     */
    public int getxOff() {
        return xOff;
    }

    /**
     * @param xOff the xOff to set
     */
    public void setxOff(int xOff) {
        this.xOff = xOff;
    }

    /**
     * @return the yOff
     */
    public int getyOff() {
        return yOff;
    }

    /**
     * @param yOff the yOff to set
     */
    public void setyOff(int yOff) {
        this.yOff = yOff;
    }

    /**
     * @return the bound
     */
    public boolean isBound() {
        return bound;
    }

    /**
     * @param bound the bound to set
     */
    public void setBound(boolean bound) {
        this.bound = bound;
    }

}
