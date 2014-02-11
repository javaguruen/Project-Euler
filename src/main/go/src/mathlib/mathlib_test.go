package mathlib

import (
	"testing"
)

func TestIsPrime(t *testing.T) {
	aPrime := 6857
	aComposite := 10000

	if (!isPrime(aPrime)) {
		t.Errorf("isPrime claims 6857 is not prime")
	}

	if (isPrime(aComposite)) {
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


