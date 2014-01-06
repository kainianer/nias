/*
 * Copyright 2013 by Kraftwerk Productions
 * Do not distribute!
 */
package de.kraftwerk.item;

import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.Image;

/**
 *
 * @author kainianer
 */
public class Item {

    private final String name;
    private final int rarity;
    private final Image icon;
    private List<String> lore = new ArrayList<>();

    public Item(String name, int rarity, Image icon) {
        this.name = name;
        this.rarity = rarity;
        this.icon = icon;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the rarity
     */
    public int getRarity() {
        return rarity;
    }

    /**
     * @return the icon
     */
    public Image getIcon() {
        return icon;
    }

    /**
     * @return the lore
     */
    public List<String> getLore() {
        return lore;
    }

    /**
     * @param lore the lore to set
     */
    public void setLore(List<String> lore) {
        this.lore = lore;
    }
}
