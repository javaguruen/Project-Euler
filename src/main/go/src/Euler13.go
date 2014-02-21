package main

import (
	"fmt"
	"filelib"
	"math/big"
)

func main() {
	result, err := filelib.ReadLines("../../resources/euler13.txt")
	count := 0

	if (err != nil) {
		fmt.Println("Failed to load big number")
	} else {
		sum := big.NewInt(0)
		numberFromFile := big.NewInt(0)

		for _, number := range result {
			if _, ok := numberFromFile.SetString(number, 10); ok {
				count = count + 1
				sum = sum.Add(sum, numberFromFile)
			} else {
				fmt.Printf("couldn't interpret line %#v\n", numberFromFile)
			}
		}
		fmt.Printf("Number is %v count is %v",sum.String(), count)
	}
}

