/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.graphics;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author kainianer
 */
public enum TextureAtlas {

    GRASS(0, 112, 16, 16, 0),
    STONE_FLAT(16, 112, 16, 16, 1),
    STONE_WALL(32, 112, 16, 16, 2),
    FLOOR_RED(48, 112, 16, 16, 3),
    SAND(64, 112, 16, 16, 4),
    FLOOR_PATTERN(80, 112, 16, 16, 5),
    CARPET_RED(96, 112, 16, 16, 6),
    FLOOR_BRICK(112, 112, 16, 16, 7),
    WATER(112, 96, 16, 16, 11);

    private Image texture;
    private final int id;

    private TextureAtlas(int x, int y, int width, int height, int id) {
        this.id = id;
        try {
            this.texture = new Image("res/sprite.png").getSubImage(x, y, width, height).getScaledCopy(5f);
        } catch (SlickException ex) {
            Logger.getLogger(TextureAtlas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Image getTexture() {
        return this.texture;
    }

    public int getWidth() {
        return this.texture.getWidth();
    }

    public int getHeight() {
        return this.texture.getHeight();
    }

    public int getId() {
        return this.id;
    }

    public static TextureAtlas getById(int id) {
        for (TextureAtlas ta : TextureAtlas.values()) {
            if (ta.getId() == id) {
                return ta;
            }
        }
        return null;
    }
}
