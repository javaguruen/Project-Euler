package euler

import org.junit.Assert.*
import org.junit.Test

class Euler0243Test{
    private val euler = Euler0243()

    @Test
    fun solution() {
        try {
            euler.solver(Fraction(15499L, 94744L), 1_000_000)
            fail("Should throw SolutionException")
        }catch (e: Euler0243.SolutionException){
            assertEquals(12, e.denominator)
        }
    }

    @Test
    fun solutionForExample() {
        try {
            euler.solver(Fraction(4L, 10L))
            fail("Should throw SolutionException")
        }catch (e: Euler0243.SolutionException){
            assertEquals(12, e.denominator)
        }
    }

    @Test
    fun `proper divisors`() {
        val divisors = KMathLib.properDivisors(12).minus(1)
        val expected = setOf(2L, 3L, 4L, 6L)
        assertEquals(expected.size, divisors.size)
        val union = divisors.union(expected)
        assertEquals(expected.size, union.size)
    }

    @Test
    fun `resilience d 12`() {
        val expected = Fraction(4L, 11L)
        val actual = euler.resilience(12)
        assertEquals(expected, actual)
    }

    @Test
    fun `resilience d 4`() {
        val expected = Fraction(2L, 3L)
        val actual = euler.resilience(4)
        assertEquals(expected, actual)
    }
}
