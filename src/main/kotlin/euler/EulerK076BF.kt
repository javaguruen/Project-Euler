package euler

import java.io.File
import kotlin.math.round

class EulerK076 {
    val combinations = File("combinations.txt")
    val logToFile = true
    val logFunToFile = false

    fun run(value: Int): Int {
        combinations.writeText("")
        var c = 0
        for (n in (value - 1) downTo 1) {
            c += counter(n, value - n, value, n, "")
        }

        println("\nNumber of combinations for $value is $c")
        return c
    }

    private fun log(text: String){
        if( logToFile ){
            combinations.appendText("$text\n")
        }
    }

    private fun logfun(text: String){
        if( logFunToFile ){
            log("$text")
        }
    }

    private fun counter(
            first: Int,
            last: Int,
            target: Int,
            maxAllowed: Int,
            pattern: String): Int {
       logfun("counter($first, $last, t:$target, m:$maxAllowed, p:$pattern")
        var count = 0
        var rest = target - first - last

        if( last > first){
            return 0
        }
        if( maxAllowed == 1 ){
            //Kan bare fylle med en rekke 1-ere
            count += 1
            log("a: ${pattern}1*")
        } /*else if(last > maxAllowed ){
            //combinations.append("\n?? $last > $maxAllowed")
            for (s in maxAllowed downTo 1){
                count += counter(s, last-s, target-first, s, "n# $pattern$first - ")
            }
        } */else if (rest == 0 && last == 1) {
            count += 1
            log("b: $pattern$first - $last")
        } else if (rest == 0 && last > 1) {
            count += 1
            log("c: $pattern$first - $last")
            //for (s in last - 1 downTo 1) {
                //println("**-s = $s- $first $last $target $maxAllowed")
                count += counter(first, last-1, target, maxAllowed, "$pattern")
            //}
        } else if (rest == 1 || last == 1) {
            //fyll med 1-ere
            log("d: ${pattern}$first - $last - 1*")
            count += 1
            if (last > 1) {
                for( s in last -1 downTo 1) {
                    counter(first, s, target, maxAllowed, "$pattern")
                }
/*
                //for (s in last - 1 downTo 1){
                //}
*/
            }
        } else if (rest >= 1){
            //log("e: $first, $last, $maxAllowed, $target, $pattern")
            //for( s in last downTo 1) {
                count += counter(last, last, target - first, maxAllowed, "$pattern$first - ")
            //}
        } else if (last == 1){
            //Fyll med 1-ere uansett
            count += 1
            log("g: $pattern$first - $last - 1*")
        } else {
            log("h: Nothing for first: $first last: $last, target: $target")
            if( rest < 0){
                count += counter(first, last - 1, target, maxAllowed, pattern)
            }
        }


        return count

    }
}

fun main(args: Array<String>) {
    EulerK076().run(100)
}

class EulerK076BF {

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
        println("\n------")
        history.get(n)!!.forEach { println(it) }
        return history.get(n)!!.size
    }

    private fun findCombos(n: Int): Set<List<Int>> {
        val lists = mutableSetOf(listOf(1, n - 1).sortedDescending())
        for (i in n - 1 downTo n / 2) {
            val v = n - i
//            combinations.append("\nAdding combos for n=$n v=$v + #$i")
//            combinations.append("\nlists == $lists")
            lists.add(listOf(v, n - v).sortedDescending())
            lists.addAll(
                    history.get(i)
                            ?.map { l -> l + v }!!
                            .map { it.sortedDescending() })
        }
        //combinations.append("\nn=$n, #${lists.size} combos")
        println("\n${lists.size}")
        return lists //lists.map { it.sortedDescending() }.toSet()
    }

    fun eivind(): Long {
        var sum = 0
        for (n in 2..100) {
            println("\nn=$n")
            val fak1 = 100 - round(100 / n + 0.5f) - (n - 1)
            (100 - round(100 / n + 0.5f))
        }
        return 42
    }

    fun buildup(n: Int): Int {
        for (i in 1..99) {

        }



        return 42
    }

    private fun findRest(n: Int, i: Int, sum: Int) {
    }
}