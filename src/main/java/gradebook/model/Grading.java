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

    public abstract GradebookDB<Grading> grading();

    public  char findLetterGrade() {
        char letterGrade = 'Z';
        double score = averageScore();
         if(score >= 90) {
            letterGrade = 'A';
        } else if(score < 90 && score >= 80) {
            letterGrade = 'B';
        } else if(score < 80 && score >= 70) {
            letterGrade = 'C';
        }  else if(score < 70 && score >= 60) {
            letterGrade = 'D';
        } else if(score < 60 && score >= 0) {
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
        return score/(list.size());
    }

}