/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.ui;

import de.kraftwerk.stateability.Renderable;
import de.kraftwerk.util.Layout;
import org.newdawn.slick.Graphics;

/**
 *
 * @author kainianer
 */
public class SubMenu extends SubComponent implements Renderable {

    private final Menu menu;
    
    public SubMenu(Layout lout) {
        super(lout);
        this.menu = new Menu(lout);
    }

    @Override
    public void draw(Graphics grphcs) {
        this.menu.draw(grphcs);
    }

}
