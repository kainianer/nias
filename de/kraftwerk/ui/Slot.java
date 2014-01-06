/*
 * Copyright 2013 by Kraftwerk Productions
 * Do not distribute!
 */
package de.kraftwerk.ui;

import de.kraftwerk.gameinterface.InventoryMenu;
import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.util.Layout;
import org.newdawn.slick.Graphics;

/**
 *
 * @author kainianer
 */
public class Slot extends Button {

    public Slot(int x, int y, InventoryMenu menu) {
        super(new Layout(x, y, UserInterface.SLOT.getWidth(), UserInterface.SLOT.getHeight()), menu);
    }

    @Override
    public void draw(Graphics grphcs) {
        UserInterface.SLOT.getTexture().draw(this.getX(), this.getY());
    }

    @Override
    public void mousePressed(int i, int x, int y) {
        if (this.isHovered(x, y)) {

        }
    }

    @Override
    public void mouseReleased(int i, int x, int y) {
    }
}
