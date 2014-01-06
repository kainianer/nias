/*
 * Copyright 2013 by Kraftwerk Productions
 * Do not distribute!
 */
package de.kraftwerk.gameinterface;

import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.item.Item;
import de.kraftwerk.player.Player;
import de.kraftwerk.ui.Menu;
import de.kraftwerk.ui.Slot;
import de.kraftwerk.util.Layout;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.Graphics;

/**
 *
 * @author kainianer
 */
public class InventoryMenu extends Menu {

    private final Player holder;
    private final List<Slot> slots = new ArrayList<>(20);
    private Item boundItem;

    public InventoryMenu(Player holder) {
        super(new Layout(16, 64, (1280 - 32) * 7 / 23 - 8, 720 - 64 - 16), MenuType.MENU_DARK);
        this.addCloseButton();
        this.setHeader("Inventory");
        this.holder = holder;

        int off = this.getX() + (this.getWidth() - 5 * UserInterface.SLOT.getWidth()) / 2;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                Slot slot = new Slot(off + i * UserInterface.SLOT.getWidth(), this.getY() + this.getHeight() - 32 - (j + 1) * UserInterface.SLOT.getHeight(), this);
                slot.setItem(Item.drop());
                this.slots.add(slot);
                this.add(slot);
            }
        }
    }

    @Override
    public void draw(Graphics grphcs) {
        super.draw(grphcs);
        for (int i= this.slots.size()-1; i >= 0; i--) {
            Slot slot = this.slots.get(i);
            slot.draw(grphcs);
        }
    }

    public void setBoundItem(Item item) {
        this.boundItem = item;
    }

    public Item getBoundItem() {
        return this.boundItem;
    }

    public boolean hasBoundItem() {
        return this.boundItem != null;
    }

}
