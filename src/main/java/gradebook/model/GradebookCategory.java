package gradebook.model;

/**
 *GradebookCategory is the category that a GradebookItem is classified under.
 *
 *This file has getters and setters for each part of GradebookCategory.
 *@author Susan Roberts
 */

public class GradebookCategory {
    private String name;
    private double weight;
    private GradebookDB<GradebookItem> items;

    public GradebookCategory(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public boolean setItemList(GradebookDB<GradebookItem> items) {
        if (items.size() > 0) {
            this.items = items;
            return true;
        } else {
            return false;
        }
    }

    public double getWeight() {
        return weight;
    }

    public GradebookDB<GradebookItem> getItemList() {
        return items;
    }

    public int getNumberItems() {
        return items.size();
    }

    public String getName() {
        return name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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
