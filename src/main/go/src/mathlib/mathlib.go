package mathlib

import (
	"math"
//	"strconv"
//		"fmt"
	"time"
	"fmt"
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

func IsPrime(number int) (bool) {
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
		if (IsPrime(someFactor)) {
			primeFactors = append(primeFactors, someFactor)
		}
	}
	return primeFactors
}

func IsPalindrome(number int) (bool) {
	//make a slice where each element is a signle digit
	var digits []int
	done := false

	for !done {
		digits = append(digits, number % 10)
		number = number / 10
		done = number < 10
	}
	digits = append(digits, number)

	//compare the front and back of the slice
	backwardcounter := len(digits) -1
	for forwardcounter := 0; forwardcounter < len(digits); forwardcounter++ {
		if (digits[forwardcounter] != digits[backwardcounter]) {
			return false
		}
		backwardcounter = backwardcounter - 1
	}
	return true
}

func IsDividableByUpToN(number int, n int) (bool){
	for i:= 1; i<n; i++ {
		if !(number % i == 0) {
			return false
		}
	}
	return true
}

func IsPytagoreanTriplet(a int, b int, c int) bool {
	aSquared := a * a
	bSquared := b * b
	cSquared := c * c

	return (aSquared + bSquared == cSquared)
}

func Sieve(size int) []int {
	base := time.Now()
	//create a slice of ints
	theSieve := make([]int,size)
	var thePrimes []int

	//fill the thing
	for i:=1; i< size;i++ {
		theSieve[i] = i
	}
	afterFill := time.Since(base)
	fmt.Printf("Array filled. Elapsed: %v \n",afterFill)
	//crossed out is -1
	for j:=2;j<size;j++{
		if (theSieve[j] != -1) {
			if !IsPrime(j) {
				crossOutFromHereonOut(theSieve,j,size)
			}
		}
	}
	afterCrosses := time.Since(base)
	fmt.Printf("Array crossed. Elapsed: %v \n",afterCrosses)
	//at the end, collect all the remainding numbers that now must be primes
	for k:= 3; k< size;k++ {
		if (theSieve[k] != -1) {
			thePrimes = append(thePrimes, theSieve[k])
		}
	}
	allDone := time.Since(base)
	fmt.Printf("Result collected. Elapsed: %v \n",allDone)
	return thePrimes
}

func crossOutFromHereonOut(sieve[] int, factor int, sievelength int) {
	for i:=factor; i<sievelength;i+=factor {
		if (sieve[i] != -1) {
			sieve[i]=-1
		}
	}
}

