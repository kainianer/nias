/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.buttons;

import de.kraftwerk.ui.Button;
import de.kraftwerk.ui.Menu;

/**
 *
 * @author kainianer
 */
public class ApplyButton extends Button {

    public ApplyButton(int x, int y, Menu contained) {
        super(x, y, "Apply changes", contained);
    }

    @Override
    public void mouseReleased(int i, int x, int y) {
        super.mouseReleased(i, x, y);
        if(this.isHovered(x, y)) {
            System.out.println("clicked");
        }
    }
}
