/*
 * Copyright 2013 by Kraftwerk Productions
 * Do not distribute!
 */
package de.kraftwerk.gameinterface;

import de.kraftwerk.player.Player;
import de.kraftwerk.ui.Menu;
import de.kraftwerk.util.Layout;

/**
 *
 * @author kainianer
 */
public class SkillMenu extends Menu {

    private final Player holder;

    public SkillMenu(Player holder) {
        super(new Layout(1280 - 16 - (1280 - 32) * 7 / 23 + 8, 64, (1280 - 32) * 7 / 23 - 8, 720 - 64 - 16), MenuType.MENU_DARK);
        this.setHeader("Abilities");
        this.addCloseButton();
        this.holder = holder;
    }

}
