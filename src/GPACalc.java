import static java.lang.System.out;
import java.util.Scanner;

/*
 * Created by Hollis Pultz
 * Authorized for use by Hollis Pultz only.
 * Unauthorized use considered violation of UMW honor policy
 */

/**
 * simple java program to calculate GPA for a semester.  factors in letter
 * grades, total credits attemped.  accounts for Pass/Fail, Withdrawl, and
 * Incompletes
 * @author hollispultz
 */
public class GPACalc {

    /**
     * main method.  acquires user input of number of credits per class and the
     * letter grade received for the class.  
     */
	public static void main(String[] args) {

        double gpa = 0.00; // student's GPA score
		int credits = 0; // credits per class
		int totalCredits = 0; // total credits taken for semester
		double totalGradePoints = 0; // total number of earned gradepoints
		String grade = ""; // grade earned for class
		int classNumber = 0; // the class entering information for
		Scanner in = new Scanner(System.in); // Scanner object for terminal input

		while(credits != -1) { // while the user has not entered "-1" to exit

			classNumber++;
			boolean creditPass = false; // success getting answer for credits
			boolean gradePass = false; // success getting answer for grade

			while(!creditPass) { // while waiting on successful credit input
				
				try {  // try catch block to catch bad inputs
					
					out.println();
					out.printf("How many credits for the course #%d? (-1 to quit)  ", classNumber);
					credits = in.nextInt(); // get number of credits from user
					if(credits < -1 || credits == 0 || credits > 6) { // make sure credits in reasonable range

						throw new Exception(); // use thrown exception to indicate bad input
					}
					creditPass = true; // signal that credits acquired successfully
					in.nextLine(); // consume stray characters
				} catch(Exception e) { // catch wrong input exceptions
					
                    out.println();
					out.println("Sorry, that is an invalid option or number of credits.");
					in.nextLine(); // consume stray characters
				}
			}

			while(gradePass == false  && credits != -1) { // while waiting on successful grade input and user has not opted to exit

				try {  // try catch block to catch bad input

					out.println();
					out.printf("What grade did you get in course #%d?  ", classNumber);
					grade = in.nextLine(); // get letter grade
					if(Policy.affectGPA(grade)) { // determine whether or not grade will affect GPA
						
						totalGradePoints += computeGradePoints(Policy.gpaPts(grade), credits); // compute the new total grade points per equation from http://www.back2college.com/gpa.htm 
						totalCredits += credits; // compute new total of attempted credits
					}
					gradePass = true; // signal that grade acquired successfull
				} catch(Exception e) { out.println(); out.println(e.getMessage()); }
			}
		}
		if(classNumber > 1) { // ensure that user has entered credits and grades and not typed "-1" at first prompt
			gpa = totalGradePoints / (double) totalCredits; // calculate gpa
			out.println();
            
            if(Double.isNaN(gpa)) { // if student gpa was not calculated due to irregular grade types

                out.println("Sorry, you have not earned a GPA this semester.");
            } else {

                out.printf("Your GPA is: %.2f", gpa);
            }
			
			if (Policy.qualifiesForPresidentsList(gpa) && totalCredits >= 12) { out.println("  You made the President's List!"); }
			else if (Policy.qualifiesForDeansList(gpa) && totalCredits >= 12) { out.println("  You made the Deans's List!"); }
			else if (Policy.qualifiesForProbation(gpa)) { out.println("You will be placed on academic probation. :\'("); }
			else { out.println(); }
			
		}
	}

    /**
     * @param coursePts the points to be attributed based on letter grade
     * @param numCredits the number of credits the course is worth
     * @return the grade points to be factored into the GPA for the course
     */
	static double computeGradePoints(double coursePts, int numCredits) {

		return coursePts * (double) numCredits;
	}
	
}
