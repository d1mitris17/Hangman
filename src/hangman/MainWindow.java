package hangman;

import java.awt.event.*;
import javax.swing.*;

public class MainWindow extends JFrame{
	private WelcomeScreen ws;
	private HealthPanel hp;

	
	public MainWindow(){
		this(7);
	}
	
	public MainWindow(int n){
		ws = new WelcomeScreen();
		hp = new HealthPanel(n);
		// TODO Make a Panel with mystery word
		// TODO Make Panel with letters to guess
		
		//Add Panels
		this.add(ws);
		this.add(hp);
		
		this.setSize(2665, 1530);
		
		//Set Visibility of Panels
		this.hp.setVisible(false);
		this.ws.setVisible(true);
		this.setVisible(true);
		
		// Set Listeners
		this.addWindowListener(
				new WindowAdapter () {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				}
		);
		

		this.ws.getStartButton().addActionListener(new StartGameListener(hp, ws));

	}
	
	public int removeLife() {
		return this.hp.removeLife();
	}

}
