package Euler0753

import euler.KMathLib
import euler.cubed

class Euler0753 {
    companion object {
        data class ABModP(val a: Int, val b: Int, val abModP: Int)
    }

    fun cCubesModP(p: Int): Set<Int> {
        val cModPs = (1 until p)
                .map { it.cubed() }
                .map { it % p }
                .toSet()
        return cModPs
    }

    fun fermatCongruence(maxP: Int): Int {
        val primes = KMathLib.allPrimesInRange(maxP)

        val antall = primes.map { p ->
            val cModPs = cCubesModP(p)
            val ls = sequence {
                (1 until p).forEach { a ->
                    (1 until p).forEach { b ->
                        yield(ABModP(a, b, (a.cubed() + b.cubed()) % p))
                    }
                }
            }.toList()
                    .filter { abs -> cModPs.contains(abs.abModP) }
            println("p($p) = ${ls.size}")
            ls.size
        }.sum()
        println("fermat == $antall")
        return antall
    }
}
