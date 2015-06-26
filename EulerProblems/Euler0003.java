/*
*    Project Euler problem solutions
*     - Philip Miller
*    
*    Solution to problem 3
*/

package EulerProblems;

public final class Euler0003 {

	public static void solution() {
		long t1, t2, delta, sol;

		System.out.println("\nProject Euler - Problem 3");
		System.out.println("-------------------------");
		System.out.println("The prime factors of 13195 are 5, 7, 13 and 29.\n");
		System.out.println("What is the largest prime factor of the number 600851475143 ?\n");

		
		System.out.println("Solution 1 - O(n^2) runtime");
		System.out.println("This bruteforce method is not even worth attempting because it will take so long.\n");

		System.out.println("Solution 2 - O(sqrt(n) * sqrt(n)) runtime");
		t1 = System.currentTimeMillis();
		sol = sqrtbruteforce(600851475143L);
		t2  = System.currentTimeMillis();
		delta = t2-t1;
		System.out.println(sol);
		System.out.println("Answer generated in " + delta + " ms\n");

		System.out.println("Solution 3 - O(sqrt(n)) runtime");
		t1 = System.currentTimeMillis();
		sol = arithmeticSolution(600851475143L);
		t2  = System.currentTimeMillis();
		delta = t2-t1;
		System.out.println(sol);
		System.out.println("Answer generated in " + delta + " ms\n");

	}

	// The O(n^2) bruteforce solution
	private static long bruteforce(long num) {
		long maxFactor = 0;
		boolean isPrime;
		for (long i = 2; i < num; i++) {		// loop over all numbers to num
			if (num % i == 0) {					// is i a divisor of num
				isPrime = true;
				for (long j = 2; j < i; j++) {	// loop over all numbers to i
					if (i % j == 0) {			// does i have a divisor
						isPrime = false;		// if so then its not a prime
						break;
					}
				}
				if (isPrime) {
					maxFactor = i;
				}
			}
		}
		return maxFactor;
	}

	// The O(sqrt(n) * sqrt(n)) solution
	private static long sqrtbruteforce(long num) {
		long maxFactor = 0;
		long sqrtNum = (long) Math.floor(Math.sqrt(num));
		for (long i = 2; i <= sqrtNum; i++) {		// loop over all numbers to sqrtNum
			if (num % i == 0) {						// is i a divisor of num
				if (isPrime(i) && i > maxFactor) {
					maxFactor = i;
				}
				if (isPrime(num/i) && (num/i) > maxFactor) {
					maxFactor = (num/i);
				}
			}
		}
		return maxFactor;
	}

	// The O(sqrt(n)) solution using prime factorization
	//
	// Fundamental Theorem of Arithmetic
	// Any integer greater than 1 is either a prime number, or can be written as a unique product of prime numbers
	private static long arithmeticSolution(long num) {
		long maxFactor = 0;
		long i = 2;
		while (i*i <= num) {		// only need to check to sqrt(num)
			if (num % i == 0) {		// is i a divisor of num
				num = num / i;		// 
				maxFactor = i;
			} else {
				i++;
			}
		}
		if (num > maxFactor) {		// last unfactored number is a prime factor of num
			maxFactor = num;
		}
		return maxFactor;
	}

	// O(sqrt(n)) isPrime function
	private static boolean isPrime(long num) {
		if (num < 2) {
			return false;
		}
		boolean isPrime = true;
		long sqrtNum = (long) Math.floor(Math.sqrt(num));
		for (long i = 2; i <= sqrtNum; i++) {	// loop over all numbers to sqrtNum
			if (num % i == 0) {					// is it a divisor of num
				isPrime = false;				// if so then its not a prime
				break;
			}
		}
		return isPrime;
	}

}














