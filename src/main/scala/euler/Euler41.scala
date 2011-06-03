package euler

import scala.collection.mutable

object Euler41 {
   def main(args : Array[String])  {
     val euler = new Euler41()
     println("svar: " + euler.run)
  }
}


class Euler41 {

  def run(): Long = {
    var maks = 0L
    var tall = 2143L
    while (tall < 1000000000 && tall > 0) {
      if( MathLib.isPrimeFast( tall ) && MathLib.isPandigital( tall.toString )){
        println (tall + " er primtall og pandigital ")
        maks = tall
      }
      tall += 2
    }
    maks
  }
}