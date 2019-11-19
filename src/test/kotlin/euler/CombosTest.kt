package euler

import org.junit.Assert.*
import org.junit.Test

class CombosTest{
    val combos = Combos()

    @Test
    fun Combos_3() {
        assertEquals(1, combos.comb(2))
        assertEquals(2, combos.comb(3))
        assertEquals(4, combos.comb(4))
        assertEquals(6, combos.comb(5)) //4+1, 3+2. 3+1+1, 2+2+1, 2+1+1+1, 1+1+1+1+1
     }
}