package main

import (
	"fmt"
	"mathlib"
	//"time"
)

func main() {
	done := false
	factorCount := 0
	maxFactor := 0
	i := 1
	for !done {
		factors := mathlib.AllFactors(generateTriangleNumber(i))
		factorCount = len(factors)
		if factorCount > maxFactor {
			maxFactor = factorCount
		}
		if factorCount > 500 {
			done = true
		} else {
			if i%1000 == 0 {
				fmt.Println("F: ",i, len(factors), maxFactor)
			}
			i++
		}
	}

	fmt.Printf("The %v triangle number has > 500 factors and has a value of %v \n",i,generateTriangleNumber(i))
}

func generateTriangleNumber(base int) int {
	triangleNumber := 0
	for i:=1; i<=base;i++{
		triangleNumber += i
	}
	return triangleNumber
}

