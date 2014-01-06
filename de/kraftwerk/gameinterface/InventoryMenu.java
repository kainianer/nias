/*
 * Copyright 2013 by Kraftwerk Productions
 * Do not distribute!
 */
package de.kraftwerk.gameinterface;

import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.player.Player;
import de.kraftwerk.ui.Menu;
import de.kraftwerk.util.Layout;
import org.newdawn.slick.Graphics;

/**
 *
 * @author kainianer
 */
public class InventoryMenu extends Menu {

    private final Player holder;

    public InventoryMenu(Player holder) {
        super(new Layout(16, 64, (1280 - 32) * 7 / 23 - 8, 720 - 64 - 16), MenuType.MENU_DARK);
        this.addCloseButton();
        this.setHeader("Inventory");
        this.holder = holder;
    }

    @Override
    public void draw(Graphics grphcs) {
        super.draw(grphcs);
        int off = this.getX() + (this.getWidth() - 5 * UserInterface.SLOT.getWidth()) / 2;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                UserInterface.SLOT.getTexture().draw(off + i * UserInterface.SLOT.getWidth(), this.getY() + this.getHeight() - 32 - (j+1) * UserInterface.SLOT.getHeight());
            }
        }
    }

}
