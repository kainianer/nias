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
import java.util.Random;
import org.newdawn.slick.Graphics;

/**
 *
 * @author kainianer
 */
public class InventoryMenu extends Menu {

    private final Player holder;
    private final List<Slot> slots = new ArrayList<>(20);
    private Slot boundSlot;

    public InventoryMenu(Player holder) {
        super(new Layout(16, 64, (1280 - 32) * 7 / 23 - 8, 720 - 64 - 16), MenuType.MENU_DARK);
        this.addCloseButton();
        this.setHeader("Inventory");
        this.holder = holder;

        int off = this.getX() + (this.getWidth() - 5 * UserInterface.SLOT.getWidth()) / 2;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                Slot slot = new Slot(off + i * UserInterface.SLOT.getWidth(), this.getY() + this.getHeight() - 32 - (j + 1) * UserInterface.SLOT.getHeight(), this);
                if (new Random().nextBoolean()) {
                    slot.setItem(Item.drop());
                }
                this.slots.add(slot);
                this.add(slot);
            }
        }
    }

    @Override
    public void draw(Graphics grphcs) {
        super.draw(grphcs);
        for (int i = this.slots.size() - 1; i >= 0; i--) {
            Slot slot = this.slots.get(i);
            slot.draw(grphcs);
        }

//        int i = 0;
//        grphcs.setFont(Fonts.TEXT.getTrueTypeFont());
//        for (Stats st : this.holder.getStats().keySet()) {
//            grphcs.setColor(Color.lightGray);
//            grphcs.drawString(st.name().toLowerCase(), this.getX() + 152, this.getY() + this.getHeaderHeight() + 16 + i * Fonts.TEXT.getTrueTypeFont().getLineHeight());
//            grphcs.setColor(Color.green);
//            grphcs.drawString(String.valueOf(this.holder.getStats().get(st)), this.getX() + this.getWidth() - 32 - Fonts.TEXT.getTrueTypeFont().getWidth(String.valueOf(this.holder.getStats().get(st))), this.getY() + this.getHeaderHeight() + 16 + i * Fonts.TEXT.getTrueTypeFont().getLineHeight());
//            i++;
//        }
        int off = this.getX() + (this.getWidth() - 5 * UserInterface.SLOT.getWidth()) / 2;
        for (int j = 0; j < 4; j++) {
            UserInterface.SLOT.getTexture().draw(off, this.getY() + j * UserInterface.SLOT.getWidth() + this.getHeaderHeight() + 32);
            UserInterface.SLOT.getTexture().draw(this.getWidth() - UserInterface.SLOT.getWidth() - 20, this.getY() + j * UserInterface.SLOT.getWidth() + this.getHeaderHeight() + 32);
        }

        UserInterface.SLOT.getTexture().draw(this.getX() + this.getWidth() / 2 + 8, this.getY() + 3 * UserInterface.SLOT.getWidth() + this.getHeaderHeight() + 32);
        UserInterface.SLOT.getTexture().draw(this.getX() + this.getWidth() / 2 - UserInterface.SLOT.getWidth() - 8, this.getY() + 3 * UserInterface.SLOT.getWidth() + this.getHeaderHeight() + 32);

        //left animatio
        //this.holder.standa.getCurrentFrame().getScaledCopy(1.25f).draw(this.getX() + 32, this.getY() + this.getHeaderHeight() + 32);
        //centered anmiation
        this.holder.standa.getCurrentFrame().getScaledCopy(1.25f).draw(this.getX() + (this.getWidth() - this.holder.standa.getCurrentFrame().getScaledCopy(1.25f).getWidth()) / 2, this.getY() + this.getHeaderHeight() + 64);

        if (this.hasBoundSlot()) {
            this.boundSlot.getItem().getIcon().draw(this.boundSlot.mouseX - 16, this.boundSlot.mouseY - 16);
        }
    }

    public void setBoundSlot(Slot slot) {
        this.boundSlot = slot;
    }

    public Slot getBoundSlot() {
        return this.boundSlot;
    }

    public boolean hasBoundSlot() {
        return this.boundSlot != null;
    }
}
