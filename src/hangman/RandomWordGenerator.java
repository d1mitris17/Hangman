package hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class RandomWordGenerator {
 private ArrayList<String> wordSelection;
 private Random rand;

 public RandomWordGenerator(String filename) {
     this.wordSelection = new ArrayList<String>(); // Initialize ArrayList
     this.rand = new Random(); // Initialize Random object
     loadWordsFromFile(filename); // Load words from file
 }
 
 public RandomWordGenerator() {
	 this("all_words.txt");
 }

 // Method to load words from a file
 private void loadWordsFromFile(String filename) {
     try (BufferedReader br = new BufferedReader(new FileReader(filename))) { // Try to open and read the file
         String line;
         while ((line = br.readLine()) != null) { // Read each line from the file
             wordSelection.add(line.trim()); // Add the trimmed line to the word selection list
         }
     } catch (IOException e) { // Catch any IO exceptions
         System.err.println("Error reading file: " + e.getMessage()); // Print error message
     }
 }

 // Method to generate a random word from the loaded words
 public String generateWord() {
     if (wordSelection.isEmpty()) { // Check if the word selection list is empty
         System.err.println("No words loaded."); // Print error message
         System.exit(0); // exit program
     }
     return wordSelection.get(rand.nextInt(wordSelection.size())); // Return a random word from the list
 }
}
