package hangman;

import java.awt.GridLayout;

import javax.swing.*;

public class WelcomePanel extends JPanel{
	private JButton playBtn;
	private JLabel welcomeMsg;
	
	public WelcomePanel() {
		playBtn = new JButton("Play");
		welcomeMsg = new JLabel("Welcome");
		
		this.setLayout(new GridLayout(2, 1));
		
		this.add(welcomeMsg);
		this.add(playBtn);
	}

	public JButton getPlayBtn() {
		return playBtn;
	}

	public void setPlayBtn(JButton playBtn) {
		this.playBtn = playBtn;
	}

	public JLabel getWelcomeMsg() {
		return welcomeMsg;
	}

	public void setWelcomeMsg(JLabel welcomeMsg) {
		this.welcomeMsg = welcomeMsg;
	}

	
}
