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

    public GradebookItem(String name, GradebookCategory category, double score) {
        this.name = name;
        this.category = category;
        this.score = score;
    }

    public void setGradebookCategory(GradebookCategory category) {
        this.category = category;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
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
}