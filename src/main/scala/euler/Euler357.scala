package euler

import java.lang.Long
import collection.mutable.HashMap


class Euler357 {

  val maxCachedPrime = 1000000
  var primtallUnderMill: scala.collection.mutable.Map[Long, Int] = getPrimtallUnder(maxCachedPrime)

  def getPrimtallUnder(n: Int): scala.collection.mutable.Map[Long, Int] = {
    var map: scala.collection.mutable.Map[Long, Int] = new HashMap[Long, Int]()
    val primes = MathLib.allPrimesInRange(n)
    primes.foreach{ n => map(n.toLong) = n }
    map
  }

  def isAllDivisorsDivNPrime(list: List[Int], n: Int): Boolean = {
    for (i <- 0 until list.size) {
      if (!isDivNprime(list(i), n)) {
        return false
      }
    }
    true
    /*
        val erPrimtall = list.filter( d => isDivNprime(d, n))
        erPrimtall.size == list.size
    */
  }

  def isDivNprime(d: Int, n: Int): Boolean = {
    val candidate: Long = d + (n / d)
    if (candidate < maxCachedPrime) {
      primtallUnderMill.get(candidate) != null
    }
    else {
      MathLib.isPrimeFast(candidate)
    }
  }

  def run(maksN: Int): Long = {
    var sum = 1L
    val start = System.currentTimeMillis()
    for (n <- 2 until maksN by 2) {
      val divisors = MathLib.properDivisorsScalaIncludingN(n)
      if (isAllDivisorsDivNPrime(divisors, n)) {
        sum += n
      }
      if (n % 10000 == 0) {
        val stopp = System.currentTimeMillis()
        println("n=" + n + " sum=" + sum + " tid(s)=" + (stopp - start) / 1000)
      }
    }
    sum
  }
}