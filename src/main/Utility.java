package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Utility {
	/**
	 * 
	 * @param inputFileName Name of the file to be read
	 * @return Lines of the input file, alphabetically sorted
	 * @throws FileNotFoundException
	 */
	public static List<String> sortLinesAlphabetically(String inputFileName) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(inputFileName));
		
		List<String> lines = new ArrayList<String>();
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			lines.add(line);
		}
		scanner.close();
		
		Collections.sort(lines);
		return lines;
	}
	
	/**
	 * 
	 * @param inputFileName Name of the file to be read
	 * @param countRepeated True if repeated words have to be considered as they are different words
	 * @return Total number of words contained into the input file
	 * @throws FileNotFoundException
	 */
	public static int numberOfWords(String inputFileName, boolean countRepeated) throws FileNotFoundException {
		Scanner s = new Scanner(new File(inputFileName));
		Set<String> words = new HashSet<>();
		int result = 0;
		
		while(s.hasNext()) {
			result ++;
			
			String currentWord = s.next();
			if(!countRepeated)
				words.add(currentWord.toLowerCase());
		}
		s.close();
		
		if(!countRepeated)
			result = words.size();
		
		return result;
	}
	
	/**
	 * Given an input file, count how many characters each word is composed of,
	 * perform an addition between these values. The result is divided to the total number of words.
	 * 
	 * @param inputFileName Name of the file to be read
	 * @return Average size of the words contained into the input file
	 * @throws FileNotFoundException
	 */
	public static double averageWordLength(String inputFileName) throws FileNotFoundException {
		Scanner s = new Scanner(new File(inputFileName));

		double totalChars = 0f;
		while(s.hasNext())
			totalChars += s.next().length();
		s.close();
		
		return totalChars / numberOfWords(inputFileName, true);
	}
}
