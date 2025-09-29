package euler

import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Euler0059Test {
    @Test
    fun `read file`() {
        val content = Euler0059.readFileUsingGetResource()
        println(content)
    }

    @Test
    fun `xor generator`() {
        val generator = XorGenerator("ABC")
        val codes = listOf(generator.next(), generator.next(), generator.next(), generator.next())
        assertEquals(listOf(65, 66, 67, 65), codes)
    }

    @Test
    fun solution() {
        val pwd = "exp"
        val text = Euler0059(pwd).solve()
        println(text)
        val sum = text.map { it.code }.sum()
        println("Sum of codes for original text: $sum")

/*

        val sb = StringBuffer()
        ('a'..'z').forEach { a ->
            ('a'..'z').forEach { b ->
                ('a'..'z').forEach { c ->
                    val pw = String(listOf(a, b, c).toCharArray())
                    sb.append("pw: $pw : ${Euler0059(pw).solve()}\n")
                }
            }
        }
        File("/dev/Project-Euler/euler0059.txt").writeText(sb.toString())
        println("Done")
*/
    }

    @Test
    fun `map to char`() {
        assertEquals('A', Euler0059("abc").mapNumberToChar(65))
    }
}
