/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.level;

import de.kraftwerk.graphics.TextureAtlas;
import de.kraftwerk.stateability.Renderable;
import org.newdawn.slick.Graphics;

/**
 *
 * @author kainianer
 */
public class Trees extends Space implements Renderable {

    private final int[][] textures;

    public Trees(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.textures = new int[width][height];
        this.create();
    }

    private void create() {
        for (int i = 0; i < this.textures.length; i++) {
            for (int j = 0; j < this.textures[i].length; j++) {
                int id;
                if (i == 0 || i == this.textures.length - 1) {
                    if (j == this.textures[i].length - 1) {
                        id = TextureAtlas.STONE_WALL.getId();
                    } else {
                        id = TextureAtlas.STONE_FLAT.getId();
                    }
                } else if (j == this.textures[i].length - 1) {
                    id = TextureAtlas.STONE_WALL.getId();
                } else if (j == 0 && (i > 0 || i < this.textures.length)) {
                    id = TextureAtlas.STONE_WALL.getId();
                } else {
                    id = TextureAtlas.FLOOR_PATTERN.getId();
                }
                this.textures[i][j] = id;
            }
        }
    }

    @Override
    public void draw(Graphics grphcs) {
        for (int i = 0; i < this.textures.length; i++) {
            for (int j = 0; j < this.textures[i].length; j++) {
                TextureAtlas.getById(this.textures[i][j]).getTexture().draw(i * 80, j * 80);
            }
        }
    }
}
