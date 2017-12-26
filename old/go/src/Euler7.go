package main

import (
	"fmt"
	"mathlib"
)

func main() {
	fmt.Println("Euler 7")
	primeCounter := 0
	i := 1

	for primeCounter <= 10001 {
		if (mathlib.IsPrime(i)) {
			primeCounter += 1
		}
		i += 1
	}

	fmt.Println(i-1)
}
