package euler

class Euler0063 {

    fun solver(): Int {
        var antall = -1
        var sum = 0
        var n = 0
        var nullPaaRad = 0
        while ( n < 321){
            n += 1
            antall = numberOFNdigits(n)
            sum += antall
            if( antall == 0) nullPaaRad++
        }
        return sum
    }

    fun numberOFNdigits(n: Int): Int {
        println("Prøver for n=$n")
        return (1..9).map { a ->  exp(a, n)}
            .map { it.toString() }
            .filter { it.length == n }
            .count()
    }

    fun exp(a: Int, exp: Int): String {
        val result = Math.pow(a.toDouble(), exp.toDouble()).toBigDecimal()
        return result.toBigInteger().toString()
    }
}
