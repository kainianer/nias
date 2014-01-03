/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.level;

import de.kraftwerk.graphics.TextureAtlas;
import de.kraftwerk.stateability.Renderable;
import de.kraftwerk.stateability.Updateable;
import de.kraftwerk.ui.Notation;
import java.util.Random;
import org.newdawn.slick.Graphics;

/**
 *
 * @author kainianer
 */
public class Level implements Renderable, Updateable {

    private final int[][] level;
    private int size;
    private int delta;
    private Notation note;
    
    public Level(int size) {
        this.size = size;
        this.level = new int[size][size];
    }

    public void create() {
        for (int i = 0; i < this.level.length; i++) {
            for (int j = 0; j < this.level[i].length; j++) {
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

    @Override
    public void draw(Graphics grphcs) {
        for (int i = 0; i < this.level.length; i++) {
            for (int j = 0; j < this.level[i].length; j++) {
                TextureAtlas.getById(this.level[i][j]).getTexture().draw(i * 80, j * 80);
            }
        }
    }

    @Override
    public void update(int delta) {
//        if (this.delta + delta >= 400) {
//            for (int i = 0; i < this.level.length; i++) {
//                for (int j = 0; j < this.level[i].length; j++) {
//                    if (this.level[i][j] > 7 && this.level[i][j] < 11) {
//                        this.level[i][j] += 1;
//                    } else if (this.level[i][j] == 11) {
//                        if (new Random().nextInt(9) == 1) {
//                            this.level[i][j] = 8;
//                        }
//                    }
//                }
//            }
//            this.delta = 0;
//        } else {
//            this.delta += delta;
//        }
        
    }

}
