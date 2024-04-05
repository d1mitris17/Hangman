/**
 * The MainWindow class represents the main frame of the Hangman game.
 * It manages the game setup, gameplay, and end game states.
 */
package hangman;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener{
    // Constants representing different game states
    private static final int GAMESETUP = 0, 
                            GAMEPLAY = 1, 
                            GAMEEND = 2;
    // Instance variables
    private int status;
    private RandomWordGenerator wordGenerator;
    private WelcomePanel welcomeMenu;
    private HealthPanel hp;
    private Container cpane;
    private WordPanel guessWord;
    private ButtonPanel guessButtons;
    private RestartPanel restartGame;
    
    // Constructor to initialize the MainWindow
    public MainWindow(){
        // Initialize instance variables
        this.wordGenerator = new RandomWordGenerator();
        this.welcomeMenu = new WelcomePanel();
        this.cpane = this.getContentPane();
        this.status = GAMESETUP;
        
        // Set Size and Layout of the frame
        this.setSize(600, 600);
        this.cpane.setLayout(new GridLayout(3, 1));
        
        // Add window listener to terminate execution when window is closed
        this.addWindowListener(new WindowAdapter () {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        // Add action listener to the play button in the welcome menu
        this.welcomeMenu.getPlayBtn().addActionListener(this);
        
        // Add welcome menu panel to the container
        this.cpane.add(welcomeMenu, BorderLayout.CENTER);
        
        // Set visibility of the frame
        this.setVisible(true);
    }

    // ActionListener method to handle button clicks
    public void actionPerformed(ActionEvent e) {
        switch(status) {
            case GAMESETUP:
                // Remove welcome menu panel and set its visibility to false
                this.cpane.remove(welcomeMenu);
                this.welcomeMenu.setVisible(false);
                // Initialize health panel, word panel, and button panel
                hp = new HealthPanel();
                guessWord = new WordPanel(this.wordGenerator.generateWord());
                guessButtons = new ButtonPanel();
                // Add action listeners to each button in the button panel
                for(int i = 0; i < this.guessButtons.getNumberOfButtons(); i++) {
                    this.guessButtons.getButtonAt(i).addActionListener(this);
                }
                // Set visibility of panels
                this.guessButtons.setVisible(true);
                this.guessWord.setVisible(true);
                this.hp.setVisible(true);
                // Add panels to the container
                this.cpane.add(hp);
                this.cpane.add(guessWord);
                this.cpane.add(guessButtons);
                // Set frame visibility
                this.setVisible(true);
                // Update game status
                this.status = GAMEPLAY;
                break;
                
            case GAMEPLAY:
                // Get the source button and hide it
                this.guessButtons.getButtonAt(((AlphabetButton) e.getSource()).getButtonPosition()).setVisible(false);
                // Check if guessed letter is incorrect
                if (!this.guessWord.guessLetter(this.guessButtons.getButtonAt(((AlphabetButton) e.getSource()).getButtonPosition()).getText().charAt(0))) {
                    // If incorrect, remove a life
                    if(!this.hp.removeLife()) { // if remove life returns false, there's no more lives
                        // Hide buttons and reveal word
                        this.guessButtons.setVisible(false);
                        this.cpane.remove(guessButtons);
                        this.guessWord.revealWord();
                        // Initialize restart panel for game over
                        this.restartGame = new RestartPanel("You lose");
                        // Add action listeners to restart and exit buttons
                        this.restartGame.getRestartGame().addActionListener(this);
                        this.restartGame.getExitGame().addActionListener(this);
                        // Add restart panel to container
                        this.cpane.add(restartGame);
                        // Update game status
                        this.status = GAMEEND;
                    }
                }
                else {
                    // If word is guessed correctly
                    if(this.guessWord.isWordGuessed()) {
                        // Hide buttons
                        this.guessButtons.setVisible(false);
                        this.cpane.remove(guessButtons);
                        // Initialise restart panel for game won
                        this.restartGame = new RestartPanel("You Win!");
                        // Add action listeners to restart and exit buttons
                        this.restartGame.getRestartGame().addActionListener(this);
                        this.restartGame.getExitGame().addActionListener(this);
                        // Add restart panel to container
                        this.cpane.add(restartGame);
                        // Update game status
                        this.status = GAMEEND;
                    }
                }
                break;
                
            case GAMEEND:
                // Check if restart button is clicked
                if(e.getSource() == this.restartGame.getRestartGame()) {
                    // Hide restart panel, word panel, and health panel
                    this.restartGame.setVisible(false);
                    this.guessWord.setVisible(false);
                    this.hp.setVisible(false);
                    // Remove all components from container and add welcome menu panel
                    this.cpane.removeAll();
                    this.cpane.add(welcomeMenu);
                    this.welcomeMenu.setVisible(true);
                    // Update game status
                    this.status = GAMESETUP;
                }
                else {
                    // Exit the game
                    System.exit(0);
                }
                break;
        }
    }
}
