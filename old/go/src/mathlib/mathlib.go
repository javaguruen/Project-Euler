package mathlib

import (
	"math"
	"strconv"
//	"time"
	"fmt"
	"math/big"
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

	sqrt := int(math.Ceil(math.Sqrt(float64(number))))

	factors = append(factors, 1) //Per def 1 is a prime factor of whatever number.

	for i := 2 ; i <= sqrt ; i++ {
		if ( math.Mod(float64(number), float64(i)) < 0.00001) {
			factors = append(factors, i)
			factors = append(factors, (number/i))
		}
	}
	factors = append(factors, number) //Per def number is a prime factor of  number.
	//TODO: Remove duplicates

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

func GenerateTriangleNumber(base int) int {
	triangleNumber := 0
	for i:=1; i<=base;i++{
		triangleNumber += i
	}
	return triangleNumber
}

func Sieve(size int) []int {
	//base := time.Now()
	//create a slice of ints
	theSieve := make([]int,size)
	var thePrimes []int

	//fill the thing
	for i:=1; i< size;i++ {
		theSieve[i] = i
	}
	//afterFill := time.Since(base)
	//crossed out is -1
	for j:=2;j<size;j++{
		if (theSieve[j] != -1) {
			if !IsPrime(j) {
				crossOutFromHereonOut(theSieve,j,size)
			}
		}
	}
	//afterCrosses := time.Since(base)
	//at the end, collect all the remainding numbers that now must be primes
	for k:= 3; k< size;k++ {
		if (theSieve[k] != -1) {
			thePrimes = append(thePrimes, theSieve[k])
		}
	}
	//allDone := time.Since(base)
	return thePrimes
}

func crossOutFromHereonOut(sieve[] int, factor int, sievelength int) {
	for i:=factor; i<sievelength;i+=factor {
		if (sieve[i] != -1) {
			sieve[i]=-1
		}
	}
}

func CollatzChainLength(initialValue int) int {
	if (initialValue == 0) {
		return 0
	}
	done := false
	count := 1 //Initial value is the first chain link
	currentValue := initialValue
	for !done {
		if (currentValue %2 == 0) {
			currentValue = currentValue / 2
			if (currentValue != 1) {
				count ++
			} else {
				done = true
			}
		} else {
			currentValue = (currentValue * 3) + 1
			if (currentValue != 1) {
				count ++
			} else {
				done = true
			}
		}
	}
	count ++ //The ending 1 also counts as a chain link
	return count
}

func DigitSum(number *big.Int) int {
	sum := 0

	for _,someChar := range number.String() {
		digitAsString := string(someChar)
		x,err := strconv.Atoi(digitAsString)

		if err != nil {
			fmt.Printf("Failed to convert string %v to int\n",err)
		} else {
			sum = sum + x
		}
	}
	return sum
}

func IntToOutWrittenBritishNumber(number int) string {
	someDigit := GetLastDigit(number)
	number = CutLastDigit(number)
	var allDigits []int
	allDigits = append(allDigits,someDigit)

	for number > 0 {
		someDigit = GetLastDigit(number)
		number = CutLastDigit(number)
		allDigits = append(allDigits,someDigit)
	}

	if len(allDigits) == 1 {
		return Ones(allDigits[0])
	}

	if len(allDigits) == 2 {
		return Tens(allDigits[0] + allDigits[1]*10)
	}

	if len(allDigits) == 3 {
		return Hundreds(allDigits[2], allDigits[1], allDigits[0])
	}

	if len(allDigits) == 4 {
		return Thousands(allDigits[3], allDigits[2], allDigits[1], allDigits[0])
	}
	return "error"
}

func Thousands(thousandDigit int, hundredDigit int, tendigit int, singledigit int) string {
	return (Ones(thousandDigit) + "thousand" + Hundreds(hundredDigit, tendigit, singledigit))
}

func Hundreds(hundredDigit int, tendigit int, singledigit int) string {
	hundredPart := ""

	if (hundredDigit > 0) {
		hundredPart = "hundred"
		if (tendigit > 0 || singledigit > 0) {
			hundredPart += "and"
		}
	}

	if tendigit > 0 {
		return Ones(hundredDigit) + hundredPart + Tens(tendigit * 10 + singledigit)
	} else {
		return Ones(hundredDigit) + hundredPart + Ones(singledigit)
	}
}

func Tens(number int) string {
	ret := ""
	lastDigit := GetLastDigit(number)
	firstDigit := GetLastDigit(CutLastDigit(number)) //Assume only 2 digits

	if number > 9 && number< 20 {
	    switch lastDigit {
		case 0 :	ret = "Ten"
		case 1 :	ret = "Eleven"
		case 2 :	ret = "Twelve"
		case 3 : 	ret = "Thirteen"
		case 4 :	ret = "Fourteen"
		case 5 :	ret = "Fifteen"
		case 6 :	ret = "Sixteen"
		case 7 :	ret = "Seventeen"
		case 8 :	ret = "Eighteen"
		case 9 :	ret = "Nineteen"
		}
	}

	if number >= 20 {
		switch firstDigit {
			case 2 : 	ret = "Twenty"
			case 3 :	ret = "Thirty"
			case 4 :	ret = "Forty"
			case 5 :	ret = "Fifty"
			case 6 :	ret = "Sixty"
			case 7 :	ret = "Seventy"
			case 8 :	ret = "Eighty"
			case 9 :	ret = "Ninety"
		}

		ret = ret + Ones(lastDigit)

	}

	return ret
}

func Ones(number int) string {
	ret :=""
	switch number {
		case 1 :	ret = "One"
		case 2 :	ret = "Two"
		case 3 : 	ret = "Three"
		case 4 :	ret = "Four"
		case 5 :	ret = "Five"
		case 6 :	ret = "Six"
		case 7 :	ret = "Seven"
		case 8 :	ret = "Eight"
		case 9 :	ret = "Nine"
	}
	return ret
}

func GetLastDigit(number int) int {
	if number < 10 {
		return number
	}
	divBy10 := number / 10
	numberSansLastDigitValue := divBy10 * 10
	return number - numberSansLastDigitValue
}

func CutLastDigit(number int) int {
	return number / 10
}


