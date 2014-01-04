/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kraftwerk.buttons;

import de.kraftwerk.ui.Button;
import de.kraftwerk.ui.Menu;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kainianer
 */
public class RegisterButton extends Button {

    public RegisterButton(int x, int y, String value, Menu contained) {
        super(x, y, value, contained);
    }

    @Override
    public void mouseReleased(int i, int x, int y) {
        super.mouseReleased(i, x, y);
        if (this.isHovered(x, y)) {
            try {
                Desktop.getDesktop().browse(new URL("http://www.google.de").toURI());
            } catch (IOException | URISyntaxException ex) {
                Logger.getLogger(LoginButton.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
