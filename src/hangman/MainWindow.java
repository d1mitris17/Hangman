package hangman;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener{
	private RandomWordGenerator wordGenerator;
	private WelcomePanel welcomeMenu;
	private HealthPanel hp;
	private Container cpane;
	private WordPanel guessWord;
	private ButtonPanel guessButtons;
	
	public MainWindow(){
		wordGenerator = new RandomWordGenerator();
		welcomeMenu = new WelcomePanel();
		cpane = this.getContentPane();
		
		// Set Size and Layout
		this.setSize(600, 600);
		this.cpane.setLayout(new GridLayout(3, 1));
		
		// Add Listeners
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
		if(e.getSource() == this.welcomeMenu.getPlayBtn()) { // if button is pressed hide welcome screen and reveal appropriate panels
			this.cpane.remove(welcomeMenu);
			this.welcomeMenu.setVisible(false);
			hp = new HealthPanel();
			guessWord = new WordPanel(this.wordGenerator.generateWord());
			guessButtons = new ButtonPanel();
			for(int i = 0; i < this.guessButtons.getNumberOfButtons(); i++) {
				this.guessButtons.getButtonAt(i).addActionListener(this);
			}
			this.cpane.add(hp);
			this.cpane.add(guessWord);
			this.cpane.add(guessButtons);
			this.setVisible(true);
		}
		

			if(e.getSource() instanceof AlphabetButton) {
				this.guessButtons.getButtonAt(
						((AlphabetButton) e.getSource()).getButtonPosition()).setVisible(false);
				if (!this.guessWord.guessLetter(this.guessButtons.getButtonAt(((AlphabetButton) e.getSource()).getButtonPosition()).getText().charAt(0))) {
					if(!this.hp.removeLife()) {
						this.guessButtons.setVisible(false);
						this.remove(guessButtons);
						this.guessWord.revealWord();
						System.out.println("You lose");
					}

				}
				else {
					if(this.guessWord.isWordGuessed())
						System.out.println("You Win!");;
				}
				
			}
		
	}
	
	


}
