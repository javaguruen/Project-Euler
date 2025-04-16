package euler

import kotlin.math.ceil
import kotlin.math.sqrt

object KMathLib {
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

}
