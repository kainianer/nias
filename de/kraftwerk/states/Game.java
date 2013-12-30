/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.states;

import de.kraftwerk.graphics.UserInterface;
import de.kraftwerk.stateability.Renderable;
import de.kraftwerk.stateability.Updateable;
import de.kraftwerk.ui.Component;
import de.kraftwerk.ui.Menu;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author kainianer
 */
public class Game extends BasicGameState {

    private final List<Component> compList = new ArrayList<>();
    private int width;
    private int height;

    private final GameContainer container;

    public Game(GameContainer container) {
        this.container = container;
        this.height = container.getHeight();
        this.width = container.getWidth();

        Menu test = new Menu(50, 75, 1000, this.height - 150);
        test.addContinueButton();
        test.addCancelButton();
        test.setActive(true);
        this.compList.add(test);
    }

    @Override
    public int getID() {
        return 3;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        for (int i = -64; i < gc.getWidth() + 64; i += 64) {
            for (int j = -64; j < gc.getHeight() + 64; j += 64) {
                UserInterface.TEST.getTexture().draw(i, j);
            }
        }

        for (Component comp : this.compList) {
            if (comp instanceof Renderable) {
                ((Renderable)comp).draw(grphcs);
            }
        }
        
        
        grphcs.drawString("FPS: " + gc.getFPS(), 10, 10);
        grphcs.drawString("MEM: " + ((Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()) / 1048576) + " / " + Runtime.getRuntime().maxMemory() / 1048576 + " MB", 10, 25);

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        for(Component cmpnt : this.compList) {
            if(cmpnt instanceof Updateable) {
                ((Updateable)cmpnt).update();
            }
        }
    }

}
