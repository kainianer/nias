/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.states;

import de.kraftwerk.buttons.LoadMenuButton;
import de.kraftwerk.buttons.NewGameButton;
import de.kraftwerk.buttons.OptionsButton;
import de.kraftwerk.buttons.QuitButton;
import de.kraftwerk.graphics.Background;
import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.menu.LoadGameMenu;
import de.kraftwerk.menu.NewGameMenu;
import de.kraftwerk.menu.OptionsMenu;
import de.kraftwerk.ui.Menu;
import de.kraftwerk.ui.Menu.MenuType;
import de.kraftwerk.ui.TextField;
import de.kraftwerk.util.Layout;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author kainianer
 */
public class Title extends State implements SingleMenuState {

    public static final int ID = 2;

    private boolean renderFPS = true;
    private Menu activeMenu;
    private Background bg;

    public Title(GameContainer gc, StateBasedGame sbg) {
        super(Title.ID, gc, sbg);
        this.bg = new Background(gc);

        Menu titleMenu = new Menu(new Layout(50, -50, 350, gc.getHeight() + 100), MenuType.MENU_DARK);
        titleMenu.setActive(true);

        NewGameMenu newGame = new NewGameMenu(new Layout(titleMenu.getX() + titleMenu.getWidth(), 0, gc.getWidth() - titleMenu.getWidth() - titleMenu.getX(), gc.getHeight()), sbg);
        int offSet = (newGame.getWidth() - 3 * 250 - 40) / 2;
        LoadGameMenu load = new LoadGameMenu(new Layout(newGame.getX() + offSet, offSet, newGame.getWidth() - 2 * offSet, newGame.getHeight() - 2 * offSet));
        OptionsMenu options = new OptionsMenu(new Layout(newGame.getX() + offSet, offSet, newGame.getWidth() - 2 * offSet, newGame.getHeight() - 2 * offSet));

        int centerOff = titleMenu.getX() + (titleMenu.getWidth() - UserInterface.BUTTON_NORMAL.getWidth()) / 2;
        int height = UserInterface.BUTTON_NORMAL.getHeight();

        NewGameButton button_one = new NewGameButton(centerOff, 250, titleMenu, newGame, this);
        LoadMenuButton button_two = new LoadMenuButton(centerOff, button_one.getY() + height, titleMenu, load, this);
        OptionsButton button_three = new OptionsButton(centerOff, button_two.getY() + height, titleMenu, options, this);
        QuitButton button_four = new QuitButton(centerOff, button_three.getY() + height, titleMenu, gc);

        List<String> list = new ArrayList<>();
        list.add("copyright 2013 by kraftwerk productions");
        TextField copyright = new TextField(new Layout(titleMenu.getX(), button_four.getY() + button_four.getHeight() + 32, titleMenu.getWidth(), 32), list, 16, true);

        titleMenu.add(copyright);
        titleMenu.add(button_one);
        titleMenu.add(button_two);
        titleMenu.add(button_three);
        titleMenu.add(button_four);

        this.addComponent(newGame);
        this.addComponent(load);
        this.addComponent(options);
        this.addComponent(titleMenu);

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        this.bg.draw(grphcs);
        super.render(gc, sbg, grphcs);
    }

    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_F3) {
            this.renderFPS = !this.renderFPS;
        }
    }

    @Override
    public void setActiveMenu(Menu menu) {
        this.activeMenu = menu;
    }

    @Override
    public Menu getActiveMenu() {
        return this.activeMenu;
    }

}
