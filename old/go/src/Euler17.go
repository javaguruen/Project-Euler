package main

import (
	"fmt"
	"mathlib"
)

func main() {
	charsum :=0
	for i:= 1 ; i<1001; i++ {
		charsum += len(mathlib.IntToOutWrittenBritishNumber(i))
	}

	fmt.Printf("Number of characters in outwritten numbers 1-1000 (inc) is %v\n",charsum)

}

