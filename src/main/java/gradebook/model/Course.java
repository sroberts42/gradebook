package gradebook.model;

/**
 *Course is classification for classes.
 *
 *This file has a method for average score and for letter grade
 *as well as getters and setters.
 *@author Susan Roberts
 */

public class Course extends Grading {

    private String subject;
    private int courseNumber;
    private String courseName;
    private GradebookDB<Course> prerequisites;
    private GradebookDB<Class> classes;

    public Course(String subject, int courseNumber, String courseName,
            GradebookDB<Course> prerequisites) {
        this.subject = subject;
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        classes = new GradebookImpl<Class>();
        this.prerequisites = prerequisites;
    }

    public boolean addClasses(GradebookDB<Class> classes) {
        boolean wasAdded = false;
        for (int i = 0; i < classes.size(); i++) {
            this.classes.add(classes.get(i));
            wasAdded = true;
        }
        return wasAdded;
    }

    public GradebookDB<Grading> grading() {
        GradebookDB<Grading> temp = new GradebookImpl<Grading>();
        for (int i = 0; i < classes.size(); i++) {
            temp.add(classes.get(i));
        }
        return temp;
    }

    public char letterGrade() {
        return super.findLetterGrade();
    }

    public double averageScore() {
        return super.averageScore();
    }

    public String getSubject() {
        return subject;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public GradebookDB<Course> getPrerequisites() {
        return prerequisites;
    }
}
