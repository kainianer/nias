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
public class LoadButton extends Button {

    private final Menu menu;

    public LoadButton(int x, int y, Menu menu) {
        super(x, y, "Load Game");
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
