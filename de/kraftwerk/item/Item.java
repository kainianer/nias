/*
 * Copyright 2013 by Kraftwerk Productions
 * Do not distribute!
 */
package de.kraftwerk.item;

import de.kraftwerk.graphics.ItemIcon;
import de.kraftwerk.ui.ItemHover;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 *
 * @author kainianer
 */
public class Item {

    public enum Stats {

        STRENGTH,
        DEXTERITY,
        INTELLIGENCE,
        VITALITY,
        RESISTANCE,
        WISDOM,
        ATTACKSPEED,
        RUNSPEED,
        ENDURANCE;

    }

    private String name;
    private int rarity;
    private Image icon;
    private List<String> lore = new ArrayList<>();
    private Map<Stats, Integer> stats = new HashMap<>();
    private final ItemHover hover;

    public Item(String name, int rarity, Image icon) {
        this.name = name;
        this.rarity = rarity;
        this.icon = icon;
        this.hover = new ItemHover(this);
    }

    public Item(String name, int rarity, Image icon, List<String> lore, Map<Stats, Integer> stats) {
        this.name = name;
        this.rarity = rarity;
        this.icon = icon;
        this.lore = lore;
        this.stats = stats;
        this.hover = new ItemHover(this);
    }

    public static Item drop() {
        Random random = new Random();
        int rarity = random.nextInt(6);
        ItemIcon[] icons = ItemIcon.values();
        Image icon = icons[random.nextInt(icons.length)].getTexture();
        Map<Stats, Integer> stats = new HashMap<>();
        for (int i = 0; i < rarity; i++) {
            Stats[] st = Stats.values();
            Stats stat = st[random.nextInt(st.length - 2) + 1];
            if (!stats.containsKey(stat)) {
                stats.put(stat, random.nextInt(1337));
            } else {
                i--;
            }
        }
        return new Item("TEST", rarity, icon, new ArrayList<String>(), stats);
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
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param rarity the rarity to set
     */
    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(Image icon) {
        this.icon = icon;
    }

    /**
     * @param lore the lore to set
     */
    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    /**
     * @return the stats
     */
    public Map<Stats, Integer> getStats() {
        return stats;
    }

    /**
     * @param stats the stats to set
     */
    public void setStats(Map<Stats, Integer> stats) {
        this.stats = stats;
    }

    public Color getItemColor() {
        switch (this.rarity) {
            default:
                return Color.white;
            case 0:
                return Color.gray;
            case 1:
                return Color.white;
            case 2:
                return Color.blue;
            case 3:
                return Color.yellow;
            case 4:
                return Color.red;
            case 5:
                return Color.green;
        }
    }

    public void drawHover(Graphics grphcs, int x, int y) {
        this.hover.draw(grphcs, x, y);
    }

}
