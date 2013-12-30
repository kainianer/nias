/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.ui;

import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.util.Layout;
import org.newdawn.slick.Graphics;

/**
 *
 * @author kainianer
 */
public class FlagMenu extends SubMenu {

    public FlagMenu(Layout lout) {
        super(lout);
    }

    @Override
    public void draw(Graphics grphcs) {
        super.draw(grphcs);
        UserInterface.FLAG.getTexture().draw(this.getX() + 16, this.getY());
    }

}
