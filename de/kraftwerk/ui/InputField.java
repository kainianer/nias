/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.ui;

import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.stateability.Renderable;
import de.kraftwerk.util.Layout;
import java.awt.Rectangle;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.MouseListener;

/**
 *
 * @author kainianer
 */
public class InputField extends Component implements KeyListener, MouseListener, Renderable {

    private boolean writing;
    private boolean allSelected;
    private final StringBuilder builder;
    private Input input;
    private final Button layout;

    public InputField(int x, int y) {
        super(new Layout(x, y, UserInterface.BUTTON_NORMAL.getWidth(), UserInterface.BUTTON_NORMAL.getHeight()));
        this.builder = new StringBuilder();
        this.layout = new Button(x, y, "");
        this.layout.setHover(true);
        this.layout.setPressed(true);
    }

    private String getText() {
        if (this.builder.length() <= 24) {
            return builder.toString();
        } else {
            return this.builder.subSequence(this.builder.length() - 25, this.builder.length()).toString();
        }
    }

    @Override
    public void draw(Graphics grphcs) {
        layout.draw(grphcs);
        grphcs.setFont(this.textFont);
        grphcs.setColor(Color.white);
        grphcs.drawString(this.getText(), this.getX() + 48, this.getY() + (this.getHeight() - grphcs.getFont().getLineHeight()) / 2);
        if (this.writing) {
            int width = grphcs.getFont().getWidth(this.getText() + "|") + 48;
            grphcs.drawString("_", this.getX() + width, this.getY() + (this.getHeight() - grphcs.getFont().getLineHeight()) / 2 + 2);
        }
    }

    @Override
    public void keyPressed(int i, char c) {
        if (this.writing) {
            if (Character.isLetterOrDigit(c)) {
                this.builder.append(c);
            } else {
                if (i == Input.KEY_BACK) {
                    if (builder.length() > 0) {
                        this.builder.deleteCharAt(this.builder.length() - 1);
                    }
                }
            }
        }
    }

    @Override
    public void keyReleased(int i, char c) {

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

    @Override
    public void mouseWheelMoved(int i) {
    }

    @Override
    public void mouseClicked(int i, int i1, int i2, int i3) {
    }

    @Override
    public void mousePressed(int i, int i1, int i2) {
        if (new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight()).contains(i1, i2)) {
            if (!this.writing) {
                this.writing = true;
            }
        } else {
            if (this.writing) {
                this.writing = false;
            }
        }
    }

    @Override
    public void mouseReleased(int i, int i1, int i2) {
    }

    @Override
    public void mouseMoved(int i, int i1, int i2, int i3) {
    }

    @Override
    public void mouseDragged(int i, int i1, int i2, int i3) {
    }

}
