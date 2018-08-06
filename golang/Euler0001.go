package main

import (
	"fmt"
	"time"
)

type Euler0001 struct{}

func (e *Euler0001) Solution() {
	fmt.Println("\nProject Euler - Problem 1")
	fmt.Println("-------------------------")
	fmt.Printf("If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.\n\n")

	fmt.Println("Solution 1 - O(n) runtime")
	t1 := time.Now()
	sol := e.bruteforce(1000)
	delta := time.Since(t1)
	fmt.Println(sol)
	fmt.Printf("Answer generated in %s\n\n", delta)

	fmt.Println("Solution 2 - O(1) runtime")
	t1 = time.Now()
	sol = e.arithmeticProgression(1000)
	delta = time.Since(t1)
	fmt.Println(sol)
	fmt.Printf("Answer generated in %s\n\n", delta)

	fmt.Printf("Its hard to see the runtime difference with such a small number of calculations. Here it is again when we find the sum of all multiples of 3 or 5 below 200,000,000\n\n")

	fmt.Println("Solution 1 - O(n) runtime")
	t1 = time.Now()
	sol = e.bruteforce(200000000)
	delta = time.Since(t1)
	fmt.Println(sol)
	fmt.Printf("Answer generated in %s\n\n", delta)

	fmt.Println("Solution 2 - O(1) runtime")
	t1 = time.Now()
	sol = e.arithmeticProgression(200000000)
	delta = time.Since(t1)
	fmt.Println(sol)
	fmt.Printf("Answer generated in %s\n\n", delta)
}

// The O(n) solution
func (e *Euler0001) bruteforce(sumBelow int) int {
	sum := 0
	for i := 0; i < sumBelow; i++ {
		if i%3 == 0 || i%5 == 0 {
			sum += i
		}
	}
	return sum
}

// The O(1) solution
func (e *Euler0001) arithmeticProgression(sumBelow int) int {
	return e.sumAllDivisble(3, sumBelow-1) + e.sumAllDivisble(5, sumBelow-1) - e.sumAllDivisble(15, sumBelow-1)
}

// 1+2+3+...+N = (N*(N+1))/2
func (e *Euler0001) sumAllDivisble(m, n int) int {
	return m * (((n / m) * ((n / m) + 1)) / 2)
}
