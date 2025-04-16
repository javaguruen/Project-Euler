package euler

object Euler068 {


    @JvmStatic
    fun main(args: Array<String>) {
        for (a in 1..9) {
            for (b in 1..9) {
                for (c in 1..9) {
                    for (d in 1..9) {
                        for (e in 1..9) {
                            for (f in 1..9) {
                                for (g in 1..9) {
                                    for (h in 1..9) {
                                        for (i in 1..9) {
                                            val sett = setOf(a, b, c, d, e, f, g, h, i)
                                            if (sett.size == 9) {
                                                if ( 10 + a + b == c + b + d
                                                    && c + b + d == e + d + f
                                                    && e + d + f == g + f + h
                                                    && g + f + h == i + h + a
                                                    //&& i + h + a == 55
                                                    )
                                                println("$a $b $c $d $e $f $g $h $i")
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}
