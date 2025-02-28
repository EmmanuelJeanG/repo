package application;

/**
 * This class contains the test case methods that students must implement
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotationTest_STUDENT {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testEvaluatePostfixExpression() {
		 try {
	            assertEquals(20, Notation.evaluatePostfixExpression("23+4*"));
	            assertEquals(15.0, Notation.evaluatePostfixExpression("53+7+")); 
	            assertEquals(2.0, Notation.evaluatePostfixExpression("42/")); 
	            assertThrows(InvalidNotationFormatException.class, () -> Notation.evaluatePostfixExpression("23+*")); 
	        } catch (Exception e) {
	            fail("Unexpected exception thrown: " + e.getMessage());
	        }
	}

	@Test
	void testConvertPostfixToInfix() {
		try {
            assertEquals("(2+3)", Notation.convertPostfixToInfix("23+"));
            assertEquals("((5+3)+7)", Notation.convertPostfixToInfix("53+7+"));
            assertEquals("(4/2)", Notation.convertPostfixToInfix("42/"));
            assertThrows(InvalidNotationFormatException.class, () -> Notation.convertPostfixToInfix("23+*"));
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
	}

	@Test
	void testConvertInfixToPostfix() {
		try {
            assertEquals("23+", Notation.convertInfixToPostfix("(2+3)"));
            assertEquals("53+7+", Notation.convertInfixToPostfix("((5+3)+7)"));
            assertEquals("42/", Notation.convertInfixToPostfix("(4/2)"));
            assertThrows(InvalidNotationFormatException.class, () -> Notation.convertInfixToPostfix("2+*3")); 
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
	}

}
