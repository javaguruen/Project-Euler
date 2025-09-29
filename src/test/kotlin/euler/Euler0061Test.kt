package euler

import org.junit.Assert.*
import org.junit.Test

class Euler0061Test {
    @Test
    fun solver() {
        Euler0061().start()
    }


    @Test
    fun permutations() {
        val list = listOf("T", "S", "P")
        println(Euler0061().generatePermutations(list))
    }

    @Test
    fun name() {
        println("tri: ${TriangleNumber().numbers}")
        println("squ: ${SquareNumber().numbers}")
        println("pen: ${PentagonalNumber().numbers}")
    }

    @Test
    fun triangles() {
        val triangleNumbers = TriangleNumber()
        val first = triangleNumbers.numbers.first()
        println("first: $first")
        val candidates = triangleNumbers.startsWith(first.value.lastTwo())
        println("Candidates: $candidates")
    }

    @Test
    fun `first and last`() {
        assertEquals("12", "1234".firstTwo())
        assertEquals("34", "1234".lastTwo())
    }
}
