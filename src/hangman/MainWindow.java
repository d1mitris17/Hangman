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
	// TODO Make a Panel with mystery word
	// TODO Make Panel with letters to guess
	
	public MainWindow(){
		wordGenerator = new RandomWordGenerator();
		welcomeMenu = new WelcomePanel();
		cpane = this.getContentPane();
		
		// Set Size and Layout
		this.setSize(600, 600);
		this.cpane.setLayout(new GridLayout(3, 1));
		
		//Add Panels
		this.cpane.add(welcomeMenu, BorderLayout.CENTER);

		// Set Listeners
		this.addListeners();
		
		// Set panes required to correct visibility
		this.setVisible(true);

	}
	
	public int removeLife() { // remove one of the user's life
		return this.hp.removeLife();
	}
	
	private void addListeners() { // add all listeners required
		
		this.addWindowListener( // terminate execution when window is closed
				new WindowAdapter () {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				}
		);
		

		this.welcomeMenu.getPlayBtn().addActionListener(this); // add listener to play button
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.welcomeMenu.getPlayBtn()) { // if button is pressed hide welcome screen and reveal appropriate panels
			this.cpane.remove(welcomeMenu);
			this.welcomeMenu.setVisible(false);
			hp = new HealthPanel();
			guessWord = new WordPanel(this.wordGenerator.generateWord());
			this.cpane.add(hp);
			this.cpane.add(guessWord);
			this.setVisible(true);
		}
		
	}
	
	


}
