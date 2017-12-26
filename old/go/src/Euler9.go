package main

import (
	"fmt"
	"mathlib"
)

func main() {

	for a:=1;a<1000;a++ {
		for b:=1;b<1000;b++{
			for c:=1;c<1000;c++{
				if (a+b+c == 1000) {
					if (mathlib.IsPytagoreanTriplet(a,b,c)) {
						fmt.Printf("Found the triplet: %s %s %s",a,b,c)
						fmt.Printf("Sum: %s",a*b*c)
						break
					}
				}
			}
		}
	}
}

