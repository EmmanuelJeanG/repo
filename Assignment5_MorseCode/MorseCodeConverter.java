package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeConverter {
	
	private static MorseCodeTree morseTree = new MorseCodeTree();

	public static String convertToEnglish(String code) {
		StringBuilder english = new StringBuilder();
        String[] words = code.trim().split(" / ");
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                english.append(morseTree.fetchLetter(morseTree.getRoot(), letter));
            }
            english.append(" ");
        }
        return english.toString().trim();
	}

	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		
		Scanner scanner = new Scanner(codeFile);
        StringBuilder morseCode = new StringBuilder();

        while (scanner.hasNextLine()) {
            morseCode.append(scanner.nextLine());
            morseCode.append(" "); 
        }

        scanner.close();
        return convertToEnglish(morseCode.toString().trim());
	}
	
	
	

}
