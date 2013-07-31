package gradebook.model;

 /**
 *Grading is the file that is used to calculate the numeric averages and letter
 *grades for any class that may need it.
 *
 *This file has a method for average score and for letter grade
 *as well as a way to find which type of object needs calculation.
 *@author Susan Roberts
 */

public abstract class Grading {
    private final int gradeA = 90;
    private final int gradeB = 80;
    private final int gradeC = 70;
    private final int gradeD = 60;
    private final int gradeF = 0;
    public abstract GradebookDB<Grading> grading();

    public  char findLetterGrade() {
        char letterGrade = 'Z';
        double score = averageScore();
        if (score >= gradeA) {
            letterGrade = 'A';
        } else if (score < gradeA && score >= gradeB) {
            letterGrade = 'B';
        } else if (score < gradeB && score >= gradeC) {
            letterGrade = 'C';
        }  else if (score < gradeC && score >= gradeD) {
            letterGrade = 'D';
        } else if (score < gradeD && score >= gradeF) {
            letterGrade = 'F';
        }
        return letterGrade;
    }

    public double averageScore() {
        double score = 0.0;
        GradebookDB<Grading> list = grading();
        for (int i = 0; i < list.size(); i++) {
            score += (list.get(i).averageScore());
        }
        return score / (list.size());
    }
}
