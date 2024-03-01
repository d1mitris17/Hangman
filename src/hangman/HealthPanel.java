package hangman;

import java.awt.Color;
import javax.swing.*;

public class HealthPanel extends JPanel {
	int incorrectGuesses;
	
	public HealthPanel() {
		this(7);
	}
	
	public HealthPanel(int n) {
		this.incorrectGuesses = 0;
		for (int i = 0; i < n; i++) {
			this.add(new JLabel(((Integer)i).toString()));
			this.getComponent(i).setBackground(Color.green);
		}
	}
	
	public int removeLife() {
		this.getComponent(incorrectGuesses).setBackground(Color.red);
		incorrectGuesses += 1;
		if (incorrectGuesses == this.getComponentCount())
				return 100;
		return 0;
	}
	
}
