/**
 * The HealthPanel class represents a panel displaying the remaining lives or health of the player in the Hangman game.
 * It visually represents the number of incorrect guesses allowed before the game ends.
 */
package hangman;

import java.awt.*;
import javax.swing.*;

public class HealthPanel extends JPanel {
    // Instance variables to track incorrect guesses and maximum allowed incorrect guesses
    private int incorrectGuesses, maxIncorrectGuesses;
    // Array of JLabels representing individual life indicators
    private JLabel[] lives;
    
    // Default constructor initializes with default maximum incorrect guesses
    public HealthPanel() {
        this(7); // Default to 7 maximum incorrect guesses
    }
    
    // Constructor with parameter to set maximum incorrect guesses
    public HealthPanel(int n) {
        // Initialize incorrect guesses to 0 and set maximum incorrect guesses
        this.incorrectGuesses = 0;
        this.maxIncorrectGuesses = n;
        // Set layout to a single row grid capable of holding max mistakes
        this.setLayout(new GridLayout(1, this.maxIncorrectGuesses, 10, 10));
        // Initialize array of JLabels representing lives
        this.lives = new JLabel[this.maxIncorrectGuesses];
        
        // Populate the panel with individual life indicators
        for (int i = 0; i < this.maxIncorrectGuesses; i++) {
            // Create a new JLabel for each life indicator
            this.lives[i] = new JLabel();
            // Set initial background color to green (indicating available life)
            this.lives[i].setBackground(Color.GREEN);
            // Make background color visible by setting opaque to true
            this.lives[i].setOpaque(true);
            // Add the life indicator JLabel to the panel
            this.add(this.lives[i]);
        }
    }
    
    // Method to remove a life indicator (visualizing an incorrect guess)
    public boolean removeLife() {
        // Change the background color of the next available life indicator to red
        this.lives[this.incorrectGuesses].setBackground(Color.RED);
        // Increment the count of incorrect guesses
        this.incorrectGuesses += 1;
        // Check if maximum incorrect guesses have been reached
        if (this.incorrectGuesses == this.maxIncorrectGuesses)
            return false; // Return false indicating game over
        return true; // Return true indicating more lives available
    }

    // Getter method for incorrectGuesses
    public int getIncorrectGuesses() {
        return incorrectGuesses;
    }

    // Setter method for incorrectGuesses
    public void setIncorrectGuesses(int incorrectGuesses) {
        this.incorrectGuesses = incorrectGuesses;
    }

    // Getter method for maxIncorrectGuesses
    public int getMaxIncorrectGuesses() {
        return maxIncorrectGuesses;
    }

    // Setter method for maxIncorrectGuesses
    public void setMaxIncorrectGuesses(int maxIncorrectGuesses) {
        this.maxIncorrectGuesses = maxIncorrectGuesses;
    }

    // Getter method for lives array
    public JLabel[] getLives() {
        return lives;
    }

    // Setter method for lives array
    public void setLives(JLabel[] lives) {
        this.lives = lives;
    }
}
