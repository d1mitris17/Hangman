package hangman;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

public class HealthPanel extends JPanel {
	private ArrayList<JLabel> lifes;
	int incorrectGuesses;
	
	public HealthPanel() {
		this(7);
	}
	
	public HealthPanel(int n) {
		this.lifes = new ArrayList<>();
		this.incorrectGuesses = 0;
		for (int i = 0; i < n; i++) {
			lifes.add(new JLabel());
			lifes.get(i).setBackground(Color.green);
		}
	}
	
	public int removeLife() {
		this.lifes.get(incorrectGuesses).setBackground(Color.red);
		this.incorrectGuesses += 1;
		
		if (this.incorrectGuesses == lifes.size()) 
			return 100;
		
		return 0;
	}
	
}
