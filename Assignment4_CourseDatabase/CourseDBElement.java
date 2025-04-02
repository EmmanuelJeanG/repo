package application;

public class CourseDBElement {
    
    private String courseID;
    private int crn;
    private int credits;
    private String roomNum;
    private String instructor;

    public CourseDBElement() {
    }
    
    public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
        this.courseID = id;
        this.crn = crn;
        this.credits = credits;
        this.roomNum = roomNum;
        this.instructor = instructor;
    }
    
    public CourseDBElement(CourseDBElement element) {
        this.courseID = element.courseID;
        this.crn = element.crn;
        this.credits = element.credits;
        this.roomNum = element.roomNum;
        this.instructor = element.instructor;
    }

    public String getID() {
        return courseID;
    }
    
    public void setID(String id) {
        this.courseID = id;
    }
    
    public int getCRN() {
        return crn;
    }
    
    public void setCRN(int crn) {
        this.crn = crn;
    }
    
    public int getCredits() {
        return credits;
    }
    
    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    public String getRoomNum() {
        return roomNum;
    }
    
    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }
    
    public String getInstructor() {
        return instructor;
    }
    
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    
    @Override
    public int hashCode() {
        return String.valueOf(crn).hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CourseDBElement other = (CourseDBElement) obj;
        return this.crn == other.crn;
    }
    
    @Override
    public String toString() {
    	return "Course:" + courseID + " CRN:" + crn + " Credits:" + credits + " Instructor:" + instructor + " Room:" + roomNum;
    }
}
