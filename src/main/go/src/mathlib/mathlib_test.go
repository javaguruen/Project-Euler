package mathlib

import (
	"testing"
	"math/big"
	//"fmt"
)

func TestIsPrime(t *testing.T) {
	aPrime := 6857
	aComposite := 10000

	if (!IsPrime(aPrime)) {
		t.Errorf("isPrime claims 6857 is not prime")
	}

	if (IsPrime(aComposite)) {
		t.Errorf("isPrime claims 10000 is prime")
	}
}

func TestIsPalindrome (t *testing.T) {
	aPalindromeEvenDigits := 9229
	aPalindromeOddDigits := 2992992
	aNonPalindrome := 123

	if (!IsPalindrome(aPalindromeEvenDigits))  {
		t.Errorf("IsPalindrome claims %s is not a palindrome. ", aPalindromeEvenDigits)
	}

	if (!IsPalindrome(aPalindromeOddDigits)) {
		t.Errorf("IsPalindrome claims %s is not a palindrome. ", aPalindromeOddDigits)
	}

	if (IsPalindrome(aNonPalindrome)) {
		t.Errorf("IsPalindrome claims %s is a palindrome", aNonPalindrome)
	}
}

func TestIsDividableUpToN(t *testing.T) {
	aDividableNumber := 2520
	aBigDividableNumber := 232792560

	if (!IsDividableByUpToN(aDividableNumber, 10)) {
		t.Errorf("IsDividableNumber claims %s is NOT dividable by 1-10",aDividableNumber)
	}
	if (!IsDividableByUpToN(aBigDividableNumber, 20)) {
		t.Errorf("IsDividableNumber claims %s is NOT dividable by 1-20",aBigDividableNumber)
	}
	if (IsDividableByUpToN(20, 20)) {
		t.Errorf("IsDividableNumber claims %s is dividable by 1-20",20)
	}
}

func TestIsPytagoreanTriplet(t *testing.T) {
	aPytagoreanTriplet :=  []int{3,4,5}
	if (!IsPytagoreanTriplet(aPytagoreanTriplet[0],aPytagoreanTriplet[1],aPytagoreanTriplet[2])) {
    	t.Errorf("IsPytagorean claims pytagorean triplet 3,4,5 is not")
	}
}

func TestSieve(t *testing.T){
	primes := Sieve(100)
	if (len(primes) == 1) {
		t.Errorf("Error")
	}
}

func TestAllFactors(t *testing.T) {
	aTriangleNumber := GenerateTriangleNumber(12375)
	allFactorsForThat := AllFactors(aTriangleNumber)

	if (len(allFactorsForThat) != 576) {
		t.Errorf("Error: Allfactors says number of factors is %v while it should be 576",len(allFactorsForThat))
	}
}
func TestAllFactors2(t *testing.T) {
	aTriangleNumber := GenerateTriangleNumber(7)
	allFactorsForThat := AllFactors(aTriangleNumber)

	if (len(allFactorsForThat) != 6) {
		t.Errorf("Error: Allfactors says number of factors is %v while it should be 6",len(allFactorsForThat))
	}
}

func TestCollatzChainLength(t *testing.T) {

	if CollatzChainLength(13) != 10 {
		t.Errorf("Error: CollatzChainLength claims that CL(13) is not 10 terms long")
	}
}

func TestDigitSum(t *testing.T) {
	number := big.NewInt(32768)
	sum := DigitSum(number)
	if sum != 26 {
		t.Errorf("Error: DigitSum claims the digit sum of 32768 is not 26, but %v", sum)
	}
}

func TestGetLastDigit(t *testing.T) {
	someLastDigit := GetLastDigit(99)
	if someLastDigit != 9 {
		t.Errorf("Error: GetLastDigit claims last digit of 99 is %v,  not 9", someLastDigit)
	}
}

func TestCutLastDigit(t *testing.T) {
	numberAfterLastDigitCut := CutLastDigit(566)
	if numberAfterLastDigitCut != 56 {
		t.Errorf("Error: GetLastDigit claims 566 with last digit cut is  %v,  not 56", numberAfterLastDigitCut)
	}
}

func TestIntToOutWrittenBritishNumber(t * testing.T) {
	testLength := len (IntToOutWrittenBritishNumber(342))
	if testLength != 23 {
		t.Errorf("Outwritten number should be 23 chars long, but was %v. Entire number: %v", testLength, IntToOutWrittenBritishNumber(342))
	}
	testLength2 := len (IntToOutWrittenBritishNumber(115))
	if testLength2 != 20 {
		t.Errorf("Outwritten number should be 20 chars long, but was %v. Entire number: %v", testLength2, IntToOutWrittenBritishNumber(115))
	}
}

