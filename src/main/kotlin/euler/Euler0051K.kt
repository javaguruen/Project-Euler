package euler

import java.lang.Exception

class Euler0051K {

    fun primesBelow1M(): String {
        val primes = KMathLib.allPrimesInRange(1_000_000).map { it.toString() }
        (0..9).forEach { ind ->
            val canidates = primes.filter { p -> p.count { c -> c == ind.toString().first() } == 3 }
                .map { n -> n.replace(ind.toString().first(), '*') }
            //.also { println("candidate: $it") }
            canidates.forEach { cand ->
                val series = (0..9).map { replacement -> cand.replace('*', replacement.toString().first()) }
                    .filter { primes.contains(it) }
                    .count()
                //println("count: $series")
                if (series == 8) {
                    println(cand)
                    return cand
                }
            }
        }
        throw Exception("No solution")
    }
}
