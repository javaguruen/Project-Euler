package euler

import collection.mutable.HashSet

object Euler30 {
  def main(args: Array[String]): Unit = {
    val hw = new Euler30()
    hw.run
  }
}

class Euler30 {


  def run(): Long = {
    var sum = 0.0

    for (a <- 2 to 1000000) {
      val aS = a.toString
      val result = aS.foldLeft( 0.0 )((s, c) => s + scala.math.pow(c.toInt - '0'.toInt, 5))
      if( a == result ) {
        println("* * * * * * ")
        println(a + " = " + result)
        sum = sum + result
      }
    }
    println ("Sum = " + sum)
    0
  }


}