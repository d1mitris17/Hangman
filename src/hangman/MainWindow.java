package hangman;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener{
	private static final int GAMESETUP = 0, 
			GAMEPLAY = 1, 
			GAMEEND = 2;
	private int status;
	private RandomWordGenerator wordGenerator;
	private WelcomePanel welcomeMenu;
	private HealthPanel hp;
	private Container cpane;
	private WordPanel guessWord;
	private ButtonPanel guessButtons;
	private RestartPanel restartGame;
	
	public MainWindow(){
		this.wordGenerator = new RandomWordGenerator();
		this.welcomeMenu = new WelcomePanel();
		this.cpane = this.getContentPane();
		this.status = GAMESETUP;
		
		// Set Size and Layout
		this.setSize(600, 600);
		this.cpane.setLayout(new GridLayout(3, 1));
		
		this.addWindowListener( // terminate execution when window is closed
				new WindowAdapter () {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				}
		);
		
		this.welcomeMenu.getPlayBtn().addActionListener(this); // add listener to play button
		
		//Add Panels
		this.cpane.add(welcomeMenu, BorderLayout.CENTER);
		
		// Set panes required to correct visibility
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		
		switch(status) 
		{
			case GAMESETUP:
				this.cpane.remove(welcomeMenu);
				this.welcomeMenu.setVisible(false);
				hp = new HealthPanel();
				guessWord = new WordPanel(this.wordGenerator.generateWord());
				guessButtons = new ButtonPanel();
				for(int i = 0; i < this.guessButtons.getNumberOfButtons(); i++) {
					this.guessButtons.getButtonAt(i).addActionListener(this);
				}
				this.guessButtons.setVisible(true);
				this.guessWord.setVisible(true);
				this.hp.setVisible(true);
				this.cpane.add(hp);
				this.cpane.add(guessWord);
				this.cpane.add(guessButtons);
				this.setVisible(true);
				this.status = GAMEPLAY;
				break;
				
			case GAMEPLAY:
				this.guessButtons.getButtonAt(
						((AlphabetButton) e.getSource()).getButtonPosition()).setVisible(false);
				if (!this.guessWord.guessLetter(this.guessButtons.getButtonAt(((AlphabetButton) e.getSource()).getButtonPosition()).getText().charAt(0))) {
					if(!this.hp.removeLife()) { // if remove life returns false, theres no more lives
						this.guessButtons.setVisible(false);
						this.cpane.remove(guessButtons);
						this.guessWord.revealWord();
						this.restartGame = new RestartPanel("You lose");
						this.restartGame.getRestartGame().addActionListener(this);
						this.restartGame.getExitGame().addActionListener(this);
						this.cpane.add(restartGame);
						this.status = GAMEEND;
					}

				}
				else {
					if(this.guessWord.isWordGuessed()) {
						this.guessButtons.setVisible(false);
						this.cpane.remove(guessButtons);
						this.restartGame = new RestartPanel("You Win!");
						this.restartGame.getRestartGame().addActionListener(this);
						this.restartGame.getExitGame().addActionListener(this);
						this.cpane.add(restartGame);
						this.status = GAMEEND;
					}
				}
				break;
				
			case GAMEEND:
				if(e.getSource() == this.restartGame.getRestartGame()) {
					this.restartGame.setVisible(false);
					this.guessWord.setVisible(false);
					this.hp.setVisible(false);
					this.cpane.removeAll();
					this.cpane.add(welcomeMenu);
					this.welcomeMenu.setVisible(true);
					this.status = GAMESETUP;
				}
				else {
					System.exit(0);
				}
				break;
		}
		
	}

}
