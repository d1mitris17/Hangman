/**
 * The WelcomePanel class represents a panel displayed at the beginning of a Hangman game.
 * It provides a welcome message and a button to start the game.
 */
package hangman;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class WelcomePanel extends JPanel{
    // Instance variables
	 private JButton playBtn;
	    private JLabel welcomeMsg;
	    private JButton chooseFileBtn;
	    private JLabel selectedFileLabel;
	    private JFileChooser fileChooser;
	    private JLabel maxLivesLabel; // Label for maximum lives
	    private JTextArea maxLivesTextArea; // Text area for entering maximum lives

	    public WelcomePanel() {
	        playBtn = new JButton("Play");
	        welcomeMsg = new JLabel("Welcome");
	        selectedFileLabel = new JLabel("Select File: ");
	        chooseFileBtn = new JButton("Choose Word List");
	        fileChooser = new JFileChooser("/Users/dimitrisdoukas/git/gui-coursework-dd-2040/all_words.txt");
	        fileChooser.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));
	        maxLivesLabel = new JLabel("Enter maximum lives:");
	        maxLivesTextArea = new JTextArea("7", 1, 5); // Default value set to 7

	        this.setLayout(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.insets = new Insets(10, 10, 10, 10);

	        this.add(welcomeMsg, gbc);

	        gbc.gridy++;
	        this.add(selectedFileLabel, gbc);
	        
	        gbc.gridx++;
	        this.add(chooseFileBtn, gbc);

	        gbc.gridy++;
	        this.add(maxLivesLabel, gbc);

	        gbc.gridx++;
	        this.add(maxLivesTextArea, gbc);
	        
	        gbc.gridx++;
	        this.add(playBtn, gbc);
	        
	        chooseFileBtn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                int result = fileChooser.showOpenDialog(WelcomePanel.this);
	                if (result == JFileChooser.APPROVE_OPTION) {
	                    File selectedFile = fileChooser.getSelectedFile();
	                    selectedFileLabel.setText("Selected file: " + selectedFile.getAbsolutePath());
	                }
	            }
	        });
	    }

    // Getter method for playBtn button
    public JButton getPlayBtn() {
        return playBtn;
    }

    // Setter method for playBtn button
    public void setPlayBtn(JButton playBtn) {
        this.playBtn = playBtn;
    }

    // Getter method for welcomeMsg label
    public JLabel getWelcomeMsg() {
        return welcomeMsg;
    }

    // Setter method for welcomeMsg label
    public void setWelcomeMsg(JLabel welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }
    
    public String getMaxLives() {
    	return this.maxLivesTextArea.getText();
    }
    
    public String getFileChosen() {
    	return fileChooser.getSelectedFile().getAbsolutePath();
    }
    
}
