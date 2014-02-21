package main

import (
	"math/big"
	"fmt"
	"mathlib"
)

func main() {
	bigNumber := big.NewInt(1)
	bigBase := big.NewInt(2)
	bigExponent := big.NewInt(1000)

	bigNumber = bigNumber.Exp(bigBase, bigExponent, nil)

	fmt.Printf("The digit sum of 2**1000 is %v\n",mathlib.DigitSum(bigNumber))
}

