package main

import "fmt"

func main() {
    sum := 0
    fib1 :=1
    fib2 :=2
    newfib := 0
    
    for fib2 < 4000000 {
        newfib = fib1 + fib2
        if (newfib % 2 == 0) {
        	sum = sum + newfib
        }
        fib1 = fib2
        fib2 = newfib
    }
    fmt.Println(sum)
}
