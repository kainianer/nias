/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.states;

import de.kraftwerk.ui.Menu;

/**
 *
 * @author kainianer
 */
public interface SingleMenuState {

    public Menu getActiveMenu();

    public void setActiveMenu(Menu menu);

}
