package euler

import org.scalatest.junit.AssertionsForJUnit
import org.junit.{Ignore, Before, Test}

class Euler357Test {

  @Test
  def isDivNprimeTest() {
    val euler357 = new Euler357()
    assert(true ==euler357.isDivNprime(1,1))
    assert(true ==euler357.isDivNprime(1,2))
    assert(true ==euler357.isDivNprime(2,2))
    assert(false ==euler357.isDivNprime(1,3))
    assert(false ==euler357.isDivNprime(3,3))
    assert(true ==euler357.isDivNprime(2,2))
    assert(true ==euler357.isDivNprime(6,30))
  }

  @Test
  def brukerRiktigDivisorMetode(){
    val divisors = MathLib.properDivisorsScalaIncludingN(30).reverse
    println("Divisors: " + divisors)
    assert( List(1, 2, 3, 5, 6, 10, 15, 30) == divisors)
  }

  @Test
  def kandidater(){
    val start = System.currentTimeMillis()
    var kandids :List[Int] = Nil
    for(n <- 2 until 100000000 by 2){
      val ivn =  2 + (n / 2)
      if( MathLib.isPrimeFast( ivn )){
        kandids = n :: kandids
      }

      if (n % 100000 == 0) {
        val stopp = System.currentTimeMillis()
        println("n=" + n + " tid(s)=" + (stopp - start) / 1000)
      }
    }
  }


  @Test
  def isAllDivisorsDivNPrimeTestNeg {
    val euler357 = new Euler357();
       val divisors = MathLib.properDivisorsScalaIncludingN(3)
       print(divisors)
       assert(false == euler357.isAllDivisorsDivNPrime(divisors, 3))
  }

  @Test
  def isAllDivisorsDivNPrimeTest() {
    val euler357 = new Euler357();
    val divisors = MathLib.properDivisorsScalaIncludingN(30)
    assert(true == euler357.isAllDivisorsDivNPrime(divisors, 30))
  }

  @Test
  @Ignore("Gir outofmemory")
  def isPermutasjonTest() {
    val euler357 = new Euler357()
    val allPrimesInRange: List[Int] = MathLib.allPrimesInRange(100000000)
    println("Antall primtall under 100.000.000 " + allPrimesInRange.size)
    assert(false == MathLib.isPrimeFast(1))
  }
}