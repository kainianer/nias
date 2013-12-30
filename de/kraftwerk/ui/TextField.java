/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.ui;

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

    public TextField(Layout lout, String string, int padding, boolean center) {
        super(lout);
        this.padding = padding;
        this.center = center;
        this.list.add(string);
        this.list = this.mergeToWidth(this.list);
    }

    public TextField(Layout lout, List<String> string, int padding, boolean center) {
        super(lout);
        this.padding = padding;
        this.center = center;
        this.list = string;
        this.list = this.mergeToWidth(this.list);
    }

    private List<String> mergeToWidth(List<String> list) {

        for (int i = 0; i < list.size(); i++) {
            String strng = list.get(i);
            if (this.textFont.getWidth(strng + "- ") > this.getWidth() - 2 * this.padding) {
                StringBuilder builder = new StringBuilder();
                String str = strng;
                while (this.textFont.getWidth(str + "- ") > this.getWidth() - 2 * this.padding) {
                    builder.append(str.charAt(str.length() - 1));
                    str = str.substring(0, str.length() - 1);
                    System.out.println(str);
                }
                list.remove(strng);
                list.add(i, str + "-");
                System.out.println(str);
                if (i < list.size() - 1) {
                    String string = list.get(i + 1);
                    list.remove(string);
                    string = builder.reverse().toString() + " " + string;
                    list.add(i + 1, string);
                } else {
                    list.add(builder.reverse().toString());
                }
            }
        }
        return list;
    }

    @Override
    public void draw(Graphics grphcs) {
        grphcs.setColor(Color.white);
        grphcs.setFont(this.textFont);
        for (int i = 0; i < this.list.size(); i++) {
            if (this.center) {
                grphcs.drawString(this.list.get(i), this.getX() + (this.getWidth() - grphcs.getFont().getWidth(this.list.get(i)))/ 2, this.getY() + this.padding + i * grphcs.getFont().getLineHeight());
            } else {
                grphcs.drawString(this.list.get(i), this.getX() + this.padding, this.getY() + this.padding + i * grphcs.getFont().getLineHeight());
            }
        }
    }

}
