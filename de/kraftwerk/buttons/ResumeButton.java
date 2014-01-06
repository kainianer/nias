/*
 * Copyright 2013 by Kraftwerk Productions
 * Do not distribute!
 */
package de.kraftwerk.buttons;

import de.kraftwerk.states.Game;
import de.kraftwerk.ui.Button;
import de.kraftwerk.ui.Menu;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author kainianer
 */
public class ResumeButton extends Button {

    private final StateBasedGame sbg;

    public ResumeButton(int x, int y, Menu contained, StateBasedGame sbg) {
        super(x, y, "Resume", contained);
        this.sbg = sbg;
    }

    @Override
    public void mouseReleased(int i, int x, int y) {
        super.mouseReleased(i, x, y);
        if (this.isHovered(x, y)) {
            try {
                this.sbg.getState(Game.ID).init(this.sbg.getContainer(), sbg);
                this.sbg.enterState(Game.ID);
            } catch (SlickException ex) {
                Logger.getLogger(ResumeButton.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
