package application;

import java.util.ArrayList;

public class PasswordCheckerUtility {

	public static boolean comparePasswordsWithReturn(String passwordString, String passwordAString) {
		return passwordString.equals(passwordAString);
	}//checks without stopping execution
	
	public static void comparePasswords(String passwordString, String passwordAString) throws UnmatchedException {
	    if (!passwordString.equals(passwordAString)) {
	        throw new UnmatchedException();
	    }//enforces when matching passwords
	}


	public static boolean isValidPassword(String passwordString) 
	        throws LengthException, NoUpperAlphaException, NoLowerAlphaException, 
	               NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
	    
	    // Check for minimum length (at least 6 characters)
	    if (passwordString.length() < 6) {
	        throw new LengthException();
	    }

	    // Check for at least one uppercase letter
	    if (!passwordString.matches(".*[A-Z].*")) {
	        throw new NoUpperAlphaException();
	    }

	    // Check for at least one lowercase letter
	    if (!passwordString.matches(".*[a-z].*")) {
	        throw new NoLowerAlphaException();
	    }

	    // Check for at least one digit
	    if (!passwordString.matches(".*\\d.*")) {
	        throw new NoDigitException();
	    }

	    // Check for at least one special character
	    if (!passwordString.matches(".*[^a-zA-Z0-9].*")) {
	        throw new NoSpecialCharacterException();
	    }

	    // Check for invalid sequence (more than two of the same character in a row)
	    for (int i = 0; i < passwordString.length() - 2; i++) {
	        if (passwordString.charAt(i) == passwordString.charAt(i + 1) &&
	            passwordString.charAt(i) == passwordString.charAt(i + 2)) {
	            throw new InvalidSequenceException();
	        }
	    }

	    return true; // If no exceptions are thrown, the password is valid
	}


	public static boolean isWeakPassword(String passwordString) throws WeakPasswordException {
	    // check if the password is valid
	    try {
	        isValidPassword(passwordString);
	    } catch (Exception e) {
	        return false; // If password is just invalid
	    }

	    // If the password length is between 6 and 9 characters, throw WeakPasswordException
	    if (passwordString.length() >= 6 && passwordString.length() < 10) {
	        throw new WeakPasswordException();
	    }

	    return false; // If password is valid and more than 10 characters
	}


	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
	    ArrayList<String> invalidPasswords = new ArrayList<>();

	    for (String passwordString : passwords) {
	        try {
	            isValidPassword(passwordString); // Check if password is valid
	        } catch (Exception e) {
	            // If invalid, store the password + error message
	            invalidPasswords.add(passwordString + " -- " + e.getMessage());
	        }
	    }

	    return invalidPasswords;
	}
	
	public static void isValidLength(String passwordString) throws LengthException {
	    if (passwordString.length() < 6) {
	        throw new LengthException();
	    }
	}
	
	public static void hasUpperAlpha(String passwordString) throws NoUpperAlphaException {
	    if (!passwordString.matches(".*[A-Z].*")) {
	        throw new NoUpperAlphaException();
	    }
	}
	
	public static void hasLowerAlpha(String passwordString) throws NoLowerAlphaException {
	    if (!passwordString.matches(".*[a-z].*")) {
	        throw new NoLowerAlphaException();
	    }
	}
	
	public static void hasDigit(String passwordString) throws NoDigitException {
	    if (!passwordString.matches(".*\\d.*")) {
	        throw new NoDigitException();
	    }
	}
	public static void hasSpecialChar(String passwordString) throws NoSpecialCharacterException {
	    if (!passwordString.matches(".*[^a-zA-Z0-9].*")) {
	        throw new NoSpecialCharacterException();
	    }
	}
	
	public static void noSameCharInSequence(String passwordString) throws InvalidSequenceException {
	    for (int i = 0; i < passwordString.length() - 2; i++) {
	        if (passwordString.charAt(i) == passwordString.charAt(i + 1) && passwordString.charAt(i) == passwordString.charAt(i + 2)) {
	            throw new InvalidSequenceException();
	        }
	    }
	}
	
	public static boolean hasBetweenSixAndNineChars(String passwordString) {
	    return passwordString.length() >= 6 && passwordString.length() <= 9;
	}



	






}
