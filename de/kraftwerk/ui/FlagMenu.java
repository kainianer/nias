/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.ui;

import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.ui.Menu.MenuType;
import de.kraftwerk.util.Layout;
import org.newdawn.slick.Graphics;

/**
 *
 * @author kainianer
 */
public class FlagMenu extends SubMenu {

    private final TextField field;
    
    public FlagMenu(Layout lout) {
        super(lout, MenuType.MENU_DARK);
        Layout out= new Layout(this.getX() + UserInterface.FLAG.getTexture().getWidth() + 16, this.getY(), this.getWidth() - UserInterface.FLAG.getTexture().getWidth() - 16, this.getHeight());
        this.field = new TextField(out, 16, false);
    }

    @Override
    public void draw(Graphics grphcs) {
        super.draw(grphcs);
        UserInterface.FLAG.getTexture().draw(this.getX() + 16, this.getY());
        this.field.draw(grphcs);
    }

    public void addText(String strng) {
        this.field.addString(strng);
    }
}
