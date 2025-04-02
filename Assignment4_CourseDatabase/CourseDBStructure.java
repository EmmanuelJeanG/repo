package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {
    
    private ArrayList<LinkedList<CourseDBElement>> hashTable;
    private int tableSize;
    
    public CourseDBStructure(String test, int size) {
        this.tableSize = size;
        this.hashTable = new ArrayList<>(tableSize);

        for (int i = 0; i < tableSize; i++) {
            hashTable.add(new LinkedList<>());
        }
    }
    
    public CourseDBStructure(int num) {
        int estimatedSize = (int) (num / 1.5);
        this.tableSize = get4KPrime(estimatedSize);

        this.hashTable = new ArrayList<>(tableSize);

        for (int i = 0; i < tableSize; i++) {
            hashTable.add(new LinkedList<>());
        }
    }
    
    @Override
    public void add(CourseDBElement element) {
        int index = Math.abs(element.getCRN() % tableSize);
        LinkedList<CourseDBElement> list = hashTable.get(index);
        
        for (CourseDBElement existingElement : list) {
            if (existingElement.getCRN() == element.getCRN()) {
                list.remove(existingElement);
                break;
            }
        }
        list.add(element);
    }
    
    @Override
    public CourseDBElement get(int crn) throws IOException {
        int index = Math.abs(crn % tableSize);
        LinkedList<CourseDBElement> list = hashTable.get(index);
        
        for (CourseDBElement element : list) {
            if (element.getCRN() == crn) {
                return element;
            }
        }
        throw new IOException("Course with CRN " + crn + " not found.");
    }
    
    @Override
    public int getTableSize() {
        return tableSize;
    }
    
    @Override
    public ArrayList<String> showAll() {
        ArrayList<String> courseList = new ArrayList<>();
        
        for (LinkedList<CourseDBElement> list : hashTable) {
            for (CourseDBElement element : list) {
                courseList.add(element.toString());
            }
        }
        
        return courseList;
    }
    
    public static int get4KPrime(int num) {
        while (true) { 
            if ((num - 3) % 4 == 0) { 
                boolean isPrime = true;
                if (num < 2) {
                    isPrime = false;
                } else {
                    for (int i = 2; i * i <= num; i++) {
                        if (num % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                }
                if (isPrime) {
                    return num;
                }
            }
            num++;
        }
    }
}
