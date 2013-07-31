package gradebook.model;

public class Section extends Grading{

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

    public void setStudents(GradebookDB<Student> students) {
        this.students = students;
    }
    public GradebookDB<Student> getStudents() {
        return this.students;
    }
}