/*
 * Copyright 2013 by Kraftwerk Productions
 * Do not distribute!
 */

package de.kraftwerk.buttons;

import de.kraftwerk.states.Title;
import de.kraftwerk.ui.Button;
import de.kraftwerk.ui.Menu;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 *
 * @author kainianer
 */
public class BackTitleButton extends Button {
    
    private final StateBasedGame sbg;
    
    public BackTitleButton(int x, int y, Menu contained, StateBasedGame sbg) {
        super(x, y, "Back to title", contained);
        this.sbg = sbg;
    }
    
    @Override
    public void mouseReleased(int i, int x, int y) {
        super.mouseReleased(i, x, y);
        if (this.isHovered(x, y)) {
            try {
                this.sbg.getState(Title.ID).init(this.sbg.getContainer(), sbg);
                this.sbg.enterState(Title.ID, new FadeOutTransition(), new FadeInTransition());
            } catch (SlickException ex) {
                Logger.getLogger(BackTitleButton.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
