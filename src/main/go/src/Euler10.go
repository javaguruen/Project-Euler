package main

import (
	"fmt"
	"mathlib"
	"time"
)

func main() {
	Euler10NaiveVersion()
	Euler10UsingSieve()
}

func Euler10NaiveVersion() {
	primeSum := 0
	before := time.Now()
	for i:=3;i<2000000;i+=2 {
		if (mathlib.IsPrime(i)) {
			primeSum = primeSum + i
		}
	}
	elapsed := time.Since(before)
	fmt.Printf("Sum of primes is %d. Elapsed: %v",primeSum, elapsed)
	fmt.Println("")
}

func Euler10UsingSieve() {
	primeSum := 0
	before := time.Now()
	primes := mathlib.Sieve(2000000)
	for _,element := range primes {
		primeSum += element
	}
	elapsed := time.Since(before)
	fmt.Printf("Sum of primes is %d. Elapsed: %v",primeSum, elapsed)
	fmt.Println("")
}

