/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.level;

/**
 *
 * @author kainianer
 */
public class Level {

    private int size;
    private int[][] level;

    public Level(int size) {
        this.size = size;
        this.level = new int[size][size];
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

    /**
     * @return the level
     */
    public int[][] getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int[][] level) {
        this.level = level;
    }

}
