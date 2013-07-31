package gradebook.model;

/**
 *Section is collection of Students.
 *
 *This class contains a way to calculate average
 *score and letter grade as well as getters and
 *setters for the object of type Section.
 *@author Susan Roberts
 */

public class Section extends Grading {

    private GradebookDB<Student> students;

    public Section(GradebookDB<Student> students) {
        this.students = new GradebookImpl<Student>();
        for (int i = 0; i < students.size(); i++) {
            this.students.add(students.get(i));
        }
    }

    public GradebookDB<Grading> grading() {
        GradebookDB<Grading> temp = new GradebookImpl<Grading>();
        for (int i = 0; i < students.size(); i++) {
            temp.add(students.get(i));
        }
        return temp;
    }

    public char letterGrade() {
        return super.findLetterGrade();
    }

    public double averageScore() {
        return super.averageScore();
    }

    public boolean setStudents(GradebookDB<Student> students) {
        if (students.size() > 0) {
            this.students = students;
            return true;
        } else {
            return false;
        }
    }
    public GradebookDB<Student> getStudents() {
        return this.students;
    }
}
