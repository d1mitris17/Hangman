/**
 * The WelcomePanel class represents a panel displayed at the beginning of a Hangman game.
 * It provides a welcome message and a button to start the game.
 */
package hangman;

import java.awt.GridLayout;
import javax.swing.*;

public class WelcomePanel extends JPanel{
    // Instance variables
    private JButton playBtn;
    private JLabel welcomeMsg;
    
    // Constructor
    public WelcomePanel() {
        // Initialise button and label
        playBtn = new JButton("Play");
        welcomeMsg = new JLabel("Welcome");
        
        // Set layout to a 2-row grid
        this.setLayout(new GridLayout(2, 1));
        
        // Add components to panel
        this.add(welcomeMsg);
        this.add(playBtn);
    }

    // Getter method for playBtn button
    public JButton getPlayBtn() {
        return playBtn;
    }

    // Setter method for playBtn button
    public void setPlayBtn(JButton playBtn) {
        this.playBtn = playBtn;
    }

    // Getter method for welcomeMsg label
    public JLabel getWelcomeMsg() {
        return welcomeMsg;
    }

    // Setter method for welcomeMsg label
    public void setWelcomeMsg(JLabel welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }
}
