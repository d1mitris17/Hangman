package hangman;

import javax.swing.JButton;

public class AlphabetButton extends JButton {
    // The position of this button in array
    private int buttonPosition;

    public AlphabetButton(String buttonText, int index) {
        // Call the constructor of the superclass (JButton) to set Text in button
        super(buttonText);
        // Set the position of this button
        this.buttonPosition = index;
    }

    public int getButtonPosition() {
        // Return the value of the buttonPosition instance variable
        return this.buttonPosition;
    }
}