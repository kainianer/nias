/*
 * Copyright 2013 by Kraftwerk Productions
 * Do not distribute!
 */
package de.kraftwerk.ui;

import de.kraftwerk.ui.Menu.MenuType;
import de.kraftwerk.util.Layout;
import java.awt.Rectangle;

/**
 *
 * @author kainianer
 */
public class SelectDropDown extends DropdownMenu {

    private boolean selected;
    
    public SelectDropDown(Layout lout, String text, Menu.MenuType type, Menu contained) {
        super(lout, text, type, contained);
    }
    
    @Override
    public void mousePressed(int i, int x, int y)  {
        if(new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight()).contains(x, y)) {
            if(!this.selected) {
                this.getLayoutMenu().setType(Menu.MenuType.MENU_CARVED);
                this.selected = true;
            } else {
                this.getLayoutMenu().setType(MenuType.MENU_DARK);
                this.selected = false;
            }
        }
    }
}
