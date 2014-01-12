/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.level;

import de.kraftwerk.item.Drop;
import de.kraftwerk.item.Item;
import de.kraftwerk.player.Player;
import de.kraftwerk.ui.Notation;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;

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
    private final List<Drop> dropList = new ArrayList<>();
    private TiledMap map;
    private Animation butterfly;
    private final List<Point> critterPos = new ArrayList<>();

    public Level(int size, Player player, GameContainer gc, String levelname) {
        this.size = size;
        this.level = new int[size][size];
        this.player = player;
        this.gc = gc;
        this.note = new Notation(levelname, 2000, gc);
        this.note.setActive(true);
        try {
            Image image = new Image("res/sprite.png").getSubImage(0, 88, 32, 8).getScaledCopy(5f);
            SpriteSheet butterflyS = new SpriteSheet(image, 40, 40);
            this.butterfly = new Animation(butterflyS, 150);
        } catch (SlickException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        try {
            this.map = new TiledMap("res/maps/testmap.tmx");
        } catch (SlickException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //adding critters
        for (int i = 0; i < new Random().nextInt(30); i++) {
            this.critterPos.add(new Point(new Random().nextInt(this.size*80), new Random().nextInt(this.size*80)));
        }
    }

    public void create() {
        for (int i = 0; i < this.level.length; i++) {
            for (int j = 0; j < this.level[i].length; j++) {
                this.level[i][j] = 0;
            }
        }

        for (int i = 0; i < this.level.length; i++) {
            for (int j = 0; j < this.level[i].length; j++) {
                if (new Random().nextInt(10) == 3) {
                    this.dropList.add(new Drop(i * 80, j * 80, Item.drop()));
                }
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
        int startX = this.player.getX() / 80;
        int startY = this.player.getY() / 80;
        int endX = startX + gc.getWidth() / 80;
        int endY = startY + gc.getHeight() / 80;
        int xOff = this.player.getX() % 80;
        int yOff = this.player.getY() % 80;

        for (int xx = startX, i = 0; xx <= endX; xx++, i++) {
            for (int yy = startY, j = 0; yy <= endY; yy++, j++) {
                //TextureAtlas.getById(this.level[xx][yy]).getTexture().draw(i * 80 - xOff, j * 80 - yOff);
                for (int il = 0; il < this.map.getLayerCount(); il++) {
                    Image tile = this.map.getTileImage(xx, yy, il);
                    if (tile != null) {
                        tile.getScaledCopy(5f).draw(i * 80 - xOff, j * 80 - yOff);
                    }
                }

            }
        }
//
//        Drop hovered = null;
//        for (Drop dr : this.dropList) {
//            if (this.player.getX() < dr.getX() + 80 && this.player.getY() < dr.getY() + 80 && dr.getX() < this.player.getX() + 1280 && dr.getY() < this.player.getY() + 720) {
//                if (!dr.isHovered()) {
//                    dr.draw(grphcs, dr.getX() - this.player.getX(), dr.getY() - this.player.getY());
//                } else {
//                    hovered = dr;
//                }
//            }
//        }
        this.player.draw(grphcs, gc);
//        if (hovered != null) {
//            hovered.draw(grphcs, hovered.getX() - this.player.getX(), hovered.getY() - this.player.getY());
//        }

        //rendering critters
        for (Point p : this.critterPos) {
            this.butterfly.draw(p.x - this.player.getX(), p.y - this.player.getY());
        }
    }

    public void update(int delta, int x, int y) {
        int xOld = this.player.getRealX();
        int yOld = this.player.getRealY();

        if (x >= 0 && (x + this.gc.getWidth()) / 80 + 1 <= this.level.length) {
            this.player.setxOff(0);
            this.player.setX(x);
        } else {
            this.player.setxOff(x - this.player.getX());
        }
        if (y >= 0 && (y + this.gc.getHeight()) / 80 + 1 <= this.level[1].length) {
            this.player.setyOff(0);
            this.player.setY(y);
        } else {
            this.player.setyOff(y - this.player.getY());
        }

        this.player.moved = this.player.getRealX() != xOld || this.player.getRealY() != yOld;
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

    public List<Drop> getDrops() {
        return this.dropList;
    }
}
