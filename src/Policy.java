

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Created by Hollis Pultz
 * Authorized for use by Hollis Pultz only.
 * Unauthorized use considered violation of UMW honor policy
 */

/**
 *
 * @author hollispultz
 */
public class Policy {
	
    /**
     * grade points for A and A+
     */
	public static final double A_VAL = 4.00;
    /**
     * grade points for A-
     */
	public static final double AM_VAL = 3.70;
    /**
     * grade points for B+
     */
	public static final double BP_VAL = 3.33;
    /**
     * grade points for B
     */
	public static final double B_VAL = 3.00;
    /**
     * grade points for B-
     */
	public static final double BM_VAL = 2.70;
    /**
     * grade points for C+
     */
	public static final double CP_VAL = 2.30;
    /**
     * grade points for C
     */
	public static final double C_VAL = 2.00;
    /**
     * grade points for C-
     */
	public static final double CM_VAL = 1.70;
    /**
     * grade points for D+
     */
	public static final double DP_VAL = 1.30;
    /**
     * grade points for D
     */
	public static final double D_VAL = 1.00;
    /**
     * grade points for D-
     */
	public static final double DM_VAL = 0.70;
    /**
     * grade points for F
     */
	public static final double F_VAL = 0.00;

    /**
     * @param gpa the students gpa score
     * @return boolean for whether or not student qualifies
     */
	static boolean qualifiesForProbation(double gpa) {

		return gpa < 2.0;
	}
	
    /**
     * @param gpa the students gpa score
     * @return boolean for whether or not student qualifies
     */
	static boolean qualifiesForDeansList(double gpa) {

		return gpa >= 3.5 && gpa < 4.0;
	} 

    /**
     * @param gpa the students gpa score
     * @return boolean for whether or not student qualifies
     */
	static boolean qualifiesForPresidentsList(double gpa) {

		return gpa >= 4.0;
	}

    /**
     * @param grade the string letter grade passed in 
     * @return boolean for whether or not the class will count for the GPA
     */
	static double gpaPts(String grade) throws Exception {
		switch(grade.toUpperCase().trim()) {
			case "A+": case "A":
				return A_VAL;
			case "A-":
				return AM_VAL;
			case "B+":
				return BP_VAL;
			case "B":
				return B_VAL;
			case "B-":
				return BM_VAL;
			case "C+":
				return CP_VAL;
			case "C":
				return C_VAL;
			case "C-":
				return CM_VAL;
			case "D+":
				return DP_VAL;
			case "D":
				return D_VAL;
			case "D-":
				return DM_VAL;
			case "F":
				return F_VAL;
			default :
				throw new Exception("Sorry, that is an invalid grade.");
		}
	}

    /**
     * @param grade the string letter grade passed in 
     * @return boolean for whether or not the class will count for the GPA
     */
	static boolean affectGPA(String grade) {
		switch (grade.toUpperCase().trim()) {
			case "P": case "NP": case "W": case "I":
				return false;
			default:
				return true;
		}
	}
	
}
