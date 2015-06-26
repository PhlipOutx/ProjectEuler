/*
*    Project Euler problem solutions
*     - Philip Miller
*    
*    Entry point into the java application
*/

import EulerProblems.*;

public final class ProjectEuler {

	public static void main(String[] args) {

		int ProblemNumber = 0;

		if (args.length != 1) {
			displayHelpText();
			System.exit(0);
		}

		try {
			ProblemNumber = Integer.parseInt(args[0]);
			executeProblem(ProblemNumber);
			System.exit(0);
		}
		catch (NumberFormatException nfe) {
			System.out.println("The first argument must be an integer.");
			System.exit(1);
        }
	}

	public static void displayHelpText() {
		System.out.println("\nProject Euler Problem Solutions");
		System.out.println("  - by Philip Miller\n");
		System.out.println(" % java ProjectEuler [Problem]\n");
		System.out.println("See source code for an explaination of the problem and answer.\n");
	}

	public static void executeProblem(int ProblemNumber) {

		switch (ProblemNumber) {
			case 1:		
				Euler0001.solution();
				break;
			case 2:		
				Euler0002.solution();
				break;
			case 3:		
				Euler0003.solution();
				break;
			case 4:		
				Euler0004.solution();
				break;
			default:	
				System.out.println("Problem " + ProblemNumber + " is not yet implemented.");
				break;
		}
	}

}