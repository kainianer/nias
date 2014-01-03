/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.ui;

import de.kraftwerk.graphics.Fonts;
import de.kraftwerk.stateability.Renderable;
import de.kraftwerk.util.Layout;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 *
 * @author kainianer
 */
public class TextField extends SubComponent implements Renderable {

    private List<String> list = new ArrayList<>();
    private final int padding;
    private final boolean center;

    public TextField(Layout lout, int padding, boolean center) {
        super(lout);
        this.padding = padding;
        this.center = center;
    }

    public TextField(Layout lout, String string, int padding, boolean center) {
        super(lout);
        this.padding = padding;
        this.center = center;
        this.list.add(string);
        this.list = new ArrayList<>(this.mergeToWidth(this.list));
    }

    public TextField(Layout lout, List<String> string, int padding, boolean center) {
        super(lout);
        this.padding = padding;
        this.center = center;
        this.list = string;
        this.list = new ArrayList<>(this.mergeToWidth(this.list));
    }

    public void addString(String strng) {
        this.list.add(strng);
    }

    private List<String> mergeToWidth(List<String> list) {
        String str = "";
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            str += list.get(i) + " ";
        }
        String[] string = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String string1 : string) {
            if (Fonts.TEXT.getTrueTypeFont().getWidth(builder.toString()  + " " + string1) < this.getWidth() - 2 * this.padding) {
                builder.append(string1).append(" ");
            } else {
                stringList.add(builder.toString());
                builder = new StringBuilder();
                builder.append(string1).append(" ");
            }
        }
        stringList.add(builder.toString());
        return stringList;
    }

    @Override
    public void draw(Graphics grphcs) {
        grphcs.setColor(Color.white);
        grphcs.setFont(Fonts.TEXT.getTrueTypeFont());
        for (int i = 0; i < this.list.size(); i++) {
            if (this.center) {
                grphcs.drawString(this.list.get(i), this.getX() + (this.getWidth() - grphcs.getFont().getWidth(this.list.get(i))) / 2, this.getY() + this.padding + i * grphcs.getFont().getLineHeight());
            } else {
                grphcs.drawString(this.list.get(i), this.getX() + this.padding, this.getY() + this.padding + i * grphcs.getFont().getLineHeight());
            }
        }
    }
}
