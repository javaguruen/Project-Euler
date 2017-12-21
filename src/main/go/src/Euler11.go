package main

import (
	"fmt"
	"filelib"
	"strings"
	"strconv"
)

func main() {
	//load the matrix
	maxProduct := -1
	result, err := filelib.ReadLines("../../resources/euler11.txt")
	if (err != nil) {
		fmt.Println("Failed to load matrix.")
	} else {
		//convert slice of strings into something more convenient and xy addressable
		size := len(result)
		var matrix = convertMatrix(result)
		//traverse the matrix
		for i:=0;i<size;i++{
			for j:=0;j<size;j++{
				aProduct := largestProductFromPoint(i,j, matrix)
				if aProduct > maxProduct {
					maxProduct = aProduct
				}
			}
		}
		fmt.Printf("Max product is %v \n",maxProduct)
	}
}

func convertMatrix(strings []string) [][]int {
	size := len (strings) //Assume length is number of lines.
	var matrix = make ([][]int, size,size)
	for i:=0; i<size;i++ {
		matrix[i] = parseSingleLine(strings[i])
	}
	return matrix
}

func parseSingleLine(line string) []int {
	var parsedNumbers []int
	allNumbers := strings.Split(line, " ")
	for i:=0;i<len(allNumbers);i++ {
		tmp,err :=strconv.Atoi(allNumbers[i])
		if (err!=nil) {
			fmt.Println("Some error in number parsing",err)
		} else {
			parsedNumbers = append(parsedNumbers,tmp)
		}

	}
	return parsedNumbers
}

func largestProductFromPoint(x int, y int, matrix [][] int) int {
	size := len(matrix)
	var leftProduct int
	var downProduct int
	var diagonalProduct int
	var otherDiagonalProduct int

	//left
	if (x<(size-3)) {
		leftProduct = matrix[x][y] * matrix[x+1][y] * matrix[x+2][y] * matrix[x+3][y]
	}

	//down
	if (y<(size-3)) {
		downProduct = matrix[x][y] * matrix[x][y+1] * matrix[x][y+2] * matrix[x][y+3]
	}

	//diagonally UL to LR
	if (y<(size-3) && x<(size-3)) {
		diagonalProduct = matrix[x][y] * matrix[x+1][y+1] * matrix[x+2][y+2] * matrix[x+3][y+3]
	}

	//diagonally LR to UL
	if (x>2 && y<(size-3)) {
		otherDiagonalProduct = matrix[x][y] * matrix[x-1][y+1] * matrix[x-2][y+2] * matrix[x-3][y+3]
	}


	if (leftProduct > downProduct && leftProduct > diagonalProduct && leftProduct > otherDiagonalProduct) {
		return leftProduct
	}

	if (downProduct > leftProduct && downProduct > diagonalProduct && downProduct > otherDiagonalProduct) {
		return downProduct
	}
	if (diagonalProduct > otherDiagonalProduct) {
		return diagonalProduct
	}
	return otherDiagonalProduct
}

