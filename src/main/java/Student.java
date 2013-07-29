package gradebook.model;

public class Student{
	
	private String name;
	private double score;
	
	public Student(String name){
		this.name =  name;
	}
	
	public double getScore(){
		return score;
	}
	
	public char letterGrade(){
		return 'A';
	}
	

}