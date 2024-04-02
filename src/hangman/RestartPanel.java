package hangman;

import java.awt.GridLayout;
import javax.swing.*;

public class RestartPanel extends JPanel {
	JButton exitGame,
	restartGame;
	JLabel result;
	
	RestartPanel(String lastGameResult){
		this.exitGame = new JButton("Exit");
		this.restartGame = new JButton("Restart");
		this.result = new JLabel(lastGameResult);
		this.setLayout(new GridLayout(3, 1));
		this.add(result);
		this.add(restartGame);
		this.add(exitGame);
	}
	
	public JButton getExitGame() {
		return exitGame;
	}

	public JButton getRestartGame() {
		return restartGame;
	}

	
}
