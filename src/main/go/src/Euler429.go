package main

import "fmt"
import "math/big"

func main() {
	y := Faculty(100000)
    fmt.Println(y.String())
}

func Faculty(x int) * big.Int {
	facsum := big.NewInt(1)

	for i := 2; i <= x; i++ {		
		facsum = facsum.Mul(facsum, big.NewInt(int64(i)))
	}
	return facsum
}

