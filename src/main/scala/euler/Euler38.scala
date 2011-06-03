package euler

import scala.collection.mutable

object Euler38 {
   def main(args : Array[String])  {
     val euler = new Euler38()
     println("svar: " + euler.run)
  }
}


class Euler38 {

  def run(): Long = {
    var maks = 0L
    var tall = 1L
    while (tall < 1000000000) {
      maks = scala.math.max(maks, calculate( tall))
      tall += 1
    }
    maks
  }

  def calculate(base: Long): Long = {
    var concats = base.toString
    var n = 2
    while (concats.length < 9) {
      concats += (base * n).toString
      n += 1
    }
    if (n > 2 && concats.length == 9 && MathLib.isPandigital(concats)) {
      println ("tallet " + base + " er pandigital n=" + (n-1) )
      return concats.toLong
    }
    else {
      return -1
    }

  }

  def isPandigital(tall: String): Boolean = {
    if (tall.contains("0")) {
      return false;
    }
    var maps = mutable.Map.empty[Char, Char]
    for (i <- 0 until 9) {
      maps = maps + (tall(i) -> tall(i))
    }
    return maps.keys.size == 9
  }
}