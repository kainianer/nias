/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.states;

import de.kraftwerk.graphics.Fonts;
import de.kraftwerk.graphics.FpsHud;
import de.kraftwerk.stateability.Renderable;
import de.kraftwerk.stateability.Updateable;
import de.kraftwerk.ui.Component;
import de.kraftwerk.ui.SubComponent;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author kainianer
 */
public class State extends BasicGameState {

    private final int id;
    private final List<Component> compList;
    private final FpsHud fps;
    public final StateBasedGame sbg;
    public final GameContainer gc;

    public State(int id, GameContainer gc, StateBasedGame sbg) {
        this.gc = gc;
        this.sbg = sbg;
        this.compList = new ArrayList<>();
        this.fps = new FpsHud(gc);
        this.id = id;
    }

    public void addComponent(Component cmpnt) {
        this.compList.add(cmpnt);
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        gc.getInput().removeAllListeners();
        gc.getInput().addKeyListener(this);
        gc.getInput().addKeyListener(sbg);

        for (Component comp : this.compList) {
            if (comp.hasSubComponents()) {
                for (SubComponent sub : comp.getSubCmpnt()) {
                    if (sub instanceof KeyListener) {
                        gc.getInput().addKeyListener((KeyListener) sub);
                    }
                    if (sub instanceof MouseListener) {
                        gc.getInput().addMouseListener((MouseListener) sub);
                    }
                }
            }
            if (comp instanceof KeyListener) {
                gc.getInput().addKeyListener((KeyListener) comp);
            }
            if (comp instanceof MouseListener) {
                gc.getInput().addMouseListener((MouseListener) comp);
            }
        }

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        for (Component cmpnt : this.compList) {
            if (cmpnt.isActive()) {
                if (cmpnt instanceof Renderable) {
                    ((Renderable) cmpnt).draw(grphcs);
                }
            }
        }
        grphcs.setFont(Fonts.TEXT.getTrueTypeFont());
        this.fps.draw(grphcs, gc.getFPS());
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        for (Component comp : this.compList) {
            if (comp.isActive()) {
                if (comp.hasSubComponents()) {
                    for (SubComponent sub : comp.getSubCmpnt()) {
                        if (sub instanceof Updateable) {
                            ((Updateable) sub).update(i);
                        }
                    }
                }
                if (comp instanceof Updateable) {
                    ((Updateable) comp).update(i);
                }
            }
        }
    }

}
