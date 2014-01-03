/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.buttons;

import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.ui.Button;
import de.kraftwerk.ui.Menu;

/**
 *
 * @author kainianer
 */
public class CancelButton extends Button {

    private final Menu menu;

    public CancelButton(Menu menu) {
        super(menu.getX() + 16, menu.getY() + menu.getHeight() - UserInterface.BUTTON_NORMAL.getHeight() - 16, "Cancel", menu);
        this.menu = menu;
    }

    @Override
    public void mouseReleased(int i, int x, int y) {
        super.mouseReleased(i, x, y);
        if(this.isHovered(x, y)) {
            System.out.println("PRESSED");
            this.menu.setActive(false);
        }
    }

}
