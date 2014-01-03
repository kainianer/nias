/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.buttons;

import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.ui.Button;
import de.kraftwerk.ui.Menu;
import java.awt.Rectangle;
import org.newdawn.slick.Graphics;

/**
 *
 * @author kainianer
 */
public class CloseButton extends Button {

    private final Menu menu;

    public CloseButton(Menu menu) {
        super(menu.getX() + menu.getWidth() - UserInterface.CLOSEBUTTON_NORMAL.getWidth() - 16, menu.getY() + 16, "", menu);
        this.menu = menu;
    }

    @Override
    public void draw(Graphics grphcs) {
        if (this.isHovered()) {
            if (this.isPressed()) {
                UserInterface.CLOSEBUTTON_HOVER.getTexture().draw(this.getX(), this.getY());
            } else {
                UserInterface.CLOSEBUTTON_CLICKED.getTexture().draw(this.getX(), this.getY());
            }
        } else {
            UserInterface.CLOSEBUTTON_NORMAL.getTexture().draw(this.getX(), this.getY());
        }
    }

    @Override
    public void mouseReleased(int i, int x, int y) {
        super.mouseReleased(i, x, y);
        if (this.isHovered(x, y)) {
            this.menu.setActive(false);
        }
    }

    @Override
    public boolean isHovered(int x, int y) {
        return this.menu.isActive() && new Rectangle(this.getX(), this.getY(), 55, 55).contains(x, y);
    }
}
