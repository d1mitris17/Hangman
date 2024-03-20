package hangman;

import javax.swing.JButton;

public class AlphabetButton extends JButton {
	private int buttonPosition;
	
	public AlphabetButton(String buttonText, int index) {
		super(buttonText);
		this.buttonPosition = index;
	}
	
	public int getButtonPosition() {
		return this.buttonPosition;
	}
}
