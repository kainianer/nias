/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.ui;

import de.kraftwerk.graphics.Fonts;
import de.kraftwerk.sfx.Sounds;
import de.kraftwerk.stateability.Renderable;
import de.kraftwerk.stateability.Updateable;
import de.kraftwerk.ui.Menu.MenuType;
import de.kraftwerk.util.Layout;
import java.awt.Rectangle;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.Sound;

/**
 *
 * @author kainianer
 */
public class DropdownMenu extends SubComponent implements MouseListener, Updateable, Renderable {

    private boolean hovered;
    private boolean selected;

    private final int yAim;
    private final int yOrg;

    private Input input;

    private final String text;
    private final Menu layout;

    private final Sound sound;
    private final Menu contained;

    public DropdownMenu(Layout lout, String text, MenuType type, Menu contained) {
        super(lout);
        this.layout = new Menu(lout, type);
        this.yOrg = this.getY();
        this.yAim = this.getHeight() - 64;
        this.text = text;
        this.sound = Sounds.DROPDOWN.getSound();
        this.contained = contained;
    }

    @Override
    public void draw(Graphics grphcs) {
        this.layout.draw(grphcs);
        grphcs.setFont(Fonts.SUB.getTrueTypeFont());
        grphcs.drawString(this.text, this.getX() + (this.getWidth() - grphcs.getFont().getWidth(this.text)) / 2, this.getY() + this.getHeight() - grphcs.getFont().getLineHeight() - 24);
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public void update(int i) {
        if (this.contained.isActive()) {
            if (this.hovered) {
                if (this.getY() + this.getHeight() < this.yAim) {
                    this.setY(this.getY() + (this.yAim - (this.getY() + this.getHeight())) * i / 100);
                }
            } else {
                if (this.getY() > this.yOrg) {
                    this.setY(this.getY() - (this.getY() - this.yOrg) * i / 100);
                }
            }
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
    }

    @Override
    public void mouseReleased(int i, int i1, int i2) {
    }

    @Override
    public void mouseMoved(int i, int i1, int i2, int i3) {
        if (this.contained.isActive()) {
            if (new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight()).contains(i2, i3)) {
                if (!this.hovered) {
                    this.hovered = true;
                    if (!this.sound.playing()) {
                        this.sound.play(1f, 0.5f);
                    }
                }
            } else {
                if (this.hovered) {
                    this.hovered = false;
                }
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

    public int getYAim() {
        return this.yAim;
    }

    public int getYOrg() {
        return this.yOrg;
    }

    public Menu getLayoutMenu() {
        return this.layout;
    }
}
