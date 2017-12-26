package main

import (
	"fmt"
	"mathlib"
)

func main() {
	fmt.Println("Euler 4")
	lowestPalindrome := -1
	//lowest 3 digit int : 100, highest: 999
	for i:=100; i< 999; i++ {
	    for j:=100; j< 999; j++ {
			tmp := i*j
			if (mathlib.IsPalindrome(tmp)) {
				if (tmp > lowestPalindrome) {
					lowestPalindrome = tmp
				}
			}
		}
	}
    fmt.Println(lowestPalindrome)
}
