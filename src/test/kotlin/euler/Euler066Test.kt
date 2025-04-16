package euler

import euler.Euler066.isSquare
import junit.framework.TestCase
import java.math.BigInteger
import kotlin.math.sqrt

class Euler066Test : TestCase() {
    fun testsquared() {
        val maks = sqrt(Int.MAX_VALUE.toDouble())

        for (x in 2L until maks.toInt()) {
            assertTrue( (x * x).isSquare())
        }
    }

    fun testBigSquared() {
        val maks = Int.MAX_VALUE/Int.MAX_VALUE
        for (x in 2 until maks) {
            assertTrue( BigInteger("${x * x}").isSquare())
        }
    }
}
