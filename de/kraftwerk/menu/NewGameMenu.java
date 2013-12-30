/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.menu;

import de.kraftwerk.stateability.Renderable;
import de.kraftwerk.ui.FlagMenu;
import de.kraftwerk.ui.Menu;
import de.kraftwerk.ui.SelectMenu;
import de.kraftwerk.ui.SelectTab;
import de.kraftwerk.ui.SubComponent;
import de.kraftwerk.util.Layout;
import org.newdawn.slick.Graphics;

/**
 *
 * @author kainianer
 */
public class NewGameMenu extends Menu {

    public NewGameMenu(Layout lout) {
        super(lout);
        int offSet = (this.getWidth() - 3 * 250 - 40) / 2;
        SelectMenu menu_one = new SelectTab(new Layout(this.getX() + offSet, -300, 250, 500));
        menu_one.setActive(true);

        SelectMenu menu_two = new SelectTab(new Layout(menu_one.getX() + menu_one.getWidth() + 20, -300, 250, 500));
        menu_two.setActive(true);

        SelectMenu menu_three = new SelectTab(new Layout(menu_two.getX() + menu_two.getWidth() + 20, -300, 250, 500));
        menu_three.setActive(true);

        int xF = this.getX() + offSet;
        int yF = menu_one.getYAim() + offSet;
        int widthF = this.getWidth() - offSet * 2;
        int heightF = this.getHeight() - menu_three.getYAim() - 2 * offSet;
        FlagMenu flagMenu = new FlagMenu(new Layout(xF, yF, widthF, heightF));
        flagMenu.setActive(true);

        this.add(menu_one);
        this.add(menu_two);
        this.add(menu_three);
        this.add(flagMenu);
    }

    @Override
    public void draw(Graphics grphcs) {
        for (SubComponent sub : this.getSubCmpnt()) {
            if (sub instanceof Renderable) {
                ((Renderable) sub).draw(grphcs);
            }
        }
    }
}
