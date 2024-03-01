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
			this.add(new JLabel(((Integer)(i + 1)).toString()));
			this.getComponent(i).setForeground(Color.green);
		}
		this.setSize(100, 100);
	}
	
	public int removeLife() {
		this.getComponent(incorrectGuesses).setForeground(Color.red);
		incorrectGuesses += 1;
		if (incorrectGuesses == this.getComponentCount())
				return 100;
		
		return 0;
	}
	
}
