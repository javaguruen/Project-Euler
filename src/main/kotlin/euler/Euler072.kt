package euler

object Euler072 {

    fun divisors(maksInklusive: Int): MutableMap<Int, Set<Long>> {

        val cache: MutableMap<Int, Set<Long>> = mutableMapOf(2 to setOf())

        for (i in 3..maksInklusive step 2) {
            //println("i: $i")
            val divs = KMathLib.primtallsfaktorerAvN(i.toLong()).minus(1)
            cache[i] = if( divs.isEmpty()) setOf(i.toLong()) else divs
            cache[i + 1] = cache[(i + 1) / 2]!!.plus(2L).minus(1)
        }
        return cache
    }

    fun primtallsfaktorer(maksInklusive: Int): MutableMap<Int, Set<Long>> {
        val cache: MutableMap<Int, Set<Long>> = mutableMapOf(2 to setOf(2))

        for (i in 3..maksInklusive step 2) {
            //println("i: $i")
            val divs = KMathLib.primtallsfaktorerAvN(i.toLong())
            cache[i] = divs
            cache[i + 1] = cache[(i + 1) / 2]!!.plus(2L)
        }
        return cache
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val maxNevner = 1_000_000
        val cache = primtallsfaktorer(maxNevner)

        var sum = 1L
        for (n in 3..maxNevner) {
            var produkt = n.toLong()
            for (p in cache[n]!!) {
                val newProdukt = produkt / p * (p - 1)
                if (newProdukt == 0L){
                    println("n: $n, produkt: $produkt, newProdukt: $newProdukt, p: $p, cache: ${cache[n]}")
                    throw RuntimeException("P == 0")
                }
                produkt = newProdukt
            }
            sum += produkt
            if( n <= 21)
                println("nevner: $n, antall: $sum")
            if( sum < 0){
                throw RuntimeException("Overflow for n: $n, sum: $sum")
            }
        }
        println("Antall brøker: $sum")
    }

    fun Int.isEven(): Boolean {
        return this % 2 == 0
    }

    /*
            for( nevner in 3 .. maxNevner) {
            if( nevner >= 10000 && nevner % 10000 == 0)
                println("nevner: $nevner, antall: $antallBroeker")
            for (teller in 2 until nevner) {
                if( teller.isEven() && nevner.isEven())
                    continue
                val snitt = cache[teller]!!.intersect(cache[nevner]!!)
                //println("teller: $teller, nevner: $nevner, snitt: $snitt")
                if (snitt.size == 0){
                    //println("$teller/$nevner")
                    antallBroeker++
                }

                /*
                if (gcd(teller, nevner) == 1) {
                    antallBroeker++
                }

                 */
            }
        }

     */
}

