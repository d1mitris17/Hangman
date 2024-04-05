/**
 * The WordPanel class represents a panel displaying the unknown word to be guessed in a Hangman game.
 * It initializes the panel with underscores representing each letter of the word.
 */
package hangman;

import javax.swing.*;
import java.awt.*;

public class WordPanel extends JPanel {
    // Instance variables
    private String unknownWord;
    private JLabel[] unknownWordLetters;
    private boolean correct;
    private int lettersGuessed;
    
    // Constructor for testing purposes
    public WordPanel() {
        this("Banana");
    }
    
    // Constructor
    public WordPanel(String word) {
        // Initialize variables
        this.unknownWord = word;
        this.unknownWordLetters = new JLabel[this.unknownWord.length()];
        this.lettersGuessed = 0;

        // Set layout to a grid with one row and columns equal to the length of the unknown word
        this.setLayout(new GridLayout(1, this.unknownWord.length(), 10, 10));
        
        // Initialize JLabels with underscores representing each letter of the unknown word
        for(int i = 0; i < this.unknownWord.length(); i++) {
            this.unknownWordLetters[i] = new JLabel("_");
            this.unknownWordLetters[i].setOpaque(true);
            this.unknownWordLetters[i].setHorizontalAlignment(JLabel.CENTER);
            this.add(this.unknownWordLetters[i]);
        }
    }
    
    // Method to guess a letter
    public boolean guessLetter(char letter) {
        this.correct = false;
        for (int i = 0; i < this.unknownWord.length(); i++) {
            if(letter == this.unknownWord.charAt(i)) {
                this.unknownWordLetters[i].setText(String.valueOf(letter));
                this.correct = true;
            }
        }
        return correct;
    }
    
    // Method to check if the word has been completely guessed
    public boolean isWordGuessed() {
        this.lettersGuessed = 0;
        for(int i = 0; i < this.unknownWord.length(); i++) {
            if(String.valueOf(this.unknownWord.charAt(i)).equals(this.unknownWordLetters[i].getText())) {
                this.lettersGuessed += 1;
            }
        }
        
        // Check if the number of correctly guessed letters equals the length of the unknown word
        if(this.lettersGuessed == this.unknownWord.length()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    // Method to reveal the entire word
    public void revealWord() {
        for(int i = 0; i < this.unknownWordLetters.length; i++) {
            if (this.unknownWordLetters[i].getText().equals("_")) {
                this.unknownWordLetters[i].setText(String.valueOf(unknownWord.charAt(i)));
            }
        }
    }
}
