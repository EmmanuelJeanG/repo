package application;

/**
 * This class contains the test case methods that students must implement
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class MyStackTest_STUDENT {

	private MyStack<Integer> stack;

    @BeforeEach
    void setUp() throws Exception {
        stack = new MyStack<>(5); 
    }

    @AfterEach
    void tearDown() throws Exception {
        stack = null;
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty()); 
        try {
            stack.push(1);
            assertFalse(stack.isEmpty());
            stack.pop();
            assertTrue(stack.isEmpty()); 
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testIsFull() {
        assertFalse(stack.isFull()); 
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            assertTrue(stack.isFull()); 
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testPop() {
        try {
            stack.push(10);
            stack.push(20);
            assertEquals(20, stack.pop()); 
            assertEquals(10, stack.pop());
            assertThrows(StackUnderflowException.class, () -> stack.pop()); // Stack should be empty
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testTop() {
        try {
            stack.push(100);
            stack.push(200);
            assertEquals(200, stack.top()); 
            stack.pop();
            assertEquals(100, stack.top()); 
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testSize() {
        assertEquals(0, stack.size()); 
        try {
            stack.push(1);
            stack.push(2);
            assertEquals(2, stack.size());
            stack.pop();
            assertEquals(1, stack.size());
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testPush() {
        try {
            assertTrue(stack.push(5));
            assertTrue(stack.push(10));
            assertTrue(stack.push(15));
            assertTrue(stack.push(20));
            assertTrue(stack.push(25));

            assertThrows(StackOverflowException.class, () -> stack.push(30)); 
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testToString() {
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            assertEquals("1 2 3", stack.toString()); 
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testToStringString() {
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            assertEquals("1,2,3", stack.toString(",")); 
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testFill() {
        try {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(10);
            list.add(20);
            list.add(30);

            stack.fill(list);
            assertEquals(3, stack.size());
            assertEquals("10 20 30", stack.toString()); 
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

}
