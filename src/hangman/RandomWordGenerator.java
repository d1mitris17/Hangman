/**
 * The RandomWordGenerator class generates a random word for the Hangman game.
 * It reads a list of words from a file and selects one at random.
 */
package hangman;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class RandomWordGenerator {
    // Instance variables
    private String currentWord;
    private ArrayList<String> wordSelection;
    private Random rand;
    private BufferedReader br;
    
    // Constructor with specified filename
    public RandomWordGenerator(String filename) {
        // Initialize random number generator and word selection list
        this.rand = new Random();
        this.wordSelection = new ArrayList<String>(); 
        try { 
            // Read words from file
            this.br = new BufferedReader(new FileReader(filename));
            // Read first word
            this.currentWord = br.readLine();
        } catch (FileNotFoundException e) {
            // Error handling if file not found
            System.out.println("Failed to locate resource");
            System.exit(0);
        } catch (IOException e) {
            // Error handling for IO exception
            System.out.println("Resource failed to load");
            System.exit(0);
        }
    }
    
    // Constructor with default filename
    public RandomWordGenerator() {
        this("all_words.txt");
    }

    // Method to generate a random word
    public String generateWord() {
        // Read words from file until end
        while(this.currentWord != null) {
            // Add word to selection list
            this.wordSelection.add(currentWord);
            try {
                // Read next word
                this.currentWord = br.readLine();
            } catch (IOException e) {
                // Error handling for IO exception
                System.out.println("Resource error");
                System.exit(0);
            }
        }
        
        // Return a random word from the selection list
        return this.wordSelection.get(rand.nextInt(this.wordSelection.size()));
    }

}
