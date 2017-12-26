package main

import (
	"fmt"
	"mathlib"
)

func main() {
	maxChainLength := -1
	maxChainIndex := -1

	for i:=0; i<1000000;i++ {
		clength := mathlib.CollatzChainLength(i)

		if clength > maxChainLength {
			maxChainIndex = i
			maxChainLength = clength
		}
		if (i%100000 == 0) {
			fmt.Printf("Initial value %v, max length thus far :%v \n",i,maxChainLength)
		}
	}

	fmt.Printf("Max chain length is %v at index %v\n",maxChainLength, maxChainIndex)

}

