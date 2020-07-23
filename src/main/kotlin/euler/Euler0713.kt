package euler

import org.slf4j.LoggerFactory
import kotlin.math.floor

class Euler0713 {
    val log = LoggerFactory.getLogger(Euler0713::class.java)

    fun turan(total: Int, working: Int): Int {
        if( total == working) {
            log.info("turan($total, $working) == 1")
            return 1
        }
        //T(n,k) = (-k/2)*floor(n/k)^2+(n-k/2+1)*floor(n/k)
        val answ =  (-working/2) * Math.pow(floor(total.toDouble()/working.toDouble()),2.0) + (total- (working/2) + 1)*floor(total.toDouble()/working) + 1
        log.info("turan($total, $working) == $answ")
        return answ.toInt()
        //return (total * (total - 1) / 2) / (total - working)
    }

    fun sumTuran(total: Int): Long {
        return (2..total)
                .fold(0L) { acc, i -> acc + turan(total, i) }
    }
}