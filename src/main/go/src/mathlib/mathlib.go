package mathlib

import (
	"math"
//	"fmt"
//	"strconv"
)

func SmallestFactor (number int) (int) {
	 sqrt := int( math.Sqrt( float64(number) ) )

	 for i := 2 ; i <= sqrt ; i++ {
		if ( math.Mod(float64(number), float64(i)) < 0.00001) {
			return i
	 	}
	 }
	return -1
}

func isPrime(number int) (bool) {
	sqrt := int( math.Sqrt( float64(number) ) )

	for i := 2 ; i <= sqrt ; i++ {
		if ( math.Mod(float64(number), float64(i)) < 0.00001) {
			return false
		}
	}
	return true
}

func AllFactors (number int) ([]int) {
	var factors []int

	sqrt := int( math.Sqrt( float64(number) ) )
//	fmt.Println("Factor: Input n is " + strconv.Itoa(number) + " sqrt of that, integered is " + strconv.Itoa(sqrt))

	for i := 2 ; i <= sqrt ; i++ {
		if ( math.Mod(float64(number), float64(i)) < 0.00001) {
			factors = append(factors, i)
		}
	}
	return factors
}

func AllPrimeFactors(number int) ([]int) {
	var primeFactors []int
	factors := AllFactors(number)
	for _,someFactor := range factors {
		if (isPrime(someFactor)) {
			primeFactors = append(primeFactors, someFactor)
		}
	}
	return primeFactors
}


