package gradebook.model;

/**
 *Class is a group of sections.
 *
 *This file has a method for average score and for letter grade
 *as well as getters and setters.
 *@author Susan Roberts
 */

public class Class extends Grading {

    private Course course;
    private String semester;
    private GradebookDB<Section> sections;

    public Class(Course course, String semester,
            GradebookDB<Section> sections) {
        this.sections = new GradebookImpl<Section>();
        for (int i = 0; i < sections.size(); i++) {
            this.sections.add(sections.get(i));
        }
        this.course = course;
        this.semester = semester;
    }

    public GradebookDB<Grading> grading() {
        GradebookDB<Grading> temp = new GradebookImpl<Grading>();
        for (int i = 0; i < sections.size(); i++) {
            temp.add(sections.get(i));
        }
        return temp;
    }

    public char letterGrade() {
        return super.findLetterGrade();
    }

    public double averageScore() {
        return super.averageScore();
    }

    public String getSemester() {
        return semester;
    }

    public Course getCourse() {
        return course;
    }

    public boolean setSemester(String semester) {
        if (semester != null) {
            this.semester = semester;
            return true;
        } else {
            return false;
        }
    }

    public boolean setCourse(Course course) {
        if (course != null) {
            this.course = course;
            return true;
        } else {
            return false;
        }
    }
}
