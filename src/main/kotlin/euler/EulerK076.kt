package euler

import kotlin.math.round

class EulerK076 {

    var history: MutableMap<Int, Set<List<Int>>> = mutableMapOf()

    init {
        history.put(1, setOf(listOf(1)))
        history.put(2, setOf(listOf(1, 1)))
        history.put(3, setOf(listOf(2, 1), listOf(1, 1, 1)))
    }

    fun combos(n: Int): Int {
        for (i in 4..n) {
            history.put(i, findCombos(i))
        }
        println("------")
        history.get(n)!!.forEach { println(it) }
        return history.get(n)!!.size
    }

    private fun findCombos(n: Int): Set<List<Int>> {
        val lists = mutableSetOf(listOf(1, n - 1).sortedDescending())
        for (i in n - 1 downTo n / 2) {
            val v = n - i
//            println("Adding combos for n=$n v=$v + #$i")
//            println("lists == $lists")
            lists.add(listOf(v, n - v).sortedDescending())
            lists.addAll(
                    history.get(i)
                            ?.map { l -> l + v }!!
                            .map { it.sortedDescending() })
        }
        //println("n=$n, #${lists.size} combos")
        println("${lists.size}")
        return lists //lists.map { it.sortedDescending() }.toSet()
    }

    fun eivind(): Long {
        var sum = 0
        for (n in 2..100) {
            println("n=$n")
            val fak1 = 100 - round(100 / n + 0.5f) - (n - 1)
            (100 - round(100 / n + 0.5f) )
        }
        return 42
    }

    fun buildup(n: Int): Int {
        for( i in 1 .. 99){

        }



        return 42
    }

    private fun findRest(n: Int, i: Int, sum: Int){
            }
}