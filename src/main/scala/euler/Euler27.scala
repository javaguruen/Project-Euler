package euler

object Euler27{
  def main(args: Array[String]) : Unit = {
    val hw = new Euler27()
    hw.run
  }
}
class Euler27 {
  private val fs = scala.collection.mutable.Map[Int, BigInt]()

  def run(): Long = {
    var bestA = Int.MinValue
    var bestB = Int.MinValue
    var bestN = -1
    var antallPrimtall = 0
     for( b <- (-999) until 999 ){
      if( MathLib.isPrime( scala.math.abs (  b ))){
        println ("Beregner for b=" + b)
        for( a <- -999 until 999 ){
          var antallN=0
          var n=0
          while( MathLib.isPrime( scala.math.abs(  fn(n, a, b)) )){
            antallN += 1
            n += 1
          }
          //Her er antallN og n en for mye
          if( (antallN-1) > antallPrimtall ){
            bestN = n-1
            antallPrimtall = antallN-1
            bestA = a
            bestB = b
          }
        }
      }
    }
    println( "Antall primtall på rad = " + antallPrimtall )
    println( "A = " + bestA )
    println( "B = " + bestB )
    println( "N = " + bestN )
    println( "a*b = " + (bestA*bestB)  )
      0
  }

  def fn(n: Int, a : Int, b : Int): Int = {
    //n² + an + b
    n*n + a*n + b
  }
}