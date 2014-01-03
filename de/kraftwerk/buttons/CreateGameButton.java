/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kraftwerk.buttons;

import de.kraftwerk.states.Game;
import de.kraftwerk.ui.Button;
import de.kraftwerk.ui.Menu;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author kainianer
 */
public class CreateGameButton extends Button {

    private final StateBasedGame sbg;

    public CreateGameButton(int x, int y, StateBasedGame sbg, Menu contained) {
        super(x, y, "CreateGame", contained);
        this.sbg = sbg;
    }

    @Override
    public void mouseReleased(int i, int x, int y) {
        super.mouseReleased(i, x, y);
        if (this.isHovered(x, y)) {
            BasicGameState state = new Game(this.sbg.getContainer(), this.sbg);
            try {
                state.init(this.sbg.getContainer(), this.sbg);
            } catch (SlickException ex) {
                Logger.getLogger(CreateGameButton.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.sbg.addState(state);
            this.sbg.enterState(3);
        }
    }

}
