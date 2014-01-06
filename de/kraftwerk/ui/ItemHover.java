/*
 * Copyright 2013 by Kraftwerk Productions
 * Do not distribute!
 */
package de.kraftwerk.ui;

import de.kraftwerk.graphics.Fonts;
import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.item.Item;
import de.kraftwerk.item.Item.Stats;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 *
 * @author kainianer
 */
public class ItemHover {

    private final Item item;
    private final int totalHeight;
    private final int totalWidth;
    private final Image corner = UserInterface.ITEMHOVER_CORNER.getTexture();
    private final Image ve = UserInterface.ITEMHOVER_VE.getTexture();
    private final Image ho = UserInterface.ITEMHOVER_HO.getTexture();

    public ItemHover(Item item) {
        this.item = item;
        this.totalWidth = this.getMaxWidth(this.item);
        this.totalHeight = this.getMaxHeight(this.item);
    }

    private int getMaxWidth(Item item) {
        int max = Fonts.TEXT.getTrueTypeFont().getWidth(this.item.getName());

        for (String string : item.getLore()) {
            if (Fonts.TEXT.getTrueTypeFont().getWidth(string) > max) {
                max = Fonts.TEXT.getTrueTypeFont().getWidth(string);
            }
        }

        for (Stats stat : item.getStats().keySet()) {
            if (Fonts.TEXT.getTrueTypeFont().getWidth(stat.name().toLowerCase() + " " + String.valueOf(item.getStats().get(stat))) > max) {
                max = Fonts.TEXT.getTrueTypeFont().getWidth(stat.name().toLowerCase() + " " + String.valueOf(item.getStats().get(stat)));
            }
        }

        return max + 24;
    }

    private int getMaxHeight(Item item) {
        int max = 0;
        max += Fonts.TEXT.getTrueTypeFont().getLineHeight() * (item.getLore().size() + item.getStats().size());
        return max + 72;
    }

    public void draw(Graphics grphcs, int x, int y) {

        this.corner.setImageColor(item.getItemColor().getRed(), item.getItemColor().getGreen(), item.getItemColor().getBlue());
        this.ve.setImageColor(item.getItemColor().getRed(), item.getItemColor().getGreen(), item.getItemColor().getBlue());
        this.ho.setImageColor(item.getItemColor().getRed(), item.getItemColor().getGreen(), item.getItemColor().getBlue());
        x += 8;
        y -= 8;
        y = y - this.totalHeight;
        grphcs.setFont(Fonts.TEXT.getTrueTypeFont());
        grphcs.setColor(new Color(0, 0, 0, 200f / 255f));
        grphcs.fillRect(x, y, this.totalWidth, this.totalHeight);
        grphcs.setColor(this.item.getItemColor());
        grphcs.drawString(this.item.getName(), x + 16, y + 16);
        grphcs.setColor(Color.darkGray);
        grphcs.fillRect(x + 10, y + this.totalHeight - (int) grphcs.getFont().getLineHeight() * this.item.getLore().size() - 8 - 5, this.totalWidth - 20, 5);
        this.corner.draw(x - 5, y);
        this.corner.getFlippedCopy(true, false).draw(x - 5, y + this.totalHeight - 5);
        this.corner.getFlippedCopy(false, true).draw(x + this.totalWidth - 5, y);
        this.corner.draw(x + this.totalWidth - 5, y + this.totalHeight - 5);
        this.ho.draw(x, y, this.totalWidth, 5);
        this.ho.draw(x, y + this.totalHeight, this.totalWidth, 5);
        this.ve.draw(x - 5, y + 5, 5, this.totalHeight - 5);
        this.ve.draw(x + this.totalWidth, y + 5, 5, this.totalHeight - 5);
        grphcs.setColor(Color.gray);

        int k = 0;
        for (Stats stat : this.item.getStats().keySet()) {
            grphcs.drawString(stat.name().toLowerCase(), x + 16, y + 48 + k * Fonts.TEXT.getTrueTypeFont().getLineHeight());
            k++;
        }
    }

}
