package euler

import org.junit.Test

class Euler072Test {
    @Test
    fun `divisors for n 189`() {
        KMathLib.primtallsfaktorerAvN(189).forEach {
            println(it)
        }
    }
}
