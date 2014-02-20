package mathlib

import (
	"testing"
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


