package gradebook.model;

import java.util.List;

public class Course{
	
	private String subject;
	private int courseNumber;
	private String courseName;
	private List<Course> prerequisites;
	
	public Course(String subject, int courseNumber, String courseName, List<Course> prerequisites){
		this.subject = subject;
		this.courseNumber = courseNumber;
		this.courseName = courseName;
		this.prerequisites = prerequisites; 
	}
}