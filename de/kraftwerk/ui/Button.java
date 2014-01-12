/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.ui;

import de.kraftwerk.graphics.Fonts;
import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.sfx.Sounds;
import de.kraftwerk.stateability.Renderable;
import de.kraftwerk.util.Layout;
import java.awt.Rectangle;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.Sound;

/**
 *
 * @author kainianer
 */
public class Button extends SubComponent implements MouseListener, Renderable {

    private boolean hovered;
    private boolean pressed;
    private final String value;
    private Input input;
    private final Menu contained;
    private final Sound click1;
    private final Sound click2;

    public Button(int x, int y, String value, Menu contained) {
        super(new Layout(x, y, UserInterface.BUTTON_NORMAL.getWidth(), UserInterface.BUTTON_NORMAL.getHeight()));
        this.value = value;
        this.contained = contained;
        this.click1 = Sounds.CLICK1.getSound();
        this.click2 = Sounds.CLICK2.getSound();
    }

    public Button(Layout layout, Menu contained) {
        super(layout);
        this.value = "";
        this.contained = contained;
        this.click1 = Sounds.CLICK1.getSound();
        this.click2 = Sounds.CLICK2.getSound();
    }

    @Override
    public void draw(Graphics grphcs) {
        grphcs.setFont(Fonts.SUB.getTrueTypeFont());
        grphcs.setColor(Color.white);
        if (this.pressed) {
            UserInterface.BUTTON_CLICKED.getTexture().draw(this.getX(), this.getY());
            grphcs.drawString(this.value, this.getX() + 5 + (this.getWidth() - grphcs.getFont().getWidth(this.value)) / 2, this.getY() + 4 + (this.getHeight() - grphcs.getFont().getLineHeight() / 9 * 12) / 2);

        } else if (this.hovered) {
            UserInterface.BUTTON_HOVER.getTexture().draw(this.getX(), this.getY());

            grphcs.drawString(this.value, this.getX() + (this.getWidth() - grphcs.getFont().getWidth(this.value)) / 2, this.getY() + (this.getHeight() - grphcs.getFont().getLineHeight() / 9 * 12) / 2);
        } else {
            UserInterface.BUTTON_NORMAL.getTexture().draw(this.getX(), this.getY());
            grphcs.drawString(this.value, this.getX() + (this.getWidth() - grphcs.getFont().getWidth(this.value)) / 2, this.getY() + (this.getHeight() - grphcs.getFont().getLineHeight() / 9 * 12) / 2);

        }

    }

    @Override
    public void mouseWheelMoved(int i) {
    }

    @Override
    public void mouseClicked(int i, int i1, int i2, int i3) {
    }

    @Override
    public void mousePressed(int i, int i1, int i2) {
        if (this.isHovered(i1, i2)) {
            if (!this.pressed) {
                this.pressed = true;
                this.click1.play(0.5f, 0.5f);
            }
        }
    }

    @Override
    public void mouseReleased(int i, int i1, int i2) {
        if (this.pressed) {
            this.pressed = false;
            this.click2.play(0.5f, 0.5f);
        }
    }

    @Override
    public void mouseMoved(int i, int i1, int i2, int i3) {
        if (this.isHovered(i2, i3)) {
            if (!this.hovered) {
                this.hovered = true;
            }
        } else {
            if (this.hovered) {
                this.hovered = false;
            }
        }
    }

    @Override
    public void mouseDragged(int i, int i1, int i2, int i3) {
    }

    @Override
    public void setInput(Input input) {
        this.input = input;
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

    public void setHover(boolean hover) {
        this.hovered = hover;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public boolean isPressed() {
        return this.pressed;
    }

    public boolean isHovered(int x, int y) {
        return this.contained.isActive() && new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight()).contains(x, y);
    }

    public boolean isHovered() {
        return this.hovered;
    }

}
