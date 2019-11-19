package euler

import scala.collection.immutable.Range

class Combos {
    var solved: Map<Int, Int> = mutableMapOf(
            3 to 2,
            2 to 1,
            1 to 0
    )

    fun comb(target: Int): Int {
        println("comb(target: $target)")
        val cached = solved.get(target)
        if ( cached != null) {
            println("Cached: target: $target, solution:$cached")
            return cached
        }
        else {
            //(n-1) + 1, er en løsn
            var sums = 1
            (target-1 downTo 2).forEach{ n ->
                //sums += 1
                sums += comb(target-n)
            }
            println("solved target: $target, combos: $sums")
            solved + (target to sums)
            return sums
        }
    }
}

