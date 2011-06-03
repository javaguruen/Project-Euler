package euler

import collection.mutable.HashSet

object Euler32 {
  def main(args: Array[String]): Unit = {
    val hw = new Euler32()
    hw.run
  }
}

class Euler32 {


  def run(): Long = {
    var sum : Int = 0
    val theSet = new HashSet[Int]

    for (a <- 1 to 10000) {
      for ( b <-1 to 10000) {
        val c = a * b;
        if (isPandigital(a,b,c)) {
          theSet.add(c)
        }
      }
    }
    println ("settet er " + theSet + " antall er " + theSet.size)
    theSet.foreach( s => sum = sum + s)
    println( "Sum er " + sum)
    0
  }

  def isPandigital (a: Int,b:Int,c:Int): Boolean = {
    val s = a.toString + b.toString + c.toString
    if (s.size != 9) {
      return false
    }

    for (c <-1 to 9) {
      if (!s.contains(c.toString))  {
        return false
      }
    }
    println ("OMG! " + a + " " + b +" " + c )
    return true
  }
}