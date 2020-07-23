package euler

class Euler0708 {
    fun f(n: Long): Long {
        if (n == 1L) {
            return 1
        }
        val primeFactors = KMathLib.allPrimeFactors(n)
        val factors = primeFactors.size
        //println(primeFactors)
        return (Math.pow(2.0, factors.toDouble())).toLong()
    }

    fun sum(n: Long): Long {
        return (1L..n).fold(0L) { acc, elem -> acc + f(elem) }
    }
}