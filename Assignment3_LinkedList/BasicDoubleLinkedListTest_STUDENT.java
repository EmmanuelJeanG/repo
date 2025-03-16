package application;


/**
 * You must implement the following test case methods
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicDoubleLinkedListTest_STUDENT {
	private BasicDoubleLinkedList<Integer> linkedList;

	@BeforeEach
	void setUp() throws Exception {
		 linkedList = new BasicDoubleLinkedList<>();
	}

	@AfterEach
	void tearDown() throws Exception {
		 linkedList = null;
	}

	@Test
	void testGetSize() {
		assertEquals(0, linkedList.getSize()); 

        linkedList.addToFront(10);
        assertEquals(1, linkedList.getSize());

        linkedList.addToEnd(20);
        linkedList.addToEnd(30);
        assertEquals(3, linkedList.getSize());
	}

	@Test
	void testAddToEnd() {
		linkedList.addToEnd(5);
        linkedList.addToEnd(10);
        linkedList.addToEnd(15);

        assertEquals(15, linkedList.getLast()); 
        assertEquals(3, linkedList.getSize());
	}

	@Test
	void testAddToFront() {
		linkedList.addToFront(100);
        linkedList.addToFront(200);
        linkedList.addToFront(300);

        assertEquals(300, linkedList.getFirst()); // First element should be 300
        assertEquals(3, linkedList.getSize());
	}

	@Test
	void testGetFirst() {
		linkedList.addToEnd(10);
        linkedList.addToEnd(20);
        linkedList.addToEnd(30);

        assertEquals(10, linkedList.getFirst()); // First element should be 10
    }

	@Test
	void testGetLast() {
		linkedList.addToEnd(5);
        linkedList.addToEnd(15);
        linkedList.addToEnd(25);

        assertEquals(25, linkedList.getLast()); // Last element should be 25
    }

	@Test
	void testIterator() {
		linkedList.addToEnd(10);
        linkedList.addToEnd(20);
        linkedList.addToEnd(30);

        ListIterator<Integer> iterator = linkedList.iterator();
        
        assertTrue(iterator.hasNext());
        assertEquals(10, iterator.next());
        assertEquals(20, iterator.next());
        assertEquals(30, iterator.next());
        assertFalse(iterator.hasNext());
	}

	@Test
	void testRemove() {
		linkedList.addToEnd(10);
        linkedList.addToEnd(20);
        linkedList.addToEnd(30);

        Comparator<Integer> comparator = Integer::compareTo;

        assertEquals(20, linkedList.remove(20, comparator)); // Removes 20
        assertEquals(2, linkedList.getSize()); 
        assertNull(linkedList.remove(40, comparator)); // Removing fake element should return null
    }

	@Test
	void testRetrieveFirstElement() {
		linkedList.addToEnd(10);
        linkedList.addToEnd(20);
        linkedList.addToEnd(30);

        assertEquals(10, linkedList.retrieveFirstElement()); // Should remove and return 10
        assertEquals(2, linkedList.getSize());
        assertEquals(20, linkedList.getFirst()); //first element should now be 20
    }

	@Test
	void testRetrieveLastElement() {
		linkedList.addToEnd(5);
        linkedList.addToEnd(15);
        linkedList.addToEnd(25);

        assertEquals(25, linkedList.retrieveLastElement()); // Should remove and return 25
        assertEquals(2, linkedList.getSize());
        assertEquals(15, linkedList.getLast()); //last element should now be 15
    }

	@Test
	void testToArrayList() {
		linkedList.addToEnd(10);
        linkedList.addToEnd(20);
        linkedList.addToEnd(30);

        ArrayList<Integer> list = linkedList.toArrayList();

        assertEquals(3, list.size()); 
        assertEquals(10, list.get(0)); 
        assertEquals(20, list.get(1)); 
        assertEquals(30, list.get(2)); 
    }

}
