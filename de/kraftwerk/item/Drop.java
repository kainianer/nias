/*
 * Copyright 2013 by Kraftwerk Productions
 * Do not distribute!
 */
package de.kraftwerk.item;

import de.kraftwerk.graphics.Fonts;
import de.kraftwerk.stateability.Updateable;
import de.kraftwerk.ui.SubComponent;
import de.kraftwerk.util.Layout;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;

/**
 *
 * @author kainianer
 */
public class Drop extends SubComponent implements MouseListener, Updateable {

    private final Item item;
    private boolean hovered;
    private int screenx;
    private int screeny;
    private Image shadow;
    private float sin;

    public Drop(int x, int y, Item item) {
        super(new Layout(x, y, Fonts.TEXT.getTrueTypeFont().getWidth(item.getName()) + 8, Fonts.TEXT.getTrueTypeFont().getLineHeight() + 4));
        this.item = item;
        try {
            this.shadow = new Image("res/sprite.png").getSubImage(96, 96, 16, 8).getScaledCopy(5f);
        } catch (SlickException ex) {
            Logger.getLogger(Drop.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void draw(Graphics grphcs, int x, int y) {
        this.screeny = y;
        this.screenx = x;
        grphcs.setColor(new Color(0, 0, 0, 155));
        grphcs.fillRect(x, y, this.getWidth(), this.getHeight());
        grphcs.setColor(this.item.getItemColor());
        grphcs.setFont(Fonts.TEXT.getTrueTypeFont());
        grphcs.drawString(this.item.getName(), x + this.getWidth() / 2 - Fonts.TEXT.getTrueTypeFont().getWidth(this.item.getName()) / 2, y + this.getHeight() / 2 - Fonts.TEXT.getTrueTypeFont().getLineHeight() / 2);
        if (this.hovered) {
            this.item.drawHover(grphcs, x, y);
        }
        Image shad = this.shadow.getScaledCopy(0.75f + Math.abs((float) Math.sin(this.sin / 2 + 1) / 8));
        shad.draw(x + (Fonts.TEXT.getTrueTypeFont().getWidth(this.item.getName()) - shad.getWidth()) / 2, y + this.item.getIcon().getHeight() * 5 / 2);
        this.item.getIcon().draw(x - (Fonts.TEXT.getTrueTypeFont().getWidth(this.item.getName()) - this.item.getIcon().getWidth()) / 2 + 8, y + 48 + (int) (Math.sin(this.sin) * 10));
        System.out.println(this.sin);
    }

    @Override
    public void mouseMoved(int i, int i2, int x, int y) {
        if (this.isHovered(x, y)) {
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
    public void mouseDragged(int i, int i1, int i2, int i3) {
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

    public boolean isHovered(int x, int y) {
        return new Rectangle(this.screenx, this.screeny, this.getWidth(), this.getHeight()).contains(x, y);
    }

    public boolean isHovered() {
        return this.hovered;
    }

    @Override
    public void update(int delta) {
        this.sin += 0.1 * delta / 20;
    }
}
