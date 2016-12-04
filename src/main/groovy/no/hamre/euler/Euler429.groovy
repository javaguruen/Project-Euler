package no.hamre.euler

class Euler429 {

    public static void main(String[] args) {
        def start = System.currentTimeMillis()

        def fact = new BigInteger("1")
        (1..1000000).each{ i ->
            fact = fact * i //new BigInteger( i as String)
            //println("i=$i, fact=$fact")
        }

        println "fact= $fact"

        println("tid: ${(System.currentTimeMillis() - start) / 1000.0} s.")
    }

/*
    static BigInteger fact(Integer a, BigInteger acc = 1) {
        if (a == 1) return acc
        fact(a - 1, a * acc)
    }
*/
}