package gradebook.model;

/**
 *GradingSchemeExample is an implementation of the
 *interface grading scheme
 *
 *This class contains all necessary methods from the
 *grading scheme interface, as well as a way to add items
 *to the grading scheme.
 *@author Susan Roberts
 */

public class GradingSchemeExample implements GradingScheme {

    private GradebookDB<GradebookItem> items;
    private double pointsEarned;
    private final int gradeA = 90;
    private final int gradeB = 80;
    private final int gradeC = 70;
    private final int gradeD = 60;
    private final int gradeF = 0;

    public GradingSchemeExample(GradebookDB<GradebookItem> items) {
        this.items = items;
    }

    public boolean addGradingItems(GradebookDB<GradebookItem> itemList) {
        boolean wasAdded = false;
        if (itemList.size() > 0) {
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
            pointsEarned +=  items.get(i).getScore()
                * items.get(i).getGradebookCategory().getWeight();
        }
        return pointsEarned;
    }

    @Override
    public char letterGrade() {
        char letterGrade = 0;
        if (averageScore() >= gradeA) {
            letterGrade = 'A';
        } else if (averageScore() >= gradeB) {
            letterGrade = 'B';
        } else if (averageScore() >= gradeC) {
            letterGrade = 'C';
        }  else if (averageScore() >= gradeD) {
            letterGrade = 'D';
        } else if (averageScore() >= gradeF) {
            letterGrade = 'F';
        }
        return letterGrade;
    }
}
