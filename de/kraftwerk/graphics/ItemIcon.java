/*
 * Copyright 2013 by Kraftwerk Productions
 * Do not distribute!
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
public enum ItemIcon {

    POTION_HEALTH(1, 1),
    POTION_MANA(2, 1),
    COIN(3, 1),
    SCROLL_IDENTIFY(4, 1),
    SCROLL_PORTAL(5, 1),
    GEM(6, 1),
    BOW(7, 1),
    SWORD(8, 1),
    STAFF(9, 1);

    private Image txtr;

    private ItemIcon(int xPos, int yPos) {
        try {
            txtr = new Image("res/items.png").getSubImage((xPos - 1) * 8, (yPos - 1) * 8, 8, 8);
            txtr.setFilter(Image.FILTER_NEAREST);
            txtr = txtr.getScaledCopy(5f);
        } catch (SlickException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Image getTexture() {
        return this.txtr;
    }

    public int getWidth() {
        return this.txtr.getWidth();
    }

    public int getHeight() {
        return this.txtr.getHeight();
    }
}
