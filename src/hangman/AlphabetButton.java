// This class represents a custom JButton used for alphabet buttons in the Hangman game.
package hangman;

import javax.swing.JButton;

public class AlphabetButton extends JButton {
    // The position of this button in the alphabet array
    private int buttonPosition;

    // Constructor to initialize the AlphabetButton with text and position
    public AlphabetButton(String buttonText, int index) {
        // Call the constructor of the superclass (JButton) to set the text of the button
        super(buttonText);
        // Set the position of this button in the alphabet array
        this.buttonPosition = index;
    }

    // Method to get the position of the button in the alphabet array
    public int getButtonPosition() {
        // Return the value of the buttonPosition instance variable
        return this.buttonPosition;
    }
}
