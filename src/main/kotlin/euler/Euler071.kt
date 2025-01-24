package euler

import java.math.BigInteger

object Euler071 {
    data class Broek(val t: Int, val n: Int) {
        fun toDouble() = t.toDouble() / n.toDouble()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val _3by7 = 3.0 / 7.0

        var stoerste: Pair<Broek, Double> = Pair(Broek(0, 0), 0.0)

        for (d in 2..1_000_000) {
            val bigD = BigInteger("$d")
            val upperN = 3 * d / 7

            for (n in upperN downTo 1) {
                val bigN = BigInteger("$n")

                val dec = n.toDouble() / d.toDouble()

                if(dec < stoerste.second) {
                    break
                }

                if (bigN.gcd(bigD) == BigInteger.ONE) {
                    //println("GCD for $n and $d is 1")
                    if (dec > stoerste.second && dec < _3by7) {
                        println("GCD for $n and $d is 1")
                        stoerste = Pair(Broek(n, d), dec)
                        break
                    }
                }
            }
        }
        println(stoerste)
    }
}
