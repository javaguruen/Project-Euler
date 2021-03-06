package euler

import org.slf4j.LoggerFactory


class Euler357 {
  val logger = LoggerFactory.getLogger( "Euler357" )

  val maxCachedPrime = 1
  var primtallUnderMill = getPrimtallUnder(maxCachedPrime)



  def run(maksN: Int): Long = {
    logger.info("Starter kjøring - divisors inline, cache=" + maxCachedPrime)
    var sum = 1L
    val start = System.currentTimeMillis()
    for (n <- 2 until maksN by 4) {

      val max = scala.math.sqrt(n.doubleValue)
      var i = 1

      var fortsatt = true
      do {
        if (n % i == 0) {
          logger.debug(n + " funnet faktorene: " + i + " og " + (n/i) )
          if( ! isDivNprime(i, n)) fortsatt = false
          if( ! isDivNprime((n/i), n)) fortsatt = false
        }
        i += 1
      }
      while (i <= max && fortsatt)
      if( fortsatt ){
        logger.debug("ok for " + n)
        sum += n
      }
      if (n % 10002 == 0) {
        logger.info("n=" + n + " sum=" + sum + " tid(s)=" + (System.currentTimeMillis() - start) / 1000)
      }
    }
    sum
  }

  def properDivisorsScala(n: Int): List[Int] = {
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



  def getPrimtallUnder(n: Int): List[Int] = {
    logger.info("Henter alle primtall < " + n)
    val primes = MathLib.allPrimesInRange(n)
    primes
  }

  def isAllDivisorsDivNPrime(divisors: List[Int], n: Int): Boolean = {
    for (i <- 0 until divisors.size) {
      if (!isDivNprime(divisors(i), n)) {
        return false
      }
    }
    true
  }

  def isAllDivisorsDivNPrimeLong(divisors: List[Long], n: Int): Boolean = {
    for (i <- 0 until divisors.size) {
      if (!isDivNprime(divisors(i).intValue(), n)) {
        return false
      }
    }
    true
  }

  def isDivNprime(d: Int, n: Int): Boolean = {
    val candidate: Long = d + (n / d)
    MathLib.isPrimeFast(candidate)
  }


}