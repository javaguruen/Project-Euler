package euler

import collection.mutable.HashSet

object Euler35 {
  def main(args: Array[String]): Unit = {
    val hw = new Euler35()
    hw.run
  }
}

class Euler35 {
  var primes = List(2)

  def run(): Long = {


    for (tall <- 3 to 1000000) {
      if (MathLib.isPrimeFast(tall)) {
        primes = tall :: primes
      }
    }
    println ("Antall primtall=" + primes.size)
    println (primes)

    var rotators = primes.filter{ p => isCircularPrime(p) }
    println ("Antall sirkulære primtall=" + rotators.size)
    println ( rotators )

/*
    val rot = rotateAll( 997103 )
    println (rot)
    println("2 er: " + isCircularPrime (997103))
*/
    0
  }

  def isCircularPrime( p : Int) : Boolean = {
    val allRotations = rotateAll( p )
    allRotations.forall{ prime => isPrime(prime)}
  }

  def isPrime(p : Int) = {
    primes.contains( p )
  }

  def rotateAll (p : Int) :List[Int] = {
    var allRotations = List[Int]()
    if (p <10) {
      return List(p)
    }
    var i = 0
    val numberSize = p.toString().length
    var numberToRotate = p.toString
    while (i < numberSize) {
      allRotations = numberToRotate.toInt :: allRotations
      numberToRotate = rotateSingle(numberToRotate)
      i+=1
    }
    allRotations
  }

  def rotateSingle (intString : String) : String =  {
    val first = intString.charAt(0)
    val rotated = intString.substring(1) + first
    rotated
  }
}