package gradebook.model;

public class GradebookItem{
	
	private String name;
	private GradebookCategory category;
	private double score;
	
	public GradebookItem(String name, GradebookCategory category){
		this.name = name;
		this.category = category; 
	}
	
	public GradebookCategory getGradebookCategory(){
		return this.category;
	}
	
	public void setScore(double score){
		this.score = score;
	}
	
	public double getScore(){
		return score;
	}
}