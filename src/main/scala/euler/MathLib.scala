package euler

import scala.collection.mutable
import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer

object MathLib {
  def allFactors(tall: Long): List[Long] = {
    var factors: List[Long] = Nil
    var max = scala.math.ceil(scala.math.sqrt(tall.doubleValue))
    var i = 2

    do {
      if (tall % i == 0) {
        factors = tall :: factors
        factors = (tall / i) :: factors
      }
      i += 1
    } while (i <= max)
    factors
  }

  def hasFactor(tall: Long): Boolean = {
    var max = scala.math.ceil(scala.math.sqrt(tall.doubleValue))
    var i = 2

    while (i <= max) {
      if (tall % i == 0) {
        return true
      }
      i += 1
    }
    false
  }

  def pentagonal(tall: Int) : Long = {
    val t : Long = tall
    t*(3*t-1)/2
  }

  def triangle(tall: Int) : Long = {
    val t : Long = tall
    t*(t+1)/2
  }

  def hexagonal(tall: Int) : Long = {
    val t : Long = tall
    t*(2*t-1)
  }

  def isPrime(tall: Long) = allFactors(tall).isEmpty

  def isPrimeFast(tall: Long) = !hasFactor(tall) && tall>1

  def triangleNumber(tall: Long): Long = {
    tall * (tall + 1) / 2
  }

  def fakultet(n: Int): BigInt = {
    if (n == 1) {
      return 1
    }
    else {
      var p: BigInt = fakultet(n - 1) * n
      println(p);
      return p
    }
  }


  def tverrsum(tall: String): Int = {
    tall.foldLeft(0)(_ + _.toInt - '0'.toInt)
  }

  def properDevisors(n: Int): java.util.List[Int] = {
    var factors: List[Int] = Nil
    val max = scala.math.ceil(n.doubleValue / 2)
    var i = 1

    do {
      if (n % i == 0) {
        factors = i :: factors
      }
      i += 1
    } while (i <= max)
    asList(ListBuffer(factors: _*))
  }

  def properDevisorsScala(n: Int): List[Int] = {
    var factors: List[Int] = Nil
    val max = scala.math.ceil(n.doubleValue / 2)
    var i = 1

    do {
      if (n % i == 0) {
        factors = i :: factors
      }
      i += 1
    } while (i <= max)
    factors
  }


  def isPandigital(tall: String): Boolean = {
    if (tall.contains("0")) {
      return false;
    }
    var maps = mutable.Map.empty[Char, Char]
    for (i <- 0 until tall.length ) {
      maps = maps + (tall(i) -> tall(i))
      if( ( ( tall(i))-'0') > tall.length ){
        return false
      }
    }
    return maps.keys.size == tall.length
  }
  
}