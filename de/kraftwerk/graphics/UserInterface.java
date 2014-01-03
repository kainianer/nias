/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.graphics;

import de.kraftwerk.util.Layout;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author kainianer
 */
public enum UserInterface {

    MENU_CORNER(new Layout(64, 0, 8, 8)),
    MENU_BORDER_HO(new Layout(64, 1, 2, 1)),
    MENU_BORDER_VE(new Layout(70, 0, 1, 2)),
    MENU_BACKGROUND(new Layout(70, 5, 1, 1)),
    CARVEDMENU_CORNER(new Layout(64, 32, 8, 8)),
    CARVEDMENU_BORDER_HO(new Layout(64, 33, 2, 1)),
    CARVEDMENU_BORDER_VE(new Layout(70, 32, 1, 2)),
    CARVEDMENU_BACKGROUND(new Layout(70, 37, 1, 1)),
    NOTATION(new Layout(80, 8, 8, 8)),
    BUTTON_NORMAL(new Layout(0, 0, 64, 16)),
    BUTTON_HOVER(new Layout(0, 16, 64, 16)),
    BUTTON_CLICKED(new Layout(0, 32, 64, 16)),
    FLAG(new Layout(112, 8, 16, 32)),
    CLOSEBUTTON_NORMAL(new Layout(0, 48, 11, 11)),
    CLOSEBUTTON_CLICKED(new Layout(11, 48, 11, 11)),
    CLOSEBUTTON_HOVER(new Layout(22, 48, 11, 11)),
    SLIDE(new Layout(88, 8, 8, 16)),
    SLIDE_RAIL(new Layout(88, 24, 8, 8)),
    SLIDE_TOP(new Layout(80, 32, 8, 8)),
    SLIDE_BOT(new Layout(88, 32, 8, 8));

    private Image txtr;

    private UserInterface(Layout lout) {
        try {
            txtr = new Image("/res/sprite.png").getSubImage(lout.getX(), lout.getY(), lout.getWidth(), lout.getHeight());
            txtr.setFilter(Image.FILTER_NEAREST);
            txtr = txtr.getScaledCopy(5f);
        } catch (SlickException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Image getTexture() {
        return this.txtr;
    }

    public int getWidth() {
        return this.txtr.getWidth();
    }

    public int getHeight() {
        return this.txtr.getHeight();
    }

}