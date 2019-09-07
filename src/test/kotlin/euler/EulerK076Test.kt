package euler

import org.junit.Ignore
import org.junit.Test

class EulerK076Test {
    val euler076 = EulerK076BF()

    @Test
    fun `Combos of 4`(){
        val combos = euler076.combos(4)
        println(combos)
        assert(combos == 4)
    }

    @Test
    fun `Combos of 5`(){
        val combos = euler076.combos(5)
        println(combos)
        assert(combos == 6)
    }

    @Test
    fun `Combos of 6`(){
        val combos = euler076.combos(6)
        println(combos)
        assert(combos == 10)
    }

    @Test
    fun `Combos of 7`(){
        val combos = euler076.combos(7)
        println(combos)
        assert(combos == 14)
    }

    @Test
    fun `Combos of 8`(){
        val combos = euler076.combos(8)
        println(combos)
        assert(combos == 21)
    }

    @Test
    fun `Combos of 9`(){
        val combos = euler076.combos(9)
        println(combos)
        assert(combos == 29)
    }

    @Test
    fun `Eivinds Combos of 100`(){
        val combos = euler076.eivind()
        println(combos)
        assert(combos == 100L)
    }

    @Test
    @Ignore("Solution")
    fun `Combos of 100`(){
        val combos = euler076.combos(100)
        println(combos)
        assert(combos == 28)
    }

}
