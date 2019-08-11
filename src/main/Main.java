package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
	
	private static final String OUTPUT_FILE_URI = "resources/ordered_words.csv";
	private static final String INPUT_FILE_URI = "resources/words.csv";
	
	public static void main(String[] args) {
		try {
			Files.deleteIfExists(Paths.get(OUTPUT_FILE_URI));
			
			List<String> sortedLines = Utility.sortLinesAlphabetically(INPUT_FILE_URI);
			Path outputFilePath = Files.createFile(Paths.get(OUTPUT_FILE_URI));
			for(String line: sortedLines) {
				line += "\n";
				Files.write(outputFilePath, line.getBytes(), StandardOpenOption.APPEND);
			}
			
			System.out.println("New file created at: resources/ordered_words.csv");
			System.out.println("Number of words: " + Utility.numberOfWords(INPUT_FILE_URI, true));
			System.out.println("Number of (non repeated) words: " + Utility.numberOfWords(INPUT_FILE_URI, false));
			System.out.println("Average word length: " + Utility.averageWordLength(INPUT_FILE_URI));
			
		} catch (FileNotFoundException e) {
			System.out.println("Error: input file must be saved as resources/words.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
