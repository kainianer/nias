/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.ui;

import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.stateability.Renderable;
import de.kraftwerk.util.Layout;
import org.newdawn.slick.Graphics;

/**
 *
 * @author kainianer
 */
public class Menu extends Component implements Renderable {

    private boolean closeButton;
    private boolean cancelButton;
    private boolean continueButton;
    private String header = null;

    public Menu(Layout lout) {
        super(lout);
    }

    public Menu(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics grphcs) {

        UserInterface.MENU_BACKGROUND.getTexture().draw(this.getX(), this.getY(), this.getWidth(), this.getHeight());

        UserInterface.MENU_BORDER_HO.getTexture().draw(this.getX(), this.getY(), UserInterface.MENU_BORDER_HO.getWidth(), this.getHeight());
        UserInterface.MENU_BORDER_HO.getTexture().getFlippedCopy(true, false).draw(this.getX() + this.getWidth() - UserInterface.MENU_BORDER_HO.getTexture().getWidth(), this.getY(), UserInterface.MENU_BORDER_HO.getTexture().getWidth(), this.getHeight());
        UserInterface.MENU_BORDER_VE.getTexture().draw(this.getX(), this.getY(), this.getWidth(), UserInterface.MENU_BORDER_VE.getHeight());
        UserInterface.MENU_BORDER_VE.getTexture().getFlippedCopy(false, true).draw(this.getX(), this.getY() + this.getHeight() - UserInterface.MENU_BORDER_VE.getHeight(), this.getWidth(), UserInterface.MENU_BORDER_VE.getHeight());

        UserInterface.MENU_CORNER.getTexture().draw(this.getX(), this.getY());
        UserInterface.MENU_CORNER.getTexture().getFlippedCopy(true, false).draw(this.getX() + this.getWidth() - UserInterface.MENU_CORNER.getWidth(), this.getY());
        UserInterface.MENU_CORNER.getTexture().getFlippedCopy(false, true).draw(this.getX(), this.getY() + this.getHeight() - UserInterface.MENU_CORNER.getHeight());
        UserInterface.MENU_CORNER.getTexture().getFlippedCopy(true, true).draw(this.getX() + this.getWidth() - UserInterface.MENU_CORNER.getWidth(), this.getHeight() + this.getY() - UserInterface.MENU_CORNER.getHeight());

        if (header != null) {
            grphcs.drawString(header, this.getX() + (this.getWidth() - grphcs.getFont().getWidth(header)) / 2, this.getY() + 16);
        }

        for (SubComponent sub : this.getSubCmpnt()) {
            if (sub instanceof Renderable) {
                ((Renderable) sub).draw(grphcs);
            }
        }

    }

    public void addCancelButton() {
        if (!this.cancelButton) {
            Layout out = new Layout(this.getX() + 16, this.getHeight() + this.getY() - 16 - UserInterface.BUTTON_NORMAL.getHeight(), UserInterface.BUTTON_NORMAL.getWidth(), UserInterface.BUTTON_NORMAL.getHeight());
            this.add(new Button(out.getX(), out.getY(), "Cancel"));
        }
        this.cancelButton = true;
    }

    public void addContinueButton() {
        if (!this.continueButton) {
            Layout out = new Layout(this.getX() + this.getWidth() - 16 - UserInterface.BUTTON_NORMAL.getWidth(), this.getHeight() + this.getY() - 16 - UserInterface.BUTTON_NORMAL.getHeight(), UserInterface.BUTTON_NORMAL.getWidth(), UserInterface.BUTTON_NORMAL.getHeight());
            this.add(new Button(out.getX(), out.getY(), "Continue"));
        }
        this.continueButton = true;
    }

    public void setHeader(String header) {
        this.header = header;
    }

}
