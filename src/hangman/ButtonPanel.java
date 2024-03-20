package hangman;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * A ButtonPanel is a JPanel that contains an array of AlphabetButtons.
 * It is used to display the letters of the alphabet in a Hangman
 */
public class ButtonPanel extends JPanel {
    // The array of AlphabetButtons
    private AlphabetButton[] alphabetButtons;
    // The array of letters in the alphabet
    private char[] alphabet;

    public ButtonPanel() {
        // Initialize the alphabet array with the uppercase letters of the alphabet
        this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        // Initialize the AlphabetButton array with the same length as the alphabet array
        this.alphabetButtons = new AlphabetButton[this.alphabet.length];

        // Set the layout of this JPanel to a 2-row grid with columns determined by the length of the alphabet array divided by 2
        this.setLayout(new GridLayout(2, this.alphabet.length/2));

        // Loop through the alphabet array
        for(int i = 0; i < this.alphabet.length; i++) {

            // Create a new AlphabetButton with the current letter and its position in the alphabet array
            this.alphabetButtons[i] = new AlphabetButton(String.valueOf(this.alphabet[i]), i);

            // Add the AlphabetButton to this JPanel
            this.add(alphabetButtons[i]);
        }
    }

    public int getNumberOfButtons() {
        // Return the length of the AlphabetButton array
        return this.alphabetButtons.length;
    }

    public JButton getButtonAt(int index) {
        // Return the AlphabetButton at the given index
        return this.alphabetButtons[index];
    }
}