package euler

import org.junit.Assert.*
import org.junit.Test

class KMathLibTest{
    @org.junit.Test
    internal fun factorial() {
        assertEquals(1, KMathLib.factorial(0))
        assertEquals(1, KMathLib.factorial(1))
        assertEquals(24, KMathLib.factorial(4))
    }

    @Test
    fun `prime factors`() {
        assertEquals( listOf(2L, 3L, 3L, 5L), KMathLib.allPrimeFactors(90))
        assertEquals( listOf(7L), KMathLib.allPrimeFactors(7))
        assertEquals( listOf(1L, 7L), KMathLib.allPrimeFactors(7, includeOne = true))
    }
}