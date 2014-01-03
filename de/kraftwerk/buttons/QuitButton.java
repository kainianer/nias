/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.buttons;

import de.kraftwerk.ui.Button;
import de.kraftwerk.ui.Menu;
import org.newdawn.slick.GameContainer;

/**
 *
 * @author kainianer
 */
public class QuitButton extends Button {

    private final GameContainer gc;

    public QuitButton(int x, int y, Menu menu, GameContainer gc) {
        super(x, y, "Quit", menu);
        this.gc = gc;
    }

    @Override
    public void mouseReleased(int i, int x, int y) {
        super.mouseReleased(i, x, y);

        if (this.isHovered(x, y)) {
            this.gc.exit();
        }
    }

}
