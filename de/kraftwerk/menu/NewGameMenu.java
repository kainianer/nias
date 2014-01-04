/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.menu;

import de.kraftwerk.buttons.CreateGameButton;
import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.stateability.Renderable;
import de.kraftwerk.ui.FlagMenu;
import de.kraftwerk.ui.Menu;
import de.kraftwerk.ui.DropdownMenu;
import de.kraftwerk.ui.SubComponent;
import de.kraftwerk.ui.TextField;
import de.kraftwerk.util.Layout;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author kainianer
 */
public class NewGameMenu extends Menu {

    private Animation wiz;
    private Animation ar;
    private final DropdownMenu menu_one;
    private final DropdownMenu menu_two;
    private final DropdownMenu menu_three;

    public NewGameMenu(Layout lout, StateBasedGame sbg) {
        super(lout, MenuType.MENU_DARK);
        try {
            SpriteSheet sprite = new SpriteSheet(new Image("/res/sprite.png").getSubImage(0, 80, 32, 16).getScaledCopy(5f), 80, 80);
            SpriteSheet sprite_two = new SpriteSheet(new Image("/res/sprite.png").getSubImage(32, 80, 32, 16).getScaledCopy(5f), 80, 80);
            this.wiz = new Animation(sprite, 1000);
            this.ar = new Animation(sprite_two, 1200);
        } catch (SlickException ex) {
            Logger.getLogger(NewGameMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

        int offSet = (this.getWidth() - 3 * 250 - 40) / 2;
        this.menu_one = new DropdownMenu(new Layout(this.getX() + offSet, -300, 250, 500), "Archer", MenuType.MENU_DARK);
        this.menu_one.setActive(true);

        this.menu_two = new DropdownMenu(new Layout(this.menu_one.getX() + this.menu_one.getWidth() + 20, -300, 250, 500), "Knight", MenuType.MENU_DARK);
        this.menu_two.setActive(true);

        this.menu_three = new DropdownMenu(new Layout(this.menu_two.getX() + this.menu_two.getWidth() + 20, -300, 250, 500), "Wizard", MenuType.MENU_DARK);
        this.menu_three.setActive(true);

        int xF = this.getX() + offSet;
        int yF = this.menu_one.getYAim() + offSet;
        int widthF = this.getWidth() - offSet * 2;
        int heightF = this.getHeight() - this.menu_three.getYAim() - 2 * offSet;

        FlagMenu flagMenu = new FlagMenu(new Layout(xF, yF, widthF, heightF));
        flagMenu.setActive(true);

        String text = "Choose a class but choose wisely because you can only create on character at a time. Hover over the models in order to see further information about the class.";
        TextField field = new TextField(new Layout(xF + 16 + UserInterface.FLAG.getWidth(), yF, widthF - (UserInterface.FLAG.getWidth() + UserInterface.BUTTON_HOVER.getWidth() - 16), heightF), text, 16, false);
        field.addString("Let the hack begin!");
        CreateGameButton cgb = new CreateGameButton(flagMenu.getX() + flagMenu.getWidth() - UserInterface.BUTTON_NORMAL.getWidth(), flagMenu.getY() + 16, sbg, this);

        this.add(this.menu_one);
        this.add(this.menu_two);
        this.add(this.menu_three);
        this.add(flagMenu);
        this.add(field);
        this.add(cgb);
    }

    @Override
    public void draw(Graphics grphcs) {
        for (SubComponent sub : this.getSubCmpnt()) {
            if (sub instanceof Renderable) {
                ((Renderable) sub).draw(grphcs);
            }
        }
        int xOff = (this.menu_one.getWidth() - this.wiz.getImage(0).getWidth()) / 2;
        int yOff = this.wiz.getImage(0).getHeight() * 2;
        this.wiz.draw(this.menu_one.getX() + xOff, this.menu_one.getY() + this.menu_one.getHeight() - yOff);
        this.ar.draw(this.menu_two.getX() + xOff, this.menu_two.getY() + this.menu_one.getHeight() - yOff);
        this.wiz.draw(this.menu_three.getX() + xOff, this.menu_three.getY() + this.menu_one.getHeight() - yOff);
    }
}
