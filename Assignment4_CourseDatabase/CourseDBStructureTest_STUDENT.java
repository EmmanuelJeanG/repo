package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test template provided to students
 * Students must implement the methods
 * 
 * @author Farnaz Eivazi
 * @version 1/31/2024
 *
 */
class CourseDBStructureTest_STUDENT {
	private CourseDBStructure cds;

	@BeforeEach
	void setUp() throws Exception {
		cds = new CourseDBStructure(20);
	}

	@AfterEach
	void tearDown() throws Exception {
		cds = null;
	}

	@Test
	void testCourseDBStructureStringInt() {
		CourseDBStructure testStructure = new CourseDBStructure("Testing", 20);
		assertEquals(20, testStructure.getTableSize());
	}

	@Test
	void testCourseDBStructureInt() {
		assertEquals(19, cds.getTableSize()); 
	}

	@Test
	void testAdd() {
		CourseDBElement course = new CourseDBElement("CMSC204", 12345, 4, "SC200", "Dr. Smith");
		cds.add(course);
		try {
			assertEquals(course, cds.get(12345));
		} catch (IOException e) {
			fail("Course should be retrievable after adding.");
		}
	}

	@Test
	void testShowAll() {
		cds.add(new CourseDBElement("CMSC204", 12345, 4, "SC200", "Dr. Smith"));
		cds.add(new CourseDBElement("CMSC203", 67890, 3, "SC300", "Dr. Jones"));
		ArrayList<String> courses = cds.showAll();
		assertNotNull(courses);
		assertEquals(2, courses.size());
		boolean found12345 = false;
		boolean found67890 = false;

		for (String course : courses) {
		    if (course.contains("12345")) {
		        found12345 = true;
		    }
		    if (course.contains("67890")) {
		        found67890 = true;
		    }
		}

		assertTrue(found12345);
		assertTrue(found67890);
	}

	@Test
	void testGet() {
		CourseDBElement course = new CourseDBElement("CMSC204", 12345, 4, "SC200", "Dr. Smith");
		cds.add(course);
		try {
			assertEquals(course, cds.get(12345));
		} catch (IOException e) {
			fail("IOException should not be thrown for an existing course.");
		}
		assertThrows(IOException.class, () -> cds.get(99999));
	}

	@Test
	void testGetTableSize() {
		assertEquals(19, cds.getTableSize());
	}

	@Test
	void testGet4KPrime() {
		assertEquals(347, CourseDBStructure.get4KPrime(333));
		assertEquals(1019, CourseDBStructure.get4KPrime(1000));
		assertEquals(383, CourseDBStructure.get4KPrime(380));
	}

}
