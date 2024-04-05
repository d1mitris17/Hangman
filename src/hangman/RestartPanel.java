/**
 * The RestartPanel class represents a panel displayed at the end of a Hangman game.
 * It provides options to restart the game or exit.
 */
package hangman;

import java.awt.GridLayout;
import javax.swing.*;

public class RestartPanel extends JPanel {
    // Instance variables
    private JButton exitGame;
    private JButton restartGame;
    private JLabel result;
    
    // Constructor
    RestartPanel(String lastGameResult){
        // Initialise buttons and label
        this.exitGame = new JButton("Exit");
        this.restartGame = new JButton("Restart");
        this.result = new JLabel(lastGameResult);
        // Set layout to a 3-row grid
        this.setLayout(new GridLayout(3, 1));
        // Add components to panel
        this.add(result);
        this.add(restartGame);
        this.add(exitGame);
    }
    
    // Getter method for exitGame button
    public JButton getExitGame() {
        return exitGame;
    }

    // Getter method for restartGame button
    public JButton getRestartGame() {
        return restartGame;
    }
}
