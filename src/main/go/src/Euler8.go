package main

import (
	"fmt"
	"filelib"
	"strings"
	"strconv"
)

func main() {
	greatestSum := -1
	numberInLines, err := filelib.ReadLines("../../resources/Euler08.txt")

	if err != nil {
		fmt.Print("File Read failed")
	} else {
		singleLine := strings.Join(numberInLines,"")

		for i := 0;i<(len(singleLine)-5);i++ {
			subString := singleLine[i:(i+5)]
			if (calculateDigitSum(subString) > greatestSum) {
				greatestSum = calculateDigitSum(subString)
			}
		}

		fmt.Println("Greatest Digitsum is %s ",greatestSum)
	}
}

func calculateDigitSum(s string) int {
	sum := 1

	for _, c := range s {
		tmp, err := strconv.Atoi(string(c))
		if (err!=nil) {
			fmt.Print("Conversion failed")
		}
		sum = sum * tmp
	}
	return sum
}
