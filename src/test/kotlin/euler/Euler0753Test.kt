package euler

import Euler0753.Euler0753
import org.junit.Assert.*
import org.junit.Test
import java.lang.Thread.yield

internal class Euler0753Test{
    val euler = Euler0753()

    @Test
    fun `cube function`() {
        assertEquals(27, 3.cubed())
    }

    @Test
    fun examples() {
        assertEquals(12, euler.fermatCongruence(5))
        assertEquals(0, euler.fermatCongruence(7))
    }

    @Test
    fun solution() {
        val result = euler.fermatCongruence(6_000_000)
        println("Result == $result")
    }

    @Test
    fun `primes below`() {
        val primes = KMathLib.allPrimesInRange(6_000_000)
        println(primes)
    }
}
