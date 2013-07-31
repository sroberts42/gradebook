package gradebook.model;

/**
 *GradingScheme is an interface that defines a grading
 *scheme used by student objects to determine scores
 *and letter grades.
 *
 *@author Susan Roberts
 */

public interface GradingScheme {

    double averageScore();

    char letterGrade();

}
