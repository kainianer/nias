/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.buttons;

import de.kraftwerk.sfx.Sounds;
import de.kraftwerk.states.State;
import de.kraftwerk.states.Title;
import de.kraftwerk.ui.Button;
import de.kraftwerk.ui.InputField;
import de.kraftwerk.ui.Menu;
import de.kraftwerk.util.MySQL;
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
public class LoginButton extends Button {

    private final InputField name;
    private final InputField password;
    private final StateBasedGame sbg;

    public LoginButton(int x, int y, String value, Menu contained, InputField name, InputField password, StateBasedGame sbg) {
        super(x, y, value, contained);
        this.name = name;
        this.password = password;
        this.sbg = sbg;
    }

    @Override
    public void mouseReleased(int i, int x, int y) {
        super.mouseReleased(i, x, y);
        if (this.isHovered(x, y)) {
            MySQL mysql = new MySQL();
            mysql.connect();
            boolean logged = mysql.verify(this.name.getInput(), this.password.getInput());
            if (logged) {
                State state = new Title(this.sbg.getContainer(), this.sbg);
                try {
                    state.init(this.sbg.getContainer(), this.sbg);
                } catch (SlickException ex) {
                    Logger.getLogger(LoginButton.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.sbg.addState(state);
                this.sbg.enterState(Title.ID, new FadeOutTransition(), new FadeInTransition());
            } else {
                Sounds.LOGIN_FAIL.getSound().play(1f, 0.5f);
            }
        }
    }
}
