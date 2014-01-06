/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.menu;

import de.kraftwerk.buttons.LoginButton;
import de.kraftwerk.buttons.QuitButton;
import de.kraftwerk.buttons.RegisterButton;
import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.ui.InputField;
import de.kraftwerk.ui.Menu;
import de.kraftwerk.util.Layout;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author kainianer
 */
public class LoginMenu extends Menu {

    public LoginMenu(GameContainer gc, StateBasedGame sbg) {
        super(new Layout(0, 0, 0, 0), MenuType.MENU_DARK);
        Layout out = new Layout((gc.getWidth() - 32 - UserInterface.BUTTON_NORMAL.getWidth()) / 2, gc.getHeight() / 2 - 230, UserInterface.BUTTON_NORMAL.getWidth() + 2 * 16, 460);
        this.getLout().merge(out);
        InputField name = new InputField(this.getX() + 16, this.getY() + 32, false, this, "Name");
        InputField pass = new InputField(name.getX(), name.getY() - 8 + UserInterface.BUTTON_NORMAL.getHeight(), true, this, "Password");
        LoginButton login = new LoginButton(pass.getX(), pass.getY() + UserInterface.BUTTON_NORMAL.getHeight() + 8, "Login", this, name, pass, sbg);
        RegisterButton register = new RegisterButton(login.getX(), login.getY() + UserInterface.BUTTON_NORMAL.getHeight() -8, "Register", this);
        QuitButton quit = new QuitButton(register.getX(), register.getY() + 8 + UserInterface.BUTTON_NORMAL.getHeight(), this, gc);

        this.add(name);
        this.add(pass);
        this.add(login);
        this.add(register);
        this.add(quit);
    }
}
