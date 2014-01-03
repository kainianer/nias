/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.menu;

import de.kraftwerk.buttons.ApplyButton;
import de.kraftwerk.ui.Menu;
import de.kraftwerk.util.Layout;

/**
 *
 * @author kainianer
 */
public class OptionsMenu extends Menu {

    public OptionsMenu(Layout lout) {
        super(lout, MenuType.MENU_DARK);
        super.setHeader("Options");
        this.addCancelButton();
        this.addContinueButton(new ApplyButton(0, 0, this));
    }

}
