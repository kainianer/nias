/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.menu;

import de.kraftwerk.buttons.LoadGameButton;
import de.kraftwerk.ui.Menu;
import de.kraftwerk.ui.SlideMenu;
import de.kraftwerk.util.Layout;
import org.newdawn.slick.Graphics;

/**
 *
 * @author kainianer
 */
public class LoadGameMenu extends Menu {

    private final SlideMenu slide;

    public LoadGameMenu(Layout lout) {
        super(lout, MenuType.MENU_DARK);
        super.setHeader("Load Game");
        this.addCancelButton();
        this.addContinueButton(new LoadGameButton(0, 0, this));
        this.slide = new SlideMenu(this.getX(), this.getY() + this.getHeaderHeight(), this.getWidth(), this.getPossibleContentHeight());
        this.add(slide);
    }

    @Override
    public void draw(Graphics grphcs) {
        super.draw(grphcs);
        this.slide.draw(grphcs);
    }

}
