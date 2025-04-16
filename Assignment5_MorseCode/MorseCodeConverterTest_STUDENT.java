package application;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeConverterTest_STUDENT {
	private File howDoILoveThee;
    private File daisy;
    private File daisyDaisy;
    private File loveLooksNot;

    @BeforeEach
    void setUp() throws Exception {
    	howDoILoveThee = new File("howDoILoveThee.txt");
        daisy = new File("Daisy.txt");
        daisyDaisy = new File("DaisyDaisy.txt");
        loveLooksNot = new File("LoveLooksNot.txt");
    }

    @AfterEach
    void tearDown() throws Exception {
    	howDoILoveThee = daisy = daisyDaisy = loveLooksNot = null;
    }

    @Test
    void testConvertToEnglish() {
    	 try {
             String morse = ".... . .-.. .-.. --- / .-- --- .-. .-.. -..";
             String result = MorseCodeConverter.convertToEnglish(morse);
             if (!result.equals("hello world")) {
                 fail("Expected 'hello world' but got '" + result);
             }
         } catch (Exception e) {
             fail("Exception: " + e.getMessage());
         }
    }

    @Test
    public void testHowDoILoveTheeFile() {
    	try {
            String result = MorseCodeConverter.convertToEnglish(howDoILoveThee);
            if (!result.equalsIgnoreCase("how do i love thee let me count the ways")) {
                fail("Expected full line but got: " + result);
            }
        } catch (Exception e) {
            fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void testDaisyFile() {
    	try {
            String result = MorseCodeConverter.convertToEnglish(daisy);
            if (!result.equalsIgnoreCase("give me your answer do")) {
                fail("Expected 'give me your answer do' but got: " + result);
            }
        } catch (Exception e) {
            fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void testDaisyDaisyFile() {
    	try {
            String result = MorseCodeConverter.convertToEnglish(daisyDaisy);
            if (!result.equalsIgnoreCase("im half crazy all for the love of you")) {
                fail("Expected 'im half crazy all for the love of you' but got: " + result);
            }
        } catch (Exception e) {
            fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void testLoveLooksNotFile() {
    	try {
            String result = MorseCodeConverter.convertToEnglish(loveLooksNot);
            if (!result.equalsIgnoreCase("love looks not with the eyes but with the mind")) {
                fail("Expected 'love looks not with the eyes but with the mind' but got: " + result);
            }
        } catch (Exception e) {
            fail("Exception: " + e.getMessage());
        }
    }

    @Test
    public void testStudentFiles() {
    	try {
            String morse = "- .... . / .--. .-. --- .--- . -.-. - / .. ... / -.-. --- -- .--. .-.. . - . -..";
            String result = MorseCodeConverter.convertToEnglish(morse);
            if (!result.equals("the project is completed")) {
                fail("Expected 'the project is completed' but got: " + result);
            }
        } catch (Exception e) {
            fail("Exception: " + e.getMessage());
        }
    }

}
