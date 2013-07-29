package gradebook.model;

import java.util.List;

public class Class{
	
	private Course course;
	private String semester;
	private List<Section> sections;
	private double score;
	public Class(Course course, String semester, List<Section> sections){
		this.course = course;
		this.semester = semester;
		this.sections = sections;
	}
	
	public double averageScore(){
		for(Section s: sections){
			score += s.averageScore();
		}
		return score/(sections.size());
	}
	
	public char averageLetterGrade(){
		return 'A';
	}
}