/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.ui;

import de.kraftwerk.graphics.Fonts;
import de.kraftwerk.util.Layout;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.TrueTypeFont;

/**
 *
 * @author kainianer
 */
public class Component {
    
    public final TrueTypeFont headFont = Fonts.HEADER.getTrueTypeFont();
    public final TrueTypeFont subHeadFont = Fonts.SUB.getTrueTypeFont();
    public final TrueTypeFont textFont = Fonts.TEXT.getTrueTypeFont();
    private Layout lout;
    private boolean isActive = false;
    private final List<SubComponent> subCmpnt = new ArrayList<>();
    
    public Component(Layout lout) {
        this.lout = lout;
    }
    
    public Component(int x, int y, int width, int height) {
        this.lout = new Layout(x, y, width, height);
    }

    /**
     * @param subcmpnt to add
     */
    public void add(SubComponent subcmpnt) {
        this.getSubCmpnt().add(subcmpnt);
    }

    /**
     * @return the lout
     */
    public Layout getLout() {
        return lout;
    }

    /**
     * @param lout the lout to set
     */
    public void setLout(Layout lout) {
        this.lout = lout;
    }

    /**
     * @return the subCmpnt
     */
    public List<SubComponent> getSubCmpnt() {
        return subCmpnt;
    }
    
    public int getX() {
        return this.lout.getX();
    }
    
    public int getY() {
        return this.lout.getY();
    }
    
    public int getWidth() {
        return this.lout.getWidth();
    }
    
    public int getHeight() {
        return this.lout.getHeight();
    }
    
    public void setX(int x) {
        this.lout.setX(x);
    }
    
    public void setY(int y) {
        this.lout.setY(y);
    }
    
    public boolean isActive() {
        return this.isActive;
    }
    
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    public boolean hasSubComponents() {
        return this.subCmpnt.size() > 0;
    }
}
