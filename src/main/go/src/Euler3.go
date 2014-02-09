package main

import (
	"fmt"
	"mathlib"
)

func main() {
	fmt.Println("Euler 3")

	factor := mathlib.AllPrimeFactors(600851475143)
    fmt.Println(factor)
}
