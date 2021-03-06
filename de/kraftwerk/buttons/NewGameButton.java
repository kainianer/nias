/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.buttons;

import de.kraftwerk.states.SingleMenuState;
import de.kraftwerk.ui.Button;
import de.kraftwerk.ui.Menu;

/**
 *
 * @author kainianer
 */
public class NewGameButton extends Button {

    private final Menu menu;
    private final SingleMenuState state;

    public NewGameButton(int x, int y, Menu contained, Menu menu, SingleMenuState state) {
        super(x, y, "New Game", contained);
        this.menu = menu;
        this.state = state;
    }

    @Override
    public void mouseReleased(int i, int x, int y) {
        super.mouseReleased(i, x, y);
        if (this.isHovered(x, y)) {
            if (this.state.getActiveMenu() != null) {
                this.state.getActiveMenu().setActive(false);
            }
            this.menu.setActive(true);
            this.state.setActiveMenu(this.menu);
        }
    }
}
