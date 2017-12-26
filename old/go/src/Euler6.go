package main

import (
	"fmt"
	//"mathlib"
)

func main() {
	fmt.Println("Euler 6")
	squares := 0
	sum := 0

	for i := 1 ; i<=100; i++ {
		squares = squares + (i * i)
		sum = sum + i
	}

	sum = sum * sum

	diff := sum - squares


	fmt.Println(diff)
}
