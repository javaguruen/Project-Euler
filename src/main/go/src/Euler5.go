package main

import (
	"fmt"
	"mathlib"
)

func main() {
	fmt.Println("Euler 5")

	result := 0
	iterations := 0
	done := false
	i := 20

	for !done {
		if (mathlib.IsDividableByUpToN(i, 20)) {
			done = true
			result = i
		}
		i += 20
		iterations += 1
	}
	fmt.Println(result)
}
