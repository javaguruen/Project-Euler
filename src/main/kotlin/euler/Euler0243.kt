package euler

class Euler0243 {
    data class SolutionException(val denominator: Int): Exception()

    fun solver(threshold: Fraction, upperLimit: Int = 20){
        (3..upperLimit).forEach { denominator ->
            println("Trying R(d=$denominator)")
            if (resilience(denominator.toLong()).realValue < threshold.realValue){
                throw SolutionException(denominator)
            }
        }
    }

    fun resilience(denominator: Long): Fraction {
        val denominatorDivisors = KMathLib.properDivisors(denominator).minus(1L).plus(denominator)
        return Fraction(
                    (2 until denominator).filterNot { d ->
                        val dDivisord = KMathLib.properDivisors(d).plus(d)
                        denominatorDivisors.any { n -> dDivisord.contains(n) }
                            //.also { println("$d is resilient ${!it}") }
                    }.count().toLong() + 1 ,
            denominator - 1
        )
    }
}


data class Fraction(val numerator: Long, val denominator: Long) {
    val realValue: Double
        get() = this.numerator.toDouble() / this.denominator.toDouble()
}
