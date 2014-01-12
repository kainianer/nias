/*
 * Copyright 2013 by Kraftwerk Productions
 * Do not distribute!
 */
package de.kraftwerk.gameinterface;

import de.kraftwerk.graphics.Fonts;
import de.kraftwerk.player.Player;
import de.kraftwerk.ui.Menu;
import de.kraftwerk.util.Layout;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author kainianer
 */
public class SkillMenu extends Menu {

    private final Player holder;
    private Image tree;

    public SkillMenu(Player holder) {
        super(new Layout(1280 - 16 - (1280 - 32) * 7 / 23 + 8, 64, (1280 - 32) * 7 / 23 - 8, 720 - 64 - 16), MenuType.MENU_DARK);
        this.setHeader("Abilities");
        this.addCloseButton();
        this.holder = holder;
        try {
            this.tree = new Image("res/tree.png");
        } catch (SlickException ex) {
            Logger.getLogger(SkillMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.tree.setFilter(Image.FILTER_NEAREST);
        this.tree = this.tree.getScaledCopy(5f);
    }

    @Override
    public void draw(Graphics grphcs) {
        super.draw(grphcs);
        grphcs.setFont(Fonts.TEXT.getTrueTypeFont());
        this.tree.draw(this.getX() + (this.getWidth() - this.tree.getWidth()) / 2, this.getY() + this.getHeaderHeight()+8);
        grphcs.drawString("Skillpoints left: " + this.holder.getSkillPoints(), this.getX() + 32, this.getY() + this.getHeight() - 56);
    }

}
