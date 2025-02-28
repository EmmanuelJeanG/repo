package application;


/**
 * This class contains the test case methods that students must implement
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyQueueTest_STUDENT {
	
	private MyQueue<Integer> queue;

	@BeforeEach
	void setUp() throws Exception {
		queue = new MyQueue<>(5);
	}

	@AfterEach
	void tearDown() throws Exception {
		 queue = null;
	}

	@Test
	void testIsEmpty() {
		assertTrue(queue.isEmpty()); 
        try {
            queue.enqueue(1);
            assertFalse(queue.isEmpty()); 
            queue.dequeue();
            assertTrue(queue.isEmpty()); 
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
	}

	@Test
	void testDequeue() {
		try {
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);

            assertEquals(10, queue.dequeue());
            assertEquals(20, queue.dequeue());
            assertEquals(30, queue.dequeue());

            assertThrows(QueueUnderflowException.class, () -> queue.dequeue());
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
	}

	@Test
	void testSize() {
		assertEquals(0, queue.size()); 
        try {
            queue.enqueue(1);
            queue.enqueue(2);
            assertEquals(2, queue.size());
            queue.dequeue();
            assertEquals(1, queue.size());
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
	}

	@Test
	void testEnqueue() {
		try {
            assertTrue(queue.enqueue(1));
            assertTrue(queue.enqueue(2));
            assertTrue(queue.enqueue(3));
            assertTrue(queue.enqueue(4));
            assertTrue(queue.enqueue(5));

            assertThrows(QueueOverflowException.class, () -> queue.enqueue(6));
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
	}

	@Test
	void testIsFull() {
		assertFalse(queue.isFull()); 
        try {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);
            queue.enqueue(5);
            assertTrue(queue.isFull()); 
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
	}

	@Test
	void testToString() {
		try {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            assertEquals("123", queue.toString());
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
	}

	@Test
	void testToStringString() {
		 try {
	            queue.enqueue(1);
	            queue.enqueue(2);
	            queue.enqueue(3);
	            assertEquals("1,2,3", queue.toString(","));
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

            queue.fill(list);
            assertEquals(3, queue.size());
            assertEquals("102030", queue.toString());
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
	}

}
