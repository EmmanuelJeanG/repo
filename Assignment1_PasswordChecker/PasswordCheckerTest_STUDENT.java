package application;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
		    private String validPassword;
		    private String shortPassword;
		    private String noUpperPassword;
		    private String noLowerPassword;
		    private String noDigitPassword;
		    private String noSpecialCharPassword;
		    private String consecutiveCharPassword;
		    private String weakPassword;
	

	@Before
	public void setUp() throws Exception {

	    validPassword = "Strong@123";
	    shortPassword = "Ab1!";
	    noUpperPassword = "weakpassword1!";
	    noLowerPassword = "WEAKPASSWORD1!";
	    noDigitPassword = "WeakPassword!";
	    noSpecialCharPassword = "WeakPassword1";
	    consecutiveCharPassword = "AAAas123!";
	    weakPassword = "Weak1!";
		
	}

	@After
	public void tearDown() throws Exception {
		validPassword = null;
	    shortPassword = null;
	    noUpperPassword = null;
	    noLowerPassword = null;
	    noDigitPassword = null;
	    noSpecialCharPassword = null;
	    consecutiveCharPassword = null;
	    weakPassword = null;
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() {
	    assertThrows(LengthException.class, () -> PasswordCheckerUtility.isValidPassword(shortPassword));
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() {
	    assertThrows(NoUpperAlphaException.class, () -> PasswordCheckerUtility.isValidPassword(noUpperPassword));
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() {
	    assertThrows(NoLowerAlphaException.class, () -> PasswordCheckerUtility.isValidPassword(noLowerPassword));
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword() {
	    assertThrows(WeakPasswordException.class, () -> PasswordCheckerUtility.isWeakPassword(weakPassword));
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() {
	    assertThrows(InvalidSequenceException.class, () -> PasswordCheckerUtility.isValidPassword(consecutiveCharPassword));
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() {
	    assertThrows(NoDigitException.class, () -> PasswordCheckerUtility.isValidPassword(noDigitPassword));
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() {
	    try {
	        assertTrue(PasswordCheckerUtility.isValidPassword(validPassword));
	    } catch (Exception e) {
	        fail("Exception thrown when there shouldn't be: " + e.getMessage());
	    }
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
	    ArrayList<String> passwords = new ArrayList<>(Arrays.asList(shortPassword, noUpperPassword, noLowerPassword, noDigitPassword, noSpecialCharPassword, consecutiveCharPassword));
	    
	    ArrayList<String> invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(passwords);

	    assertEquals(6, invalidPasswords.size()); 
	}

	
}
