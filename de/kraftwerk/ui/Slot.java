/*
 * Copyright 2013 by Kraftwerk Productions
 * Do not distribute!
 */
package de.kraftwerk.ui;

import de.kraftwerk.gameinterface.InventoryMenu;
import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.item.Item;
import de.kraftwerk.util.Layout;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/**
 *
 * @author kainianer
 */
public class Slot extends Button {

    private Item containedItem;
    private final InventoryMenu menu;
    public int mouseX;
    public int mouseY;

    public Slot(int x, int y, InventoryMenu menu) {
        super(new Layout(x, y, UserInterface.SLOT.getWidth(), UserInterface.SLOT.getHeight()), menu);
        this.menu = menu;
    }

    @Override
    public void draw(Graphics grphcs) {
        UserInterface.SLOT.getTexture().draw(this.getX(), this.getY());
        if (this.containsItem() && !this.equals(this.menu.getBoundSlot())) {
            this.containedItem.getIcon().draw(this.getX() + 10, this.getY() + 10);
            if (this.isHovered() && !menu.hasBoundSlot()) {
                this.containedItem.drawHover(grphcs, this.mouseX, this.mouseY);
            }
        }
    }

    @Override
    public void mousePressed(int i, int x, int y) {
        if (this.isHovered(x, y)) {
            if (i == Input.MOUSE_LEFT_BUTTON) {
                if (this.containsItem()) {
                    if (this.menu.hasBoundSlot()) {
                        if (this.equals(this.menu.getBoundSlot())) {
                            this.menu.setBoundSlot(null);
                        } else {
                            Item puffer = this.menu.getBoundSlot().getItem();
                            this.menu.getBoundSlot().setItem(this.containedItem);
                            this.containedItem = puffer;
                        }
                    } else {
                        this.menu.setBoundSlot(this);
                    }
                } else {
                    if (this.menu.hasBoundSlot()) {
                        this.containedItem = this.menu.getBoundSlot().containedItem;
                        this.menu.getBoundSlot().containedItem = null;
                        this.menu.setBoundSlot(null);
                    }
                }
            }
        }
    }

    @Override
    public void mouseMoved(int i, int k, int x, int y) {
        super.mouseMoved(i, k, x, y);
        this.mouseX = x;
        this.mouseY = y;
    }

    @Override
    public void mouseReleased(int i, int x, int y) {
        if (this.menu.isActive()) {
            if (this.isHovered(x, y)) {
            }
        }
    }

    public boolean containsItem() {
        return this.containedItem != null;
    }

    public Item getItem() {
        return this.containedItem;
    }

    public void setItem(Item item) {
        this.containedItem = item;
    }

}
