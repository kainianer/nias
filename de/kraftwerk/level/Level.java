/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.level;

import de.kraftwerk.graphics.TextureAtlas;
import de.kraftwerk.player.Player;
import de.kraftwerk.ui.Notation;
import java.util.Random;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 *
 * @author kainianer
 */
public class Level {

    private final int[][] level;
    private int size;
    private final Notation note;
    private final Player player;
    private final GameContainer gc;

    public Level(int size, Player player, GameContainer gc, String levelname) {
        this.size = size;
        this.level = new int[size][size];
        this.player = player;
        this.gc = gc;
        this.note = new Notation(levelname, 2000, gc);
        this.note.setActive(true);
    }

    public void create() {
        for (int i = 0; i < this.level.length; i++) {
            for (int j = 0; j < this.level[i].length; j++) {
                //TextureAtlas[] at = TextureAtlas.values();
                this.level[i][j] = 0;
            }
        }
    }

    public int getRandom(int greater, int less) {
        int val = new Random().nextInt(less);
        if (val < greater) {
            return this.getRandom(greater, less);
        } else {
            return val;
        }
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    public void draw(Graphics grphcs, GameContainer gc) {
        int startX = this.player.getX() / 80 + 1;
        int startY = this.player.getY() / 80 + 1;
        int endX = startX + gc.getWidth() / 80 + 1;
        int endY = startY + gc.getHeight() / 80 + 1;
        int xOff = this.player.getX() % 80;
        int yOff = this.player.getY() % 80;

        for (int xx = startX, i = 0; xx < endX; xx++, i++) {
            for (int yy = startY, j = 0; yy < endY; yy++, j++) {
                TextureAtlas.getById(this.level[xx][yy]).getTexture().draw(i * 80 - xOff, j * 80 - yOff);
            }
        }
        this.player.draw(grphcs, gc);
    }

    public void update(int delta, int x, int y) {
        int xOld = this.player.getRealX();
        int yOld = this.player.getRealY();

        if (x > 0 && (x + this.gc.getWidth()) / 80 + 1 < this.level.length) {
            this.player.setxOff(0);
            this.player.setX(x);
        } else {
            this.player.setxOff(x - this.player.getX());
        }
        if (y > 0 && (y + this.gc.getHeight()) / 80 + 1 < this.level[1].length) {
            this.player.setyOff(0);
            this.player.setY(y);
        } else {
            this.player.setyOff(y - this.player.getY());
        }

        this.player.moved = this.player.getX() != xOld || this.player.getY() != yOld;
        if (this.player.moved) {
            this.player.right = xOld < x;
            this.player.left = xOld > x;
            this.player.up = yOld > y;
            this.player.down = yOld < y;

        }
        this.player.update(delta);
        this.note.update(delta);
    }
    
    public Notation getNote() {
        return this.note;
    }
}
