/*
 * Copyright 2013 by Kraftwerk Productions
 * Do not distribute!
 */
package de.kraftwerk.gameinterface;

import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.player.Player;
import de.kraftwerk.stateability.Renderable;
import de.kraftwerk.stateability.Updateable;
import de.kraftwerk.ui.Bar;
import de.kraftwerk.ui.Bar.BarType;
import de.kraftwerk.ui.Component;
import de.kraftwerk.ui.SubComponent;
import de.kraftwerk.util.Layout;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.MouseListener;

/**
 *
 * @author kainianer
 */
public class GameInterface implements Renderable, Updateable {

    private final Player player;
    private final SkillMenu skillMenu;
    private final InventoryMenu invMenu;
    private final List<Component> compList = new ArrayList<>();
    private final Image spellbar;
    private final Bar healthBar;
    private final Bar manaBar;
    private final int barX;
    private final int barY;

    public GameInterface(Player holder) {
        this.player = holder;
        this.skillMenu = new SkillMenu(holder);
        this.invMenu = new InventoryMenu(holder);
        this.skillMenu.setActive(true);
        this.invMenu.setActive(true);
        this.compList.add(skillMenu);
        this.compList.add(invMenu);
        this.spellbar = UserInterface.SPELLBAR.getTexture();
        barX = 1280 / 2 - this.spellbar.getWidth() / 2;
        barY = 720 - this.spellbar.getHeight() - 16;
        this.healthBar = new Bar(new Layout(barX, barY - 16 - UserInterface.BAR_BG.getHeight(), this.spellbar.getWidth() / 2 - 8, 0), BarType.HEALTH);
        this.healthBar.setActive(true);
        this.manaBar = new Bar(new Layout(barX + this.spellbar.getWidth() - this.healthBar.getWidth(), barY - 16 - UserInterface.BAR_BG.getHeight(), this.healthBar.getWidth(), 0), BarType.MANA);
        this.manaBar.setActive(true);
    }

    @Override
    public void draw(Graphics grphcs) {
        if (this.skillMenu.isActive()) {
            this.skillMenu.draw(grphcs);
        }
        if (this.invMenu.isActive()) {
            this.invMenu.draw(grphcs);
        }
        this.spellbar.draw(barX, barY);
        this.healthBar.draw(grphcs);
        this.manaBar.draw(grphcs);
    }

    @Override
    public void update(int delta) {
    }

    public void initListener(GameContainer gc) {
        for (Component comp : this.compList) {
            if (comp.hasSubComponents()) {
                for (SubComponent sub : comp.getSubCmpnt()) {
                    if (sub instanceof KeyListener) {
                        gc.getInput().addKeyListener((KeyListener) sub);
                    }
                    if (sub instanceof MouseListener) {
                        gc.getInput().addMouseListener((MouseListener) sub);
                    }
                }
            }
            if (comp instanceof KeyListener) {
                gc.getInput().addKeyListener((KeyListener) comp);
            }
            if (comp instanceof MouseListener) {
                gc.getInput().addMouseListener((MouseListener) comp);
            }
        }
    }

    public boolean getInventoryVisibility() {
        return this.invMenu.isActive();
    }

    public void setInventoryVisibility(boolean visible) {
        this.invMenu.setActive(visible);
    }

    public boolean getTreeVisibility() {
        return this.skillMenu.isActive();
    }

    public void setTreeVisibility(boolean visible) {
        this.skillMenu.setActive(visible);
    }
}
