package euler

import org.junit.Assert.*
import org.junit.Test
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class Euler0752Test{
    val euler = Euler0752()

    @Test
    fun example() {
        assertEquals(12, euler.solveForX(5))
        assertEquals(0, euler.solveForX(3))
    }

    @Test
    fun `g100 example`() {
        val g100 = (3..100 step 2).map {x ->  euler.solveForX(x) }.sum()
        assertEquals(28891, g100)
    }

    @Test
    fun `g1000 example`() {
        val g1000 = (3..1_000 step 2).map {x ->  euler.solveForX(x) }.sum()
        assertEquals(13131583, g1000)
    }

    @Test
    fun `solution`() {
        val g1M = (3..1_000_000 step 2).map {x ->  euler.solveForX(x) }.sum()
        assertEquals(13131583, g1M)
    }
}
