/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.ui;

import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.stateability.Renderable;
import de.kraftwerk.stateability.Updateable;
import de.kraftwerk.util.Layout;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 *
 * @author kainianer
 */
public class Bar extends Component implements Renderable, Updateable {

    public enum BarType {

        HEALTH(0),
        MANA(1),
        CASTBAR(2);

        private Image texture;

        private BarType(int i) {
            switch (i) {
                case 0:
                    this.texture = UserInterface.HEALTHBAR.getTexture();
                    break;
                case 1:
                    this.texture = UserInterface.MANABAR.getTexture();
                    break;
                case 2:
                    this.texture = UserInterface.CASTBAR.getTexture();
                    break;
            }
        }
        
        public Image getTexture() {
            return this.texture;
        }
    }

    private final BarType type;
    
    public Bar(Layout lout, BarType type) {
        super(new Layout(lout.getX(), lout.getY(), lout.getWidth(), UserInterface.BAR_BG.getHeight()));
        this.type = type;
    }

    @Override
    public void draw(Graphics grphcs) {
        UserInterface.BAR_BG.getTexture().draw(this.getX() + 5, this.getY(), this.getWidth() - 10, this.getHeight());
        UserInterface.BAR_LEFT.getTexture().draw(this.getX() - UserInterface.BAR_LEFT.getWidth() + 10, this.getY());
        UserInterface.BAR_RIGHT.getTexture().draw(this.getX() + this.getWidth() - 10, this.getY());
        this.type.getTexture().draw(this.getX() + 5, this.getY() + 5, this.getWidth() - 10, this.getHeight() - 10);
    }

    @Override
    public void update(int i) {
    }

}
