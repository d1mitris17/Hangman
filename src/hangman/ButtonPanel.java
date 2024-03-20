package hangman;

import java.awt.GridLayout;

import javax.swing.*;

public class ButtonPanel extends JPanel {
	private AlphabetButton[] alphabetButtons;
	private char[] alphabet;
	
	public ButtonPanel() {
		this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		this.alphabetButtons = new AlphabetButton[this.alphabet.length];
		
		this.setLayout(new GridLayout(2, this.alphabet.length/2));
		
		for(int i = 0; i < this.alphabet.length; i++) {
			this.alphabetButtons[i] = new AlphabetButton(String.valueOf(this.alphabet[i]), i);
			this.add(alphabetButtons[i]);
		}
	}
	
	public int getNumberOfButtons() {
		return this.alphabetButtons.length;
	}
	
	public JButton getButtonAt(int index) {
		return this.alphabetButtons[index];
	}
}
