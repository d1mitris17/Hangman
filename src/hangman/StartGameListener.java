package hangman;

import java.awt.event.*;
import javax.swing.*;

public class StartGameListener implements ActionListener {
	JPanel healthPanel;
	JPanel startPanel;
	// TODO add panels to show for game
	
	public StartGameListener(JPanel currentHealthPanel, JPanel currentStartPanel) {
		this.healthPanel = currentHealthPanel;
		this.startPanel = currentStartPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.startPanel.setVisible(false);
		this.healthPanel.setVisible(true);
	}

}
