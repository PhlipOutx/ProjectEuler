/*
*    Project Euler problem solutions
*     - Philip Miller
*    
*    Solution to problem 4
*/

public final class Euler0004 {

	public static void solution() {
		long t1, t2, delta, sol;

		System.out.println("\nProject Euler - Problem 4");
		System.out.println("-------------------------");
		System.out.println("A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.\n");
		System.out.println("Find the largest palindrome made from the product of two 3-digit numbers.\n");

		System.out.println("Solution 1 - O(n^2)) runtime");
		t1 = System.currentTimeMillis();
		sol = bruteforce(3);
		t2  = System.currentTimeMillis();
		delta = t2-t1;
		System.out.println(sol);
		System.out.println("Answer generated in " + delta + " ms\n");

		System.out.println("Solution 2 - O(n^2)) runtime");
		t1 = System.currentTimeMillis();
		sol = backwardsBruteforce(3);
		t2  = System.currentTimeMillis();
		delta = t2-t1;
		System.out.println(sol);
		System.out.println("Answer generated in " + delta + " ms\n");

	}

	// The O(n^2) bruteforce solution
	private static long bruteforce(long digits) {
		long min, max, palin = 0, temp = 0;
		if (digits < 1) {
			return 0;
		} else if (digits == 1) {
			min = 1;
			max = 9;
		} else {
			min = (long) Math.pow(10, digits-1);
			max = (long) Math.pow(10, digits);
		}
		for (long i = min; i < max; i++) {
			for (long j = min; j < max; j++) {
				temp = i * j;
				if (isPalindromeMath(temp) && temp > palin) {
					palin = temp;
				}
			}
		}
		return palin;
	}

	// The O(n^2) backwards bruteforce solution
	private static long backwardsBruteforce(long digits) {
		long min, max, temp = 0, palin = 0;
		if (digits < 1) {
			return 0;
		} else if (digits == 1) {
			min = 1;
			max = 9;
		} else {
			min = (long) Math.pow(10, digits-1);
			max = (long) Math.pow(10, digits);
		}
		for (long i = max-1; i >= min; i--) {
			for (long j = max-1; j >= min; j--) {
				temp = i * j;
				if (isPalindromeMath(temp) && temp > palin) {
					palin = temp;
				} else if (temp < palin) {
					break;
				}
			}
		}
		return palin;
	}

	private static boolean isPalindromeMath(long number) {
		long reverse = 0;
		long digit = 0;
		while (number > 0) {
			digit = number % 10;
			reverse = reverse * 10 + digit;
			number = number / 10;
			if (number == reverse) {
				return true;
			}
		}
		return false;
	}

}














