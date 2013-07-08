/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radiat;

import javax.swing.SwingUtilities;

/**
 *
 * @author Akos
 */
public class Radiat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameFrame game = new GameFrame();
                game.setVisible(true);
            }
        });
    }
}
