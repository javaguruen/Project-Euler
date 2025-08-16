package euler

object Euler243 {

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
        val maxNevner = 25_000_000
        val cache = primtallsfaktorer(maxNevner)

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
            if( produkt.toDouble() / (n-1).toDouble()  < 15499.0/94744.0 ){
                throw RuntimeException("Løsning: n=$n, produkt=$produkt")
            }
        }
    }

    fun Int.isEven(): Boolean {
        return this % 2 == 0
    }
}

