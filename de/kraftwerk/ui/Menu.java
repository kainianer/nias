/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.ui;

import de.kraftwerk.buttons.CancelButton;
import de.kraftwerk.buttons.CloseButton;
import de.kraftwerk.graphics.Fonts;
import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.stateability.Renderable;
import de.kraftwerk.util.Layout;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 *
 * @author kainianer
 */
public class Menu extends Component implements Renderable {

    private boolean closeButton;
    private boolean cancelButton;
    private boolean continueButton;
    private String header = null;
    private final MenuType type;

    public enum MenuType {

        MENU_BRIGHT(1),
        MENU_DARK(2),
        MENU_CARVED(3);

        private Image background;
        private Image border_ho;
        private Image border_ve;
        private Image corner;

        private MenuType(int i) {
            switch (i) {
                case 1:
                    this.background = UserInterface.MENU_BACKGROUND.getTexture();
                    this.border_ho = UserInterface.MENU_BORDER_HO.getTexture();
                    this.border_ve = UserInterface.MENU_BORDER_VE.getTexture();
                    this.corner = UserInterface.MENU_CORNER.getTexture();
                    break;
                case 2:
                    this.background = UserInterface.MENU_BACKGROUND.getTexture();
                    this.border_ho = UserInterface.MENU_BORDER_HO.getTexture();
                    this.border_ve = UserInterface.MENU_BORDER_VE.getTexture();
                    this.corner = UserInterface.MENU_CORNER.getTexture();
                    break;
                case 3:
                    this.background = UserInterface.CARVEDMENU_BACKGROUND.getTexture();
                    this.border_ho = UserInterface.CARVEDMENU_BORDER_HO.getTexture();
                    this.border_ve = UserInterface.CARVEDMENU_BORDER_VE.getTexture();
                    this.corner = UserInterface.CARVEDMENU_CORNER.getTexture();
                    break;
            }
        }

        public Image getBackground() {
            return this.background;
        }

        public Image getCorner() {
            return this.corner;
        }

        public Image getBackgroundHorizontal() {
            return this.border_ho;
        }

        public Image getBackgroundVertical() {
            return this.border_ve;
        }

    }

    public Menu(Layout lout, MenuType type) {
        super(lout);
        this.type = type;
    }

    public Menu(int x, int y, int width, int height, MenuType type) {
        super(x, y, width, height);
        this.type = type;
    }

    @Override
    public void draw(Graphics grphcs) {

        this.type.getBackground().draw(this.getX(), this.getY(), this.getWidth(), this.getHeight());

        this.type.getBackgroundHorizontal().draw(this.getX(), this.getY(), UserInterface.MENU_BORDER_HO.getWidth(), this.getHeight());
        this.type.getBackgroundHorizontal().getFlippedCopy(true, false).draw(this.getX() + this.getWidth() - UserInterface.MENU_BORDER_HO.getTexture().getWidth(), this.getY(), UserInterface.MENU_BORDER_HO.getTexture().getWidth(), this.getHeight());
        this.type.getBackgroundVertical().draw(this.getX(), this.getY(), this.getWidth(), UserInterface.MENU_BORDER_VE.getHeight());
        this.type.getBackgroundVertical().getFlippedCopy(false, true).draw(this.getX(), this.getY() + this.getHeight() - UserInterface.MENU_BORDER_VE.getHeight(), this.getWidth(), UserInterface.MENU_BORDER_VE.getHeight());

        this.type.getCorner().draw(this.getX(), this.getY());
        this.type.getCorner().getFlippedCopy(true, false).draw(this.getX() + this.getWidth() - UserInterface.MENU_CORNER.getWidth(), this.getY());
        this.type.getCorner().getFlippedCopy(false, true).draw(this.getX(), this.getY() + this.getHeight() - UserInterface.MENU_CORNER.getHeight());
        this.type.getCorner().getFlippedCopy(true, true).draw(this.getX() + this.getWidth() - UserInterface.MENU_CORNER.getWidth(), this.getHeight() + this.getY() - UserInterface.MENU_CORNER.getHeight());

        if (header != null) {
            grphcs.setColor(Color.white);
            grphcs.setFont(Fonts.SUB.getTrueTypeFont());
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
            this.add(new CancelButton(this));
        }
        this.cancelButton = true;
    }

    public void addContinueButton(Button button) {
        if (!this.continueButton) {
            Layout out = new Layout(this.getX() + this.getWidth() - 16 - UserInterface.BUTTON_NORMAL.getWidth(), this.getHeight() + this.getY() - 16 - UserInterface.BUTTON_NORMAL.getHeight(), UserInterface.BUTTON_NORMAL.getWidth(), UserInterface.BUTTON_NORMAL.getHeight());
            button.getLout().merge(out);
            this.add(button);
        }
        this.continueButton = true;
    }

    public void addCloseButton() {
        if (!this.closeButton) {
            this.add(new CloseButton(this));
        }
        this.closeButton = true;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public int getHeaderHeight() {
        if (this.header != null) {
            return 16 + Fonts.SUB.getTrueTypeFont().getLineHeight();
        } else {
            return 0;
        }
    }

    public int getButtonOffset() {
        if (this.cancelButton || this.continueButton) {
            return UserInterface.BUTTON_NORMAL.getHeight() + 16;
        } else {
            return 0;
        }
    }

    public int getPossibleContentHeight() {
        return this.getHeight() - this.getHeaderHeight() - this.getButtonOffset();
    }

}
