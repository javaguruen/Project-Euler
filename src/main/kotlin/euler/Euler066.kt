package euler

import java.math.BigInteger


object Euler066 {
    /*
    Consider quadratic Diophantine equations of the form:

    For example, when
    , the minimal solution in
     is
    .

    It can be assumed that there are no solutions in positive integers when
     is square.

    By finding minimal solutions in
     for
    , we obtain the following:


    Hence, by considering minimal solutions in
     for
    , the largest
     is obtained when
    .

    Find the value of
     in minimal solutions of
     for which the largest value of
     is obtained.
     */

    @JvmStatic
    fun main(args: Array<String>) {
        bigInteger()
    }

    fun bigInteger() {
        var stoerste: Pair<Long, Long> = Pair(0, 0)
        (2L..1000L).filterNot { it.isSquare() }
            .forEach { d ->
                for (x in 2L..Long.MAX_VALUE) {
                    assert(x * x > 0) { "Overflow for d: $d, x: $x" }
                    val bigXm1 = BigInteger("${x * x - 1}")
                    val bigD = BigInteger("$d")
                    if (bigXm1.mod(bigD) == BigInteger.ZERO) {
                        val yBigSq = bigXm1.div(bigD)
                        if (yBigSq.isSquare()) {
                            //if ( x * x - d * yBigSq.toLong() != 1L) throw RuntimeException("Feil løsning på ligning: $x, $d, $yBigSq")
                            println("x: $x, d: $d")
                            if (x > stoerste.first) {
                                stoerste = Pair(x, d)
                                println("-->$stoerste")
                            }
                            break
                        }
                    }
                    assert(x < Long.MAX_VALUE) { "x == Int.MAX_VALUE for d: $d" }
                }
            }
        println("--------\n$stoerste")

    }

    fun Long.isSquare(): Boolean {
        val sqrt = Math.sqrt(this.toDouble())
        return sqrt == sqrt.toInt().toDouble()
    }

    fun BigInteger.isSquare(): Boolean {
        val sqrt: Array<BigInteger> = this.sqrtAndRemainder()
        return sqrt.last() == BigInteger.ZERO
    }
}
