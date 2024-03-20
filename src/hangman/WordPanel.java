package hangman;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WordPanel extends JPanel {
	private String unknownWord;
	private JLabel[] unknownWordLetters;
	private boolean correct;
	private int lettersGuessed;
	
	public WordPanel() { // for testing purposes
		this("Banana");
	}
	
	public WordPanel(String word) {
		this.unknownWord = word;
		this.unknownWordLetters = new JLabel[this.unknownWord.length()];
		this.lettersGuessed = 0;

		this.setLayout(new GridLayout(1, this.unknownWord.length(), 10, 10));
		
		for(int i = 0; i < this.unknownWord.length(); i++) {
			this.unknownWordLetters[i] = new JLabel("?");
			this.unknownWordLetters[i].setOpaque(true);
			this.unknownWordLetters[i].setHorizontalAlignment(JLabel.CENTER);
			this.add(this.unknownWordLetters[i]);
		}
	}
	
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
	
	public boolean isWordGuessed() {
		this.lettersGuessed = 0;
		for(int i = 0; i < this.unknownWord.length(); i++) {
			if(String.valueOf(this.unknownWord.charAt(i)).equals(this.unknownWordLetters[i].getText())) {
				this.lettersGuessed += 1;
			}
		}
		
		if(this.lettersGuessed == this.unknownWord.length()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
