package gradebook.model;

/**
 *GradebookItem is an assignment that a student gets a grade for.
 *
 *This file has getters and setters for each part of GradebookItem.
 *@author Susan Roberts
 */

public class GradebookItem {

    private String name;
    private GradebookCategory category;
    private double score;

    public GradebookItem(String name, GradebookCategory category,
            double score) {
        this.name = name;
        this.category = category;
        this.score = score;
    }

    public GradebookCategory getGradebookCategory() {
        return this.category;
    }

    public double getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
    public void setGradebookCategory(GradebookCategory category) {
        this.category = category;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean setName(String name) {
        if (name != null) {
            this.name = name;
            return true;
        } else {
            return false;
        }
    }
}
