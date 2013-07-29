package gradebook.model;

import java.util.ArrayList;
import java.util.List;

public class Section{
	
	private List<Student> students;
	double totalScore;
	public Section(List<Student> students){
		this.students = new ArrayList<Student>();
		this.students.addAll(students);
	}
	
	public double averageScore(){
		totalScore = 0;
		for(Student s: this.students){
			totalScore+=s.getScore();
		}
		return totalScore/(students.size());
	}
	
	public char averageLetterGrade(){
		return 'A';
	}
}