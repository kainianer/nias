/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.level;

import java.awt.Rectangle;

/**
 *
 * @author kainianer
 */
public class Space {

    private int x;
    private int y;
    private int width;
    private int height;

    public Space(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean intersects(Space space) {
        return new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight()).intersects(new Rectangle(space.getX(), space.getY(), space.getWidth(), space.getHeight()));
    }

    public boolean intersects(Space space, int margin) {
        return new Rectangle(this.getX() - margin, this.getY() - margin, this.getWidth() + margin, this.getHeight() + margin).intersects(new Rectangle(space.getX() - margin, space.getY() - margin, space.getWidth() + margin, space.getHeight() + margin));
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

}
