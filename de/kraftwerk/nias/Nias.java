/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.nias;

import de.kraftwerk.states.Title;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.imageout.ImageOut;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

/**
 *
 * @author kainianer
 */
public class Nias extends StateBasedGame {

    /**
     *
     * @param title
     * @throws org.newdawn.slick.SlickException
     */
    public Nias(String title) throws SlickException {
        super(title);
    }

    public void createCursor(GameContainer gc) throws SlickException {
        Image cursor = new Image("res/cursor.png");
        cursor.setFilter(Image.FILTER_NEAREST);
        cursor = cursor.getScaledCopy(2f);
        gc.setMouseCursor(cursor, 0, 0);
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.createCursor(gc);
        this.addState(new Title(gc, this));
    }

    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_F12) {
            try {
                File FileSSDir = new File(ResourceLoader.getResource("/").getPath() + "/screenshots");
                if (!FileSSDir.exists()) {
                    FileSSDir.mkdirs();
                }

                Image image = new Image(this.getContainer().getWidth(), this.getContainer().getHeight());
                this.getContainer().getGraphics().copyArea(image, 0, 0);

                Date dt = new Date();
                SimpleDateFormat sf = new SimpleDateFormat("dd_MM_yy-hh_mm_ss");
                String imageName = "hon_" + sf.format(dt) + ".png";

                ImageOut.write(image, FileSSDir.getAbsolutePath() + "/" + imageName);
                image.destroy();

            } catch (SlickException ex) {
                Logger.getLogger(Nias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
