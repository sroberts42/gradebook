package gradebook.model;

import java.util.List;

public class GradingSchemeExample implements GradingScheme{

	List<GradebookItem> items;
	double pointsEarned;
	
	public GradingSchemeExample(List<GradebookItem> items) {
		this.items = items;
	}

	@Override
	public double averageScore() {
		pointsEarned = 0;
		for(GradebookItem i: items){
			pointsEarned += (i.getGradebookCategory().getWeight() * i.getScore())/i.getGradebookCategory().getNumberItems();
		}
		return pointsEarned;
	}

	@Override
	public char letterGrade() {
		char letterGrade = 0;
		if(pointsEarned >= 90){
			letterGrade = 'A';
		} else if(pointsEarned < 90 && pointsEarned >= 80){
			letterGrade = 'B';
		} else if(pointsEarned < 80 && pointsEarned >= 70){
			letterGrade = 'C';
		}  else if(pointsEarned < 70 && pointsEarned >= 60){
			letterGrade = 'D';
		} else if(pointsEarned < 60 && pointsEarned >= 0){
			letterGrade = 'F';
		}
		return letterGrade;
	}

}
