package euler

import kotlin.math.ceil
import kotlin.math.sqrt

fun Int.cubed() = this * this * this

object KMathLib {

    /*
     * 'n' is a lab number if a prime divisor of n, say 'a', squared is also a divisor of n.
     * Example: 3 is a divisor of 18. 3^2 = 9 is also a divisor of 18
     */
    fun labNumber(n: Long): Boolean {
        TODO()
    }

    @JvmStatic
    fun triangleNumber(n: Int): Int{
        return n * (n + 1) / 2
    }

    fun squareNumber(n: Int): Int{
        return n * n
    }

    fun pentagonalNumber(n: Int): Int{
        return n * (3*n - 1) / 2
    }

    fun hexagonalNumber(n: Int): Int{
        return n * (2*n - 1)
    }

    fun heptagonalNumber(n: Int): Int{
        return n * (5*n - 3)/2
    }

    fun octagonalNumber(n: Int): Int{
        return n * (3*n - 2)
    }

    fun allPrimeFactors(n: Long, includeOne: Boolean = false): List<Long> {
        val factors = mutableListOf<Long>()
        if (includeOne) {
            factors.add(1)
        }

        tailrec fun go(i: Long, n: Long, factors: List<Long>): List<Long> {
            return when {
                i > Math.ceil(sqrt(n.toDouble())).toLong() -> factors + n
                n % i == 0L -> go(i, n / i, factors + i)
                else -> go(if(i == 2L) 3L else  i + 2, n, factors)
            }
        }

        return go(2, n, factors)
    }

    fun allPrimeFactors(n: Long, primes: List<Long>, includeOne: Boolean = false): List<Long> {
        val factors = mutableListOf<Long>()
        if (includeOne) {
            factors.add(1)
        }

        tailrec fun go(i: Long, n: Long, factors: List<Long>): List<Long> {
            return when {
                i > Math.ceil(sqrt(n.toDouble())).toLong() -> factors + n
                n % i == 0L -> go(i, n / i, factors + i)
                else -> go(if(i == 2L) 3L else  i + 2, n, factors)
            }
        }

        return go(2, n, factors)
    }


    /**
     * Alle faktorene (inkludert 1) som tall er delelig på, men ikke tallet selv.
     */
    fun properDivisors(tall: Long): Set<Long> {
        val factors = mutableListOf(1L)
        val max = ceil(sqrt(tall.toDouble()))  //scala.math.ceil(scala.math.sqrt(tall.toDouble))
        var i = 2L

        do {
            val rest: Long = tall % i
            if (rest == 0L) {
                val t: Long = (tall / i)
                factors.add(t) // =  t :: factors
                factors.add(i) // = i :: factors
            }
            i += 1
        } while (i <= max)
        return factors.sorted()
            .toSet()
    }

    /**
     * Alle primtallsfaktorer av n.
     * Inkluderer ikke 1. Inkluderer n hvis n er primtall.
     */
    fun primtallsfaktorerAvN(n: Long): Set<Long> {
        return properDivisors(n).minus(1).plus(n)
            .filter { isPrimeFast(it) }
            .toSet()
    }

    fun noCommonDivisor(a: Long, b: Long): Boolean {
        var n1 = a
        var n2 = b
        while (n1 != n2) {
            if (n1 > n2)
                n1 -= n2
            else
                n2 -= n1
        }
        return n1 == 1L
    }

    fun allPrimesInRange(primeMax: Int): List<Int> {
        return (2..primeMax)
            .filter { isPrimeFast(it.toLong()) }
    }

    fun allPrimesInLongRange(primeMax: Long): List<Long> {
        return (2L .. primeMax)
                .filter { isPrimeFast(it) }
    }

    fun isPrimeFast(tall: Long): Boolean {
        return (tall == 1L || tall == 2L || (!isDividable(tall) && tall > 1))
    }

    /**
     * Sjekker om et tall `n` er delbar på noen andre tall enn 1
     */
    fun isDividable(n: Long): Boolean {
        val max = ceil(sqrt(n.toDouble()))
        var i = 2L

        while (i <= max) {
            if (n % i == 0L) {
                return true
            }
            i += 1
        }
        return false
    }


    fun factorial(n: Int): Long {
        fun go(i: Int, product: Long): Long {
            return when {
                i >= n -> n * product
                else -> go(i + 1, i * product)
            }
        }
        return when (n) {
            0 -> 1
            1 -> 1
            else -> go(2, 1)
        }
    }
}
