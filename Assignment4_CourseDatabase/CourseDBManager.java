package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
    private CourseDBStructure database;

    public CourseDBManager() {
        database = new CourseDBStructure(100); 
    }

    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
    	System.out.println("Adding course: " + id + " " + crn + " " + credits + " " + roomNum + " " + instructor);
        CourseDBElement course = new CourseDBElement(id, crn, credits, roomNum, instructor);
        database.add(course);
    }

    @Override
    public CourseDBElement get(int crn) {
    	try {
    		System.out.println("Retrieving course with CRN: " + crn);
            return database.get(crn);
        } catch (IOException e) {
            System.out.println("Error: Course with CRN " + crn + " not found.");
            return null;
        }
    }

    @Override
    public void readFile(File input) throws FileNotFoundException {
    	System.out.println("Reading file: " + input.getName());
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println("Processing line: " + line);
            String[] data = line.split("\\s+", 5);
            if (data.length == 5) {
                String id = data[0];
                int crn = Integer.parseInt(data[1]);
                int credits = Integer.parseInt(data[2]);
                String roomNum = data[3];
                String instructor = data[4];
                add(id, crn, credits, roomNum, instructor);
            }else {
                System.out.println("Invalid line format: " + line);
            }
        }
        scanner.close();
    }

    @Override
    public ArrayList<String> showAll() {
    	System.out.println("Fetching all courses...");
    	ArrayList<String> courses = database.showAll();
        for (String course : courses) {
            System.out.println(course);
        }
        return courses;
    	
    }
}
