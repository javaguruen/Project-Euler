package euler

import org.junit.Assert.*
import org.junit.Test

class Euler0051KTest {
    @Test
    fun solver() {
        val euler = Euler0051K()
        val pattern = euler.primesBelow1M()
        (0..9).map { pattern.replace('*', it.toString().first()) }
            .filter { KMathLib.isPrimeFast(it.toLong()) }
            .also { println(it) }

    }

    @Test
    fun `count chars`() {
        println("1.toChar() == ${1.toString().first()}")
        val countOnes = "12341".count { c -> c == 1.toChar() }
        assertEquals(2, countOnes)

    }
}
