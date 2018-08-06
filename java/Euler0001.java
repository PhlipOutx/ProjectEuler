/*
*    Project Euler problem solutions
*     - Philip Miller
*    
*    Solution to problem 1
*/

public final class Euler0001 {

	public static void solution() {
		long t1, t2, delta, sol;

		System.out.println("\nProject Euler - Problem 1");
		System.out.println("-------------------------");
		System.out.println("If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.\n");

		
		System.out.println("Solution 1 - O(n) runtime");
		t1 = System.currentTimeMillis();
		sol = bruteforce(1000);
		t2  = System.currentTimeMillis();
		delta = t2-t1;
		System.out.println(sol);
		System.out.println("Answer generated in " + delta + " ms\n");

		System.out.println("Solution 2 - O(1) runtime");
		t1 = System.currentTimeMillis();
		sol = arithmeticProgression(1000);
		t2  = System.currentTimeMillis();
		delta = t2-t1;
		System.out.println(sol);
		System.out.println("Answer generated in " + delta + " ms\n");

		System.out.println("Its hard to see the runtime difference with such a small number of calculations. Here it is again when we find the sum of all multiples of 3 or 5 below 200,000,000\n");

		System.out.println("Solution 1 - O(n) runtime");
		t1 = System.currentTimeMillis();
		sol = bruteforce(200000000);
		t2  = System.currentTimeMillis();
		delta = t2-t1;
		System.out.println(sol);
		System.out.println("Answer generated in " + delta + " ms\n");

		System.out.println("Solution 2 - O(1) runtime");
		t1 = System.currentTimeMillis();
		sol = arithmeticProgression(200000000);
		t2  = System.currentTimeMillis();
		delta = t2-t1;
		System.out.println(sol);
		System.out.println("Answer generated in " + delta + " ms\n");
	}

	// The O(n) solution
	private static long bruteforce(long sumBelow) {
		long sum = 0;
		for (long i = 0; i < sumBelow; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		return sum;
	}

	// The O(1) solution
	private static long arithmeticProgression(long sumBelow) {
		return sumAllDivisble(3, sumBelow-1) + sumAllDivisble(5, sumBelow-1) - sumAllDivisble(15, sumBelow-1);
	}

	// 1+2+3+...+N = (N*(N+1))/2
	private static long sumAllDivisble(long M, long N) {
		return M * (((N/M) * ((N/M) + 1)) / 2);
	}
}