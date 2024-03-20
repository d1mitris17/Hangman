package hangman;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class RandomWordGenerator {
	private String currentWord;
	private ArrayList<String> wordSelection;
	private Random rand;
	private BufferedReader br;
	
	public RandomWordGenerator(String filename) {
		this.rand = new Random();
		this.wordSelection = new ArrayList<String>(); 
		try { 
			this.br = new BufferedReader(new FileReader(filename));
			this.currentWord = br.readLine();
		} catch (FileNotFoundException e) {
			System.out.println("Failed to locate resource");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Resource failed to load");
			System.exit(0);
		}
	}
	
	public RandomWordGenerator() {
		this("all_words.txt");
	}

	public String generateWord() {
		while(this.currentWord != null) {
			this.wordSelection.add(currentWord);
			try {
				this.currentWord = br.readLine();
			} catch (IOException e) {
				System.out.println("Resource error");
				System.exit(0);
			}
		}
		
		return this.wordSelection.get(rand.nextInt(this.wordSelection.size()));
	}

}
