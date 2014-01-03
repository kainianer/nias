/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.ui;

import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.stateability.Renderable;
import de.kraftwerk.ui.Menu.MenuType;
import de.kraftwerk.util.Layout;
import java.awt.Rectangle;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

/**
 *
 * @author kainianer
 */
public class SlideMenu extends SubComponent implements Renderable, MouseListener {

    private int slideY;
    private boolean clicked;
    private final Menu menu;

    public SlideMenu(int x, int y, int width, int height) {
        super(new Layout(x + 16 + 30, y + 16, width - 32 - 60, height - (height % 16) - 32));
        this.slideY = this.getY();
        this.menu = new Menu(new Layout(this.getX(), this.getY(), this.getWidth() - 16 - UserInterface.SLIDE.getWidth(), this.getHeight()), MenuType.MENU_CARVED);
    }

    @Override
    public void draw(Graphics grphcs) {
        UserInterface.SLIDE_RAIL.getTexture().draw(this.getX() + this.getWidth() - UserInterface.SLIDE.getWidth(), this.getY(), 40, this.getHeight());
        UserInterface.SLIDE_TOP.getTexture().draw(this.getX() + this.getWidth() - UserInterface.SLIDE.getWidth(), this.getY());
        UserInterface.SLIDE_BOT.getTexture().draw(this.getX() + this.getWidth() - UserInterface.SLIDE.getWidth(), this.getY() + this.getHeight() - UserInterface.SLIDE_BOT.getHeight());
        UserInterface.SLIDE.getTexture().draw(this.getX() + this.getWidth() - UserInterface.SLIDE.getWidth(), this.slideY);
        this.menu.draw(grphcs);
    }

    @Override
    public void mouseWheelMoved(int i) {
        if ((this.slideY - this.getY()) % 16 != 0) {
            this.slideY -= (this.slideY - this.getY()) % 16;
        }
        i = i / 30 * 4;
        if (this.slideY - i <= this.getY() + this.getHeight() - UserInterface.SLIDE.getHeight() && this.slideY - i >= this.getY()) {
            this.slideY = this.slideY - i;
        }
    }

    @Override
    public void mouseClicked(int i, int i1, int i2, int i3) {
    }

    @Override
    public void mousePressed(int i, int i1, int i2) {
        this.clicked = this.isClicked(i1, i2);
    }

    @Override
    public void mouseReleased(int i, int i1, int i2) {
        this.clicked = false;
    }

    @Override
    public void mouseMoved(int i, int i1, int i2, int i3) {
    }

    @Override
    public void mouseDragged(int i, int i1, int i2, int i3) {
        if (this.clicked) {
            if (i3 - UserInterface.SLIDE.getHeight() / 2 > this.getY() && i3 < this.getY() + this.getHeight() - UserInterface.SLIDE.getHeight() / 2) {
                this.slideY = i3 - UserInterface.SLIDE.getHeight() / 2;
            }
        }
    }

    @Override
    public void setInput(Input input) {
    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void inputEnded() {
    }

    @Override
    public void inputStarted() {
    }

    private boolean isClicked(int x, int y) {
        return new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight()).contains(x, y);
    }

}
