/*
 * Copyright 2013 by Kraftwerk Productions
 * Do not distribute!
 */

package de.kraftwerk.inventory;

import de.kraftwerk.player.Player;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.tests.xml.Item;

/**
 *
 * @author kainianer
 */
public class Inventory {
    
    private final Player holder;
    private List<Item> itemList = new ArrayList<>(20);
    
    public Inventory(Player holder) {
        this.holder = holder;
    }
    
    public Player getHolder() {
        return this.holder;
    }
    
    public boolean hasFreeSlot() {
        return this.itemList.size() < 20;
    }
    
    public void addItem(Item item) {
        if(this.hasFreeSlot())  {
            this.itemList.add(item);
        }
    }
    
    public List<Item> getItems() {
        return this.itemList;
    }
}
