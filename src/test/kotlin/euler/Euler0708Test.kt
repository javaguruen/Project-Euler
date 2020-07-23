package euler

import org.junit.Assert.*
import org.junit.Test
import java.lang.Math.pow

class Euler0708Test{
    val euler = Euler0708()

    @Test
    fun `f of 90`() {
        assertEquals(16, euler.f(90))
    }

    @Test
    fun `example sum of 10^8`() {
        assertEquals(9613563919, euler.sum(pow(10.toDouble(), 8.toDouble()).toLong()))
    }
}