package euler

import collection.mutable.HashSet

object Euler29{
  def main(args: Array[String]) : Unit = {
    val hw = new Euler29()
    hw.run
  }
}
class Euler29 {


  def run(): Long = {
    var a = 2
    var b = 2
    val theSet = new HashSet[String]

    for (a <- 2 to 100) {
      for (b <- 2 to 100) {
        val result = scala.math.pow(a,b)
        println( a+" exp " + b +" = "+result)
        theSet.add(result.toString)
      }
    }
    println (theSet)
    println( "Antall : " + theSet.size)
        0
  }


}