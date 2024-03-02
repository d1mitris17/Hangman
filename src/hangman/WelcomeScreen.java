package hangman;

import javax.swing.*;

public class WelcomeScreen extends JPanel{
	private JButton playBtn;
	private JButton settingsBtn;
	private JLabel welcomeMsg;
	
	public WelcomeScreen() {
		playBtn = new JButton("Play");
		settingsBtn = new JButton("Settings");
		welcomeMsg = new JLabel("Welcome");
		this.setSize(2665, 1530);
		this.add(playBtn);
		this.add(settingsBtn);
		this.add(welcomeMsg);

	}
	
	public JButton getStartButton() {
		return playBtn;
	}

	
}
