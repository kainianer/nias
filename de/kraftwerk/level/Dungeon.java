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

/**
 *
 * @author kainianer
 */
public class Dungeon extends Level {

    private final int rooms;
    private final int margin;
    private final List<Room> roomList = new ArrayList<>();

    public Dungeon(int size, int rooms, int margin, Player player) {
        super(size, player);
        this.rooms = rooms;
        this.margin = margin;
    }

    public void create() {
        for (int i = 0; i < this.rooms; i++) {

        }
    }

    private Room createRoomDes(Room des, int direction) {
        switch (direction) {
            case 0:
                return new Room(des.getX() + Random.getInteger(0, des.getWidth()), des.getY() + this.margin, Random.getInteger(2, 6), Random.getInteger(2, 6));
            case 1:
                return new Room(des.getX() + des.getWidth() + margin, des.getY() + Random.getInteger(0, des.getWidth()), Random.getInteger(2, 6), Random.getInteger(2, 6));
            case 2:
                return new Room(des.getX() + Random.getInteger(0, des.getWidth()), des.getY() + des.getHeight() + this.margin, Random.getInteger(2, 6), Random.getInteger(2, 6));
            case 3:
                return new Room(des.getX() + Random.getInteger(0, des.getWidth()), des.getY() + this.margin, Random.getInteger(2, 6), Random.getInteger(2, 6));
            default:
                return null;
        }
    }

    private Room createRoom() {
        int x = Random.getInteger(0, this.getSize());
        int y = Random.getInteger(0, this.getSize());
        int width = Random.getInteger(3, 6);
        int height = Random.getInteger(3, 6);

        return new Room(x, y, width, height);
    }

}
