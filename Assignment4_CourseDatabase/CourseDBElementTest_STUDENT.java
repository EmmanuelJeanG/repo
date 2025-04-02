package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBElementTest_STUDENT {
	private CourseDBElement course1;
    private CourseDBElement course2;
    private CourseDBElement course3;

	@BeforeEach
	void setUp() throws Exception {
		course1 = new CourseDBElement("CMSC204", 30504, 4, "SC450", "Dr. Smith");
        course2 = new CourseDBElement("CMSC203", 12345, 3, "SC300", "Dr. Johnson");
        course3 = new CourseDBElement("CMSC204", 30504, 4, "SC450", "Dr. Smith"); // Duplicate of course1
	}

	@AfterEach
	void tearDown() throws Exception {
		course1 = course2 = course3 = null;
	}

	@Test
	void testHashCode() {
		assertEquals(Integer.valueOf("30504".hashCode()), course1.hashCode());
        assertEquals(Integer.valueOf("12345".hashCode()), course2.hashCode());
	}

	@Test
	void testGetId() {
		assertEquals("CMSC204", course1.getID());
        assertEquals("CMSC203", course2.getID());
	}

	@Test
	void testGetCrn() {
		assertEquals(30504, course1.getCRN());
        assertEquals(12345, course2.getCRN());
	}

	@Test
	void testGetCredits() {
		assertEquals(4, course1.getCredits());
        assertEquals(3, course2.getCredits());
	}

	@Test
	void testGetRoomNum() {
		assertEquals("SC450", course1.getRoomNum());
        assertEquals("SC300", course2.getRoomNum());
	}

	@Test
	void testEqualsObject() {
		assertTrue(course1.equals(course3)); // Same course
        assertFalse(course1.equals(course2)); // Different course
	}

}
