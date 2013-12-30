/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.states;

import de.kraftwerk.buttons.LoadButton;
import de.kraftwerk.buttons.NewGameButton;
import de.kraftwerk.buttons.OptionsButton;
import de.kraftwerk.buttons.QuitButton;
import de.kraftwerk.graphics.Fonts;
import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.menu.LoadGameMenu;
import de.kraftwerk.menu.NewGameMenu;
import de.kraftwerk.menu.OptionsMenu;
import de.kraftwerk.stateability.Renderable;
import de.kraftwerk.stateability.Updateable;
import de.kraftwerk.ui.Component;
import de.kraftwerk.ui.Menu;
import de.kraftwerk.ui.SubComponent;
import de.kraftwerk.ui.TextField;
import de.kraftwerk.util.Layout;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author kainianer
 */
public class Title extends BasicGameState {

    private final List<Component> compList = new ArrayList<>();
    private boolean renderFPS = true;
    private final TrueTypeFont font;

    public Title(GameContainer container) {
        this.font = Fonts.TEXT.getTrueTypeFont();

        Menu titleMenu = new Menu(new Layout(50, -50, 350, container.getHeight() + 100));
        titleMenu.setActive(true);

        NewGameMenu newGame = new NewGameMenu(new Layout(titleMenu.getX() + titleMenu.getWidth(), 0, container.getWidth() - titleMenu.getWidth() - titleMenu.getX(), container.getHeight()));
        int offSet = (newGame.getWidth() - 3 * 250 - 40) / 2;
        LoadGameMenu load = new LoadGameMenu(new Layout(newGame.getX() + offSet, offSet, newGame.getWidth() - 2 * offSet, newGame.getHeight() - 2 * offSet));
        load.addCancelButton();
        load.addContinueButton();
        OptionsMenu options = new OptionsMenu(new Layout(newGame.getX() + offSet, offSet, newGame.getWidth() - 2 * offSet, newGame.getHeight() - 2 * offSet));
        options.addCancelButton();
        options.addContinueButton();

        int centerOff = titleMenu.getX() + (titleMenu.getWidth() - UserInterface.BUTTON_NORMAL.getWidth()) / 2;
        int height = UserInterface.BUTTON_NORMAL.getHeight();

        NewGameButton button_one = new NewGameButton(centerOff, 250, newGame);
        LoadButton button_two = new LoadButton(centerOff, button_one.getY() + height, load);
        OptionsButton button_three = new OptionsButton(centerOff, button_two.getY() + height, options);
        QuitButton button_four = new QuitButton(centerOff, button_three.getY() + height);

        List<String> list = new ArrayList<>();
        list.add("copyright 2013 by");
        list.add("kraftwerk productions");
        TextField copyright = new TextField(new Layout(titleMenu.getX(), button_four.getY() + button_four.getHeight() + 32, titleMenu.getWidth(), 32), list, 16, true);

        titleMenu.add(copyright);
        titleMenu.add(button_one);
        titleMenu.add(button_two);
        titleMenu.add(button_three);
        titleMenu.add(button_four);

        this.compList.add(newGame);
        this.compList.add(load);
        this.compList.add(options);
        this.compList.add(titleMenu);

    }

    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        for (Component comp : this.compList) {
            if (comp.hasSubComponents()) {
                for (SubComponent sub : comp.getSubCmpnt()) {
                    if (sub instanceof MouseListener) {
                        gc.getInput().addMouseListener((MouseListener) sub);
                    }
                }
            }
            if (comp instanceof MouseListener) {
                gc.getInput().addMouseListener((MouseListener) comp);
            }
        }

        for (Component comp : this.compList) {
            if (comp.hasSubComponents()) {
                for (SubComponent sub : comp.getSubCmpnt()) {
                    if (sub instanceof KeyListener) {
                        gc.getInput().addKeyListener((KeyListener) sub);
                    }
                }
            }
            if (comp instanceof KeyListener) {
                gc.getInput().addKeyListener((KeyListener) comp);
            }
        }

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.setBackground(Color.black);
        for (Component cmpnt : this.compList) {
            if (cmpnt.isActive()) {
                if (cmpnt instanceof Renderable) {
                    ((Renderable) cmpnt).draw(grphcs);
                }
            }
        }
        if (this.renderFPS) {
            grphcs.setFont(this.font);
            grphcs.drawString("FPS: " + gc.getFPS(), 10, 10);
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        for (Component comp : this.compList) {
            if (comp.isActive()) {
                if (comp.hasSubComponents()) {
                    for (SubComponent sub : comp.getSubCmpnt()) {
                        if (sub instanceof Updateable) {
                            ((Updateable) sub).update();
                        }
                    }
                }
                if (comp instanceof Updateable) {
                    ((Updateable) comp).update();
                }
            }
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_F3) {
            this.renderFPS = !this.renderFPS;
        }
    }

}
