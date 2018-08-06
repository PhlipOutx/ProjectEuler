package main

import (
	"fmt"
	"os"
	"strconv"
)

func main() {
	if len(os.Args) != 2 {
		displayHelpText()
		os.Exit(0)
	}

	problemNumber, err := strconv.Atoi(os.Args[1])
	if err != nil {
		fmt.Println("The first argument must be an integer.")
		os.Exit(1)
	}

	executeProblem(problemNumber)
	os.Exit(0)
}

func displayHelpText() {
	fmt.Printf("\nProject Euler Problem Solutions\n")
	fmt.Printf("  - by Philip Miller\n\n")
	fmt.Printf("%% make run.go [Problem]\n\n")
	fmt.Printf("See source code for an explaination of the problem and answer.\n\n")
}

func executeProblem(problemNumber int) {
	switch problemNumber {
	case 1:
		p1 := &Euler0001{}
		p1.Solution()
	default:
		fmt.Printf("Problem %d is not yet implemented.\n", problemNumber)
	}
}
