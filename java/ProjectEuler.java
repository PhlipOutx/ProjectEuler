/*
*    Project Euler problem solutions
*     - Philip Miller
*    
*    Entry point into the java application
*/

import java.lang.reflect.Method;

public final class ProjectEuler {

	public static void main(String[] args) {

		int problemNumber = 0;

		if (args.length != 1) {
			displayHelpText();
			System.exit(0);
		}

		try {
			problemNumber = Integer.parseInt(args[0]);
			executeProblem(problemNumber);
			System.exit(0);
		}
		catch (NumberFormatException nfe) {
			System.out.println("The first argument must be an integer.");
			System.exit(1);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			System.exit(1);
		}
	}

	public static void displayHelpText() {
		System.out.println("\nProject Euler Problem Solutions");
		System.out.println("  - by Philip Miller\n");
		System.out.println("% make run.java [Problem]\n");
		System.out.println("See source code for an explaination of the problem and answer.\n");
	}

	public static void executeProblem(int problemNumber) throws Exception {
		try {
			String className = String.format("Euler%04d", problemNumber);
			Class<?> problem = Class.forName(className);
			Method solution = problem.getMethod("solution");
			solution.invoke(null);
		} catch(ClassNotFoundException e) {
			System.out.println("Problem " + problemNumber + " is not yet implemented.");
		}
	}

}