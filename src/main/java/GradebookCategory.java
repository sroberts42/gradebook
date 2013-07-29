package gradebook.model;

import java.util.List;

public class GradebookCategory{
	private String name;
	private double weight;
	private List<GradebookItem> items;
	private int numberOfItems;
	
	public GradebookCategory(String name, double weight){
		this.name = name;
		this.weight = weight;
		this.numberOfItems = 0;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public void setItemList(List<GradebookItem> items){
		this.items = items;
		numberOfItems = this.items.size();
	}
	
	public List<GradebookItem> getItemList(){
		return items;
	}
	
	public int getNumberItems(){
		return numberOfItems;
	}
}