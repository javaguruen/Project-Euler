package euler

import euler.Euler066.isSquare
import junit.framework.TestCase
import kotlin.math.sqrt

class Euler066Test : TestCase() {
    fun testsquared() {
        val maks = sqrt(Int.MAX_VALUE.toDouble())

        for (x in 2 until maks.toInt()) {
            assertTrue( (x * x).isSquare())
        }
    }
}
