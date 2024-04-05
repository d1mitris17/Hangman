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
    private JTextField maxLives;
    private JLabel welcomeMsg;
    
    // Constructor
    public WelcomePanel() {
        // Initialise button and label
        this.playBtn = new JButton("Play");
        this.welcomeMsg = new JLabel("Welcome");
        this.maxLives = new JTextField("7");
        
        // Set layout to a 2-row grid
        this.setLayout(new GridLayout(3, 1));
        
        // Add components to panel
        this.add(welcomeMsg);
        this.add(maxLives);
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
    
    public String getMaxLives() {
    	return this.maxLives.getText();
    }
}
