package gradebook.model;

public class GradingSchemeExample implements GradingScheme {

    private GradebookDB<GradebookItem> items;
    private double pointsEarned;

    public GradingSchemeExample(GradebookDB<GradebookItem> items) {
        this.items = items;
    }

    public boolean addGradingItems(GradebookDB<GradebookItem> itemList) {
        boolean wasAdded = false;
        if(itemList.size() > 0) {
            for (int i = 0; i < itemList.size(); i++) {
                items.add(itemList.get(i));
            }
            wasAdded = true;
        }
        return wasAdded;
    }

    @Override
    public double averageScore() {
        pointsEarned = 0;
        for (int i = 0; i < items.size(); i++) {
            pointsEarned +=  items.get(i).getScore() * items.get(i).getGradebookCategory().getWeight();
        }
        return pointsEarned;
    }

    @Override
    public char letterGrade() {
        char letterGrade = 0;
        if(averageScore() >= 90) {
            letterGrade = 'A';
        } else if(averageScore() >= 80) {
            letterGrade = 'B';
        } else if(averageScore() >= 70) {
            letterGrade = 'C';
        }  else if(averageScore() >= 60) {
            letterGrade = 'D';
        } else if(averageScore() >= 0) {
            letterGrade = 'F';
        }
        return letterGrade;
    }
}
