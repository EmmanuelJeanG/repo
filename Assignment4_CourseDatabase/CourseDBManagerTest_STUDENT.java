package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
class CourseDBManagerTest_STUDENT {
	private CourseDBManager dataMgr;

	@BeforeEach
	void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		dataMgr = null;
	}

	@Test
	void testAdd() {
		 try {
	            dataMgr.add("CMSC204", 12345, 4, "SC200", "Dr. Smith");
	            assertEquals(12345, dataMgr.get(12345).getCRN());
	        } catch (Exception e) {
	            fail("Adding should not throw an exception.");
	        }
	}

	@Test
	void testShowAll() {
	    dataMgr.add("CMSC204", 12345, 4, "SC200", "Dr. Smith");
	    dataMgr.add("CMSC203", 67890, 3, "SC300", "Dr. Jones");

	    ArrayList<String> courses = dataMgr.showAll();
	    courses.forEach(course -> System.out.println(course)); 

	    assertNotNull(courses);
	    assertEquals(2, courses.size());

	    assertTrue(courses.stream().anyMatch(course -> course.contains("Course:CMSC204") && course.contains("CRN:12345")));
	    assertTrue(courses.stream().anyMatch(course -> course.contains("Course:CMSC203") && course.contains("CRN:67890")));
	}

	@Test
	void testReadFile() {
		try {
            File testFile = new File("testFile.txt");
            PrintWriter writer = new PrintWriter(testFile);
            writer.println("CMSC204 12345 4 SC200 Dr.Smith");
            writer.println("CMSC203 67890 3 SC300 Dr.Jones");
            writer.close();

            dataMgr.readFile(testFile);

            assertEquals("CMSC204", dataMgr.get(12345).getID());
            assertEquals("CMSC203", dataMgr.get(67890).getID());
            
            testFile.delete();
        } catch (FileNotFoundException e) {
            fail("File should exist.");
        } catch (Exception e) {
            fail("Reading file should not throw an exception.");
        }
	}

	@Test
	void testGet() {
	    dataMgr.add("CMSC204", 12345, 4, "SC200", "Dr. Smith");

	    assertEquals("CMSC204", dataMgr.get(12345).getID());


	    CourseDBElement course = dataMgr.get(99999);  // CRN that does not exist
	    

	    assertNull(course, "Expected no course to be found for CRN 99999");
	}

}
