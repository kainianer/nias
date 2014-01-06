/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.level;

import de.kraftwerk.player.Player;
import de.kraftwerk.util.Random;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.GameContainer;

/**
 *
 * @author kainianer
 */
public class Forest extends Level {

    private final List<Trees> rooms = new ArrayList<>();
    private final int roomValue;
    private final int margin;
    private final int minSize;
    private final int maxSize;

    public Forest(int size, int rooms, int margin, int minSize, int maxSize, Player player, GameContainer gc, String name) {
        super(size, player, gc, name);
        this.roomValue = rooms;
        this.margin = margin;
        this.minSize = minSize + 2;
        this.maxSize = maxSize + 2;
    }

    @Override
    public void create() {
        this.initTreess();
        this.proof();
        while (rooms.size() < this.roomValue) {
            this.addTrees();
            this.proof();
        }
        this.pack();
    }

    private void initTreess() {
        for (int i = 0; i < this.roomValue; i++) {
            int x = Random.getInteger(0, this.getSize());
            int y = Random.getInteger(0, this.getSize());
            int width = Random.getInteger(this.minSize, this.maxSize);
            int height = Random.getInteger(this.minSize, this.maxSize);
            this.getTreess().add(new Trees(x, y, width, height));
        }
    }

    private void addTrees() {
        int x = Random.getInteger(0, this.getSize());
        int y = Random.getInteger(0, this.getSize());
        int width = Random.getInteger(this.minSize, this.maxSize);
        int height = Random.getInteger(this.minSize, this.maxSize);
        this.getTreess().add(new Trees(x, y, width, height));
    }

    private boolean merge(List<Trees> roomsList) {
        for (Trees room : roomsList) {
            boolean intersecting = this.intersectsAny(room, roomsList, this.margin);
            if (intersecting) {
                roomsList.remove(room);
                this.merge(roomsList);
                return true;
            }
        }
        return false;
    }

    private boolean intersectsAny(Trees room, List<Trees> roomList, int margin) {
        List<Trees> roomsCopy = new ArrayList<>(roomList);
        for (Trees roomB : roomsCopy) {
            if (!roomB.equals(room)) {
                if (room.intersects(roomB, margin)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void proof() {
        if (this.merge(this.rooms)) {
            this.proof();
        }
    }

    private void pack() {
        for (Trees room : this.rooms) {
            while (!this.intersectsAny(room, this.rooms, 2) && room.getX() < this.getSize() / 2) {
                if (room.getX() < this.getSize() / 2) {
                    room.setX(room.getX() + 1);
                } else {
                    room.setX(room.getX() - 1);
                }
            }
            while (!this.intersectsAny(room, this.rooms, 2) && room.getY() < this.getSize() / 2) {
                if (room.getY() < this.getSize() / 2) {
                    room.setY(room.getY() + 1);
                } else {
                    room.setY(room.getY() - 1);
                }
            }
        }
    }

    /**
     * @return the rooms
     */
    public List<Trees> getTreess() {
        return rooms;
    }

    /**
     * @return the marign
     */
    public int getMargin() {
        return this.margin;
    }
}
