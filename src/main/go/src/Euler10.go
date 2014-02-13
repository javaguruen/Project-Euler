package main

import (
	"fmt"
	"mathlib"
)

func main() {
	primeSum := 0

	for i:=3;i<2000000;i+=2 {
		if (mathlib.IsPrime(i)) {
			primeSum = primeSum + i
		}
	}
	fmt.Printf("Sum of primes is %s",primeSum)
	fmt.Println("")
}

