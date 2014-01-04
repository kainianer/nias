/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.ui;

import de.kraftwerk.graphics.Fonts;
import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.stateability.Renderable;
import de.kraftwerk.stateability.Updateable;
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
public class InputField extends SubComponent implements KeyListener, MouseListener, Renderable, Updateable {

    private boolean writing;
    private boolean allSelected;
    private final StringBuilder builder;
    private final StringBuilder passBuilder;
    private Input input;
    private final Button layout;
    private final boolean pass;
    private int delta;
    private boolean bar;
    private final String value;

    public InputField(int x, int y, boolean pass, Menu menu, String value) {
        super(new Layout(x, y, UserInterface.BUTTON_NORMAL.getWidth(), UserInterface.BUTTON_NORMAL.getHeight()));
        this.builder = new StringBuilder();
        this.passBuilder = new StringBuilder();
        this.layout = new Button(x, y, "", menu);
        this.layout.setHover(true);
        this.layout.setPressed(true);
        this.pass = pass;
        this.value = value;
    }

    private String getText() {
        if (Fonts.TEXT.getTrueTypeFont().getWidth(this.builder.toString() + " _") < this.getWidth() - 80) {
            if (!this.pass) {
                return this.builder.toString();
            } else {
                return this.passBuilder.toString();
            }
        } else {
            if (!this.pass) {
                String str = this.builder.toString();
                for (int i = 0; i < this.builder.length() && Fonts.TEXT.getTrueTypeFont().getWidth(str + " _") > this.getWidth() - 80; i++) {
                    str = this.builder.substring(i, this.builder.length());
                }
                return str;
            } else {
                String str = this.passBuilder.toString();
                for (int i = 0; i < this.passBuilder.length() && Fonts.TEXT.getTrueTypeFont().getWidth(str + " _") > this.getWidth() - 80; i++) {
                    str = this.passBuilder.substring(i, this.passBuilder.length());
                }
                return str;
            }
        }
    }

    @Override
    public void draw(Graphics grphcs) {
        layout.draw(grphcs);
        grphcs.setFont(Fonts.TEXT.getTrueTypeFont());
        if (!this.writing && this.getText().isEmpty()) {
            grphcs.setColor(Color.lightGray);
            grphcs.drawString(this.value, this.getX() + 48, this.getY() + (this.getHeight() - grphcs.getFont().getLineHeight()) / 2);
        } else {
            if (this.writing && this.bar) {
                grphcs.setColor(Color.white);
                int width = grphcs.getFont().getWidth(this.getText() + "_") + 36;
                grphcs.drawString("_", this.getX() + width, this.getY() + (this.getHeight() - grphcs.getFont().getLineHeight()) / 2);
            }
            grphcs.drawString(this.getText(), this.getX() + 48, this.getY() + (this.getHeight() - grphcs.getFont().getLineHeight()) / 2);
        }
    }

    @Override
    public void keyPressed(int i, char c) {
        if (this.writing) {
            if (Character.isLetterOrDigit(c)) {
                this.builder.append(c);
                this.passBuilder.append('*');
            } else {
                if (i == Input.KEY_BACK) {
                    if (builder.length() > 0) {
                        this.builder.deleteCharAt(this.builder.length() - 1);
                        this.passBuilder.deleteCharAt(this.passBuilder.length() - 1);
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

    @Override
    public void update(int delta) {
        if (this.delta + delta <= 1000) {
            if (!this.bar) {
                this.bar = true;
            }
        } else {
            if (this.bar) {
                this.bar = false;
            }
        }
        this.delta += delta;
        if (this.delta >= 2000) {
            this.delta = 0;
        }
    }

    public String getInput() {
        return this.builder.toString();
    }
    
}
