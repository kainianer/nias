/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.ui;

import de.kraftwerk.stateability.Renderable;
import de.kraftwerk.ui.Menu.MenuType;
import de.kraftwerk.util.Layout;
import org.newdawn.slick.Graphics;

/**
 *
 * @author kainianer
 */
public class SubMenu extends SubComponent implements Renderable {

    private final Menu menu;

    public SubMenu(Layout lout, MenuType type) {
        super(lout);
        this.menu = new Menu(lout, type);
    }

    @Override
    public void draw(Graphics grphcs) {
        this.menu.draw(grphcs);
    }
}
