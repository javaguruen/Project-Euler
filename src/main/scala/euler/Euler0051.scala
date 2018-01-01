package euler

class Euler0051 extends Slf4jLogger {
  val chars = List('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

  def replace(number: Int): List[Long] = {
    val strNumber = number.toString
    val list = for {
      i <- chars
      j <- 2 to 2
      k <- j + 1 to 3
/*
      j <- 0 until strNumber.length - 1;
      k <- j + 1 to strNumber.length - 1
*/
    } yield strNumber.updated(j, i).updated(k, i).toLong
    list
      .filter(p => p.toString.length == 5)
      .filter(p => MathLib.isPrimeFast(p))
  }

  def run(): Int = {
    val ints = replace(56003)
    println(ints)

    ints.size
  }

}