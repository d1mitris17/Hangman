package hangman;

import java.awt.*;
import javax.swing.*;

public class HealthPanel extends JPanel {
	private int incorrectGuesses, maxIncorrectGuesses;
	private JLabel[] lives;
	
	public HealthPanel() {
		this(7);
	}
	
	public HealthPanel(int n) {
		this.incorrectGuesses = 0; // set Incorrect Guesses to 0
		this.maxIncorrectGuesses = n; // set Maximum mistakes
		this.setLayout(new GridLayout(1, this.maxIncorrectGuesses, 10, 10)); // set Layout to grid capable of holding max mistakes
		this.lives = new JLabel[this.maxIncorrectGuesses]; // set size to that of maximum lifes
		
		for (int i = 0; i < this.maxIncorrectGuesses; i++) {
			this.lives[i] = new JLabel();
			this.lives[i].setBackground(Color.GREEN);
			this.lives[i].setOpaque(true);
			this.add(this.lives[i]);
		}
	}
	
	public int removeLife() {
		this.lives[this.incorrectGuesses].setBackground(Color.red);;
		this.incorrectGuesses += 1;
		if (this.incorrectGuesses == this.maxIncorrectGuesses)
				return 100;
		
		return 0;
	}

	public int getIncorrectGuesses() {
		return incorrectGuesses;
	}

	public void setIncorrectGuesses(int incorrectGuesses) {
		this.incorrectGuesses = incorrectGuesses;
	}

	public int getMaxIncorrectGuesses() {
		return maxIncorrectGuesses;
	}

	public void setMaxIncorrectGuesses(int maxIncorrectGuesses) {
		this.maxIncorrectGuesses = maxIncorrectGuesses;
	}

	public JLabel[] getLives() {
		return lives;
	}

	public void setLives(JLabel[] lives) {
		this.lives = lives;
	}
	
}
