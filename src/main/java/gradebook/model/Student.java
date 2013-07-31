package gradebook.model;

public class Student extends Grading implements GradingScheme {

    private String name;
    private GradebookDB<GradebookItem> scores;
    private GradingSchemeExample gradingScheme;

    public GradebookDB<Grading> grading() {
        return null;
    }

    public Student(String name) {
        this.name =  name;
        scores = new GradebookImpl<GradebookItem>();
        gradingScheme = new GradingSchemeExample(new GradebookImpl<GradebookItem>());
    }

    public boolean setScores(GradebookDB<GradebookItem> list) {
        boolean added = false;
        if(list.size() > 0) {
            scores = list;
            gradingScheme.addGradingItems(scores);
            added = true;
        }
        return added;
    }

    @Override
    public char letterGrade() {
        return gradingScheme.letterGrade();
    }

    @Override
    public double averageScore() {
        return gradingScheme.averageScore();
    }

    public String getName() {
        return name;
    }


}