/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.level;

import de.kraftwerk.graphics.TextureAtlas;
import de.kraftwerk.player.Player;
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

    private final Player player;

    public Level(int size, Player player) {
        this.size = size;
        this.level = new int[size][size];
        this.player = player;
    }

    public void create() {
        for (int i = 0; i < this.level.length; i++) {
            for (int j = 0; j < this.level[i].length; j++) {
                TextureAtlas[] at = TextureAtlas.values();
                this.level[i][j] = new Random().nextInt(at.length - 1);
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
                if (xx > 0 && yy > 0 && xx < this.level.length && yy < this.level[i].length) {
                    TextureAtlas.getById(this.level[xx][yy]).getTexture().draw(i * 80 - xOff, j * 80 - yOff);
                }
            }
        }
        this.player.draw(grphcs);
    }

    public void update(int delta, int x, int y) {
        this.player.setX(x);
        this.player.setY(y);

    }
}
