/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.player;

import de.kraftwerk.classes.Classes;
import de.kraftwerk.graphics.Fonts;
import de.kraftwerk.item.Item.Stats;
import de.kraftwerk.stateability.Updateable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author kainianer
 */
public class Player implements Updateable {

    private int x;
    private int y;

    private int xOff;
    private int yOff;

    private int skillPoints;
    private String name;
    private Map<Stats, Integer> stats = new HashMap<>();

    public Animation standa;
    public Animation upa;
    public Animation downa;
    public Animation lefta;
    public Animation righta;
    public Animation an;

    public boolean left;
    public boolean right;
    public boolean up;
    public boolean down;

    public boolean moved;
    public Image shadow;

    public Player(String name, Classes classes) {
        this.name = name;
        try {

            this.shadow = new Image("res/sprite.png").getSubImage(96, 96, 16, 8).getScaledCopy(5f);

            Image image = new Image("res/sprite.png").getSubImage(0, 72, 96, 16).getScaledCopy(5f);
            SpriteSheet stands = new SpriteSheet(image.getSubImage(0, 0, 160, 80), 80, 80);
            SpriteSheet downs = new SpriteSheet(image.getSubImage(160, 0, 160, 80), 80, 80);
            SpriteSheet rights = new SpriteSheet(image.getSubImage(320, 0, 160, 80), 80, 80);
            SpriteSheet ups = new SpriteSheet(image.getSubImage(480, 0, 160, 80), 80, 80);
            SpriteSheet lefts = new SpriteSheet(rights.getFlippedCopy(true, false), 80, 80);

            this.standa = new Animation(stands, 1000);
            this.downa = new Animation(downs, 400);
            this.upa = new Animation(ups, 400);
            this.lefta = new Animation(lefts, 400);
            this.righta = new Animation(rights, 400);

            this.an = this.standa;

        } catch (SlickException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Stats st : classes.getClassStats()) {
            this.stats.put(st, new Random().nextInt(1337));
        }

    }

    public void draw(Graphics grphcs, GameContainer gc) {
        grphcs.setFont(Fonts.TEXT.getTrueTypeFont());
        grphcs.setColor(Color.white);
        grphcs.drawString(name, gc.getWidth() / 2 - grphcs.getFont().getWidth(name) / 2 + this.xOff, gc.getHeight() / 2 - 64 + this.yOff);
        this.an.draw((gc.getWidth() - an.getCurrentFrame().getWidth()) / 2 + this.xOff, (gc.getHeight() - an.getCurrentFrame().getHeight()) / 2 + this.yOff);
        this.shadow.draw((gc.getWidth() - this.shadow.getWidth()) / 2 + this.xOff, (gc.getHeight() - this.shadow.getHeight()) / 2 + this.yOff + 43);
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

    public Map<Stats, Integer> getStats() {
        return this.stats;
    }

    public int getSkillPoints() {
        return this.skillPoints;
    }

    public int getRealX() {
        return this.x + this.xOff;
    }

    public int getRealY() {
        return this.y + this.yOff;
    }

    @Override
    public void update(int delta) {
        if (this.moved) {
            if (this.down) {
                this.an = downa;
            }
            if (this.right) {
                this.an = righta;
            }
            if (this.left) {
                this.an = lefta;
            }
            if (this.up) {
                this.an = upa;
            }
        } else {
            this.an = standa;
        }
    }
}
