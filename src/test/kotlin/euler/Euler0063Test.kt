package euler

import org.junit.Assert.*
import org.junit.Test

class Euler0063Test{
    val euler = Euler0063()

    @Test
    fun solution() {
        val antall = euler.solver()
        println("Antalll = $antall")
        assertEquals(49, antall)
    }


    @Test
    fun `stoerste n`() {
        var n = 0
        var ferdig = false
        while( !ferdig){
            n += 1
            val prod = euler.exp(2, n)
            val prodLength = prod.length
            println("2^$n = $prod, lengde=$prodLength")
            ferdig = prodLength > n
        }
        println("Max n er $n")
    }

    @Test
    fun `antall for n 1`() {
        val antall = euler.numberOFNdigits(1)
        assertEquals(9, antall)
    }

    @Test
    fun `exp function`() {
        assertEquals("8", euler.exp(2, 3))
    }
}
