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

class SortedDoubleLinkedListTest_STUDENT {
	private SortedDoubleLinkedList<Integer> sortedList;
    private Comparator<Integer> comparator;

	@BeforeEach
	void setUp() throws Exception {
		comparator = (x, y) -> x.compareTo(y);
        sortedList = new SortedDoubleLinkedList<>(comparator);
	}

	@AfterEach
	void tearDown() throws Exception {
		sortedList = null;
	}

	@Test
	void testIterator() {
		sortedList.add(50);
        sortedList.add(10);
        sortedList.add(30);
        sortedList.add(20);

        ListIterator<Integer> iterator = sortedList.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(10, iterator.next());
        assertEquals(20, iterator.next());
        assertEquals(30, iterator.next());
        assertEquals(50, iterator.next());
        assertFalse(iterator.hasNext());
	}

	@Test
	void testRemove() {
		sortedList.add(10);
        sortedList.add(20);
        sortedList.add(30);

        assertEquals(20, sortedList.remove(20, comparator)); // Removes 20
        assertEquals(2, sortedList.getSize()); 
        assertNull(sortedList.remove(50, comparator)); // Removing this element should return null
    }

	@Test
	void testAdd() {
		sortedList.add(50);
        sortedList.add(10);
        sortedList.add(30);
        sortedList.add(20);

        ArrayList<Integer> list = sortedList.toArrayList();

        assertEquals(4, list.size()); 
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2)); 
        assertEquals(50, list.get(3));
    }

}
