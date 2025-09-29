package euler

import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

class Euler0752 {
    class BeggeEr0Exception(val n: Int) : RuntimeException()

    @ExperimentalTime
    fun solveForX(x: Int): Int {
        val time = measureTimedValue {
            solver(x)
        }
        println("g($x) = ${time.value.first} for n=${time.value.second}, Time = ${time.duration}. ")
        return time.value.first
    }

    fun solver(x: Int): Pair<Int, Int> {
        var ex = Expr(x = x, n = 1)
        (2..(x * x)).forEach { n ->
            try {
                ex = ex.nextExpr()
            } catch (e: BeggeEr0Exception) {
                return 0 to n
            }
            if (ex.solved()) {
                //println("x=$x solved for n=$n")
                return n to n
            } else {
                //println("ingen løsning for x=$x for $ex")
            }
        }
        //println("Ingen løsning for x=$x")
        return 0 to (x*x)
    }


    data class Expr(val alpha: Long = 1, val beta: Long = 1, val x: Int, val n: Int) {
        init {
            if (alpha + beta == 0L) {
                throw BeggeEr0Exception(n)
                //println("alpha og beta er begge 0 for x=$x")
            }
        }

        fun nextExpr(): Expr {
            return Expr((alpha + 7 * beta) % x, (alpha + beta) % x, x, n + 1)
        }

        fun solved(): Boolean {
            return alpha % x == 1L && beta % x == 0L
        }
    }

}

