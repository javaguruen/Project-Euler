package euler

class Euler0051 extends Slf4jLogger {
  val chars = List('0', '1', '2') //, '3', '4', '5', '6', '7', '8', '9')

  def replace(number: Int): List[Long] = {
    val strNumber = number.toString
    val list = for {
      i <- chars
      j <- 0 until strNumber.length - 2
      k <- j + 1 until strNumber.length - 1
      if strNumber.charAt(j) != i && strNumber.charAt(k) != i
    } yield strNumber.updated(j, i).updated(k, i).toLong
    list
      .filter(p => p.toString.length == 6)
      .filter(p => MathLib.isPrimeFast(p))
  }

  def run(): Int = {
    for( n <- 100003 until 1000000 by 10){
      if( MathLib.isPrimeFast(n)) {
        val ints = replace(n)
        logger.info(s"$n: ${ints.size}:  ${ints.sortWith(_ < _)}")
        if (ints.size == 8) {
          throw new RuntimeException(s"Found for n=$n")
        }
      }
    }

    0
  }

}