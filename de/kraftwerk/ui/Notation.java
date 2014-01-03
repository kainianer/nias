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
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 *
 * @author kainianer
 */
public class Notation extends Component implements Renderable, Updateable {

    private final Image note = UserInterface.NOTATION.getTexture().getScaledCopy(4f);
    private final String str;
    private final int length;
    private int delta;
    private double alpha;
    private boolean fadeIn;

    public Notation(String notation, int length, GameContainer gc) {
        super(0, gc.getHeight() / 2 - UserInterface.NOTATION.getHeight() * 2, gc.getWidth(), UserInterface.NOTATION.getHeight() * 4);
        this.str = notation;
        this.length = length;
        this.fadeIn = true;
    }

    @Override
    public void draw(Graphics grphcs) {

        float al = 1f * (float) alpha / 255;

        this.note.setAlpha(al);
        this.note.draw(0, this.getY(), this.getWidth(), this.getHeight());

        grphcs.setFont(Fonts.HEADER.getTrueTypeFont());
        grphcs.setColor(new Color(Color.white.getRed(), Color.white.getGreen(), Color.white.getBlue(), al));
        grphcs.drawString(this.str, (this.getWidth() - grphcs.getFont().getWidth(str)) / 2, this.getY() + (this.getHeight() - grphcs.getFont().getLineHeight()) / 2);
    }

    @Override
    public void update(int i) {
        if (this.isActive()) {
            if (this.fadeIn) {
                this.delta += i;
                if (this.delta < 1000) {
                    this.alpha = 255 * this.delta / 1000;
                } else {
                    this.fadeIn = false;
                }
            } else {
                this.delta += i;
                if (this.delta > 3000) {
                    this.alpha = 255 - 255 * (this.delta - 3000) / 1000;
                }
                if(this.alpha == 0) {
                    this.setActive(false);
                }
            }
        }
    }

}
