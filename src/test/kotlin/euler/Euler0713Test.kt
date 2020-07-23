package euler

import org.junit.Assert.*
import org.junit.Test

class Euler0713Test {
    val euler0713 = Euler0713()

    @Test
    fun `turan 3 2`() {
        assertEquals(3, euler0713.turan(3, 2))
        assertEquals(7, euler0713.turan(8, 4))
    }

    @Test
    fun `range test`() {
        assertEquals((1..3).toList(), listOf(1, 2, 3))
    }

    @Test
    fun `sum example`() {
        assertEquals(3281346, euler0713.sumTuran(1000))
    }

    @Test
    fun `sum 3 `() {
        assertEquals(3281346, euler0713.sumTuran(8))
    }

    @Test
    fun `all pairs`() {
        val seq = sequence {
            (1..7).forEach { i ->
                (i..8).forEach { j ->
                    if (i != j) yield(i to j)
                }
            }
        }
        val pairs = seq.take(1000).toList()
        println(pairs)
        val virkerIkke = listOf(1, 2, 3, 4)
        println("Antall par: ${pairs.size}")

        val workingPairs = pairs.filter { p ->  p.first >= 5 && p.second >= 5}
        println(workingPairs)
        println("Antall par som virker: ${workingPairs.size}")

    }
}