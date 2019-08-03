package euler

import org.junit.Ignore
import org.junit.Test
import kotlin.math.sqrt
import kotlin.test.assertEquals

internal class Euler069Test {
    val euler = Euler069()

    @Test
    fun `totient(3) == 2`(){
        assertEquals( 2, euler.totient(3).first, "tot(3)" )
        assertEquals( 2, euler.totient(4).first, "tot(4)")
        assertEquals( 4, euler.totient(5).first, "tot(5)" )
        assertEquals( 2, euler.totient(6).first, "tot(6)" )
        assertEquals( 6, euler.totient(7).first, "tot(7)" )
        assertEquals( 4, euler.totient(8).first, "tot(8)" )
        assertEquals( 6, euler.totient(9).first, "tot(9)" )
        assertEquals( 4, euler.totient(10).first, "tot(10)" )
    }

    @Test
    @Ignore("solution")
    //Løsningen er å finne det største produktet av primtall som er
    //mindre enn 1_000_000 == 510510
    fun testLargestProductOfPrimes() {
        val maxPrime = sqrt(1_000_000.0).toInt()
        val listOfPrimes = KMathLib.allPrimesInRange(maxPrime)
        println(listOfPrimes)
        var i =0
        var product = 1
        val primesBelow1M = mutableSetOf(1)
        while(product < 1_000_000){
            product *= listOfPrimes[i]
            if( product <= 1_000_000)
                primesBelow1M.add(listOfPrimes[i])
            i += 1
        }
        println(primesBelow1M)
        val n = primesBelow1M.fold(1, Int::times )
        println("product $n")

        val res = euler.totient(510510)
        println("res= $res")
        assertEquals(92160, res.first)
    }

    @Test
    fun eulerOf10() {
        val result = euler.euler069(10)
        assertEquals(6, result.first)
    }

}