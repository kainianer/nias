/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.buttons;

import de.kraftwerk.ui.Button;
import de.kraftwerk.ui.Menu;

/**
 *
 * @author kainianer
 */
public class OptionsButton extends Button {

    private final Menu menu;

    public OptionsButton(int x, int y, Menu menu) {
        super(x, y, "Options");
        this.menu = menu;
    }

    @Override
    public void mousePressed(int i, int x, int y) {
        super.mousePressed(i, x, y);
        if (this.isClicked(x, y)) {
            this.menu.setActive(!this.menu.isActive());
        }
    }

}
