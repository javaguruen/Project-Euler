package euler

import org.slf4j.LoggerFactory

class Euler069 {
    val divisors = mutableMapOf(1 to setOf(1L))
    val log = LoggerFactory.getLogger(Euler069::class.java)


    fun euler069(maximum: Int): Triple<Int, Int, Double> {
        var maxN = 0
        var phi = 0
        var maxNPhin = 0.0

        (maximum downTo (2)).forEach {
            if( it % 2 == 0) {
                val nPhi = totient(it)
                if (nPhi.second > maxNPhin) {
                    phi = nPhi.first
                    maxN = it
                    maxNPhin = nPhi.second
                }
            }
        }
        println("Max n/phi == $maxNPhin for n = $maxN")
        return Triple(maxN, phi, maxNPhin)
    }

    private fun getOrCalcultateDivisors(n: Int): Set<Long> {
        if (divisors.get(n) != null) {
            //println("cached for $n")
            return divisors.get(n)!!
        } else {
            val divs = KMathLib.properDivisors(n.toLong())
            divisors.put(n, divs)
            return divs
        }
    }

    fun totient(n: Int): Pair<Int, Double> {
        var nrOfrelativePrimes = 1
        val nFactors = getOrCalcultateDivisors(n)
        val relativePrimes = mutableListOf(1)
        (n - 1 downTo (2)).forEach {
            if (n % it != 0) {
                val itFactors = getOrCalcultateDivisors(it)
                if (nFactors.intersect(itFactors).size == 1) {
                    relativePrimes += it
                }
            }
        }
        nrOfrelativePrimes = relativePrimes.size
        log.info("n=$n, totient=$nrOfrelativePrimes, n/totient=${n / nrOfrelativePrimes.toDouble()}")
        return Pair(nrOfrelativePrimes, n.toDouble() / nrOfrelativePrimes)
    }

}