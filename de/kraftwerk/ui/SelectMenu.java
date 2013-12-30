/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.ui;

import de.kraftwerk.stateability.Renderable;
import de.kraftwerk.stateability.Updateable;
import de.kraftwerk.util.Layout;
import java.awt.Rectangle;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

/**
 *
 * @author kainianer
 */
public class SelectMenu extends SubComponent implements MouseListener, Updateable, Renderable {

    private boolean pressed;
    private boolean hovered;
    private boolean selected;

    private final int yAim;
    private final int yOrg;

    private Input input;

    private final Menu layout;

    public SelectMenu(Layout lout) {
        super(lout);
        this.layout = new Menu(lout);
        this.yOrg = this.getY();
        this.yAim = this.getHeight() - 64;
    }

    @Override
    public void draw(Graphics grphcs) {
        this.layout.draw(grphcs);
        grphcs.setFont(this.subHeadFont);
        grphcs.drawString("TEST", this.getX() + (this.getWidth() - grphcs.getFont().getWidth("TEST")) / 2, this.getY() + this.getHeight() - grphcs.getFont().getLineHeight() - 24);
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
    public void update() {
        if (this.hovered) {
            if (this.getY() + this.getHeight() < this.yAim) {
                this.setY(this.getY() + (this.yAim - (this.getY() + this.getHeight())) / 8);
            }
        } else {
            if (this.getY() > this.yOrg) {
                this.setY(this.getY() - (this.getY() - this.yOrg) / 5);
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
        if (new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight()).contains(i2, i3)) {
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

    public int getYAim() {
        return this.yAim;
    }

    public int getYOrg() {
        return this.yOrg;
    }
}
