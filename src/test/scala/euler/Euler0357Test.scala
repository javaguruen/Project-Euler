package euler

import org.scalatest.FunSuite

class Euler0357Test extends FunSuite{

  test("isDivNprimeTest") {
    val euler357 = new Euler357()
    assert(euler357.isDivNprime(1, 1))
    assert(euler357.isDivNprime(1, 2))
    assert(euler357.isDivNprime(2, 2))
    assert(!euler357.isDivNprime(1, 3))
    assert(!euler357.isDivNprime(3, 3))
    assert(euler357.isDivNprime(2, 2))
    assert(euler357.isDivNprime(6, 30))
  }

  test("brukerRiktigDivisorMetode"){
    val divisors = MathLib.properDivisorsScalaIncludingN(30).reverse
    //println("Divisors: " + divisors)
    assert( List(1, 2, 3, 5, 6, 10, 15, 30) == divisors.sortWith{ (a,b) => a<b})
  }

  test("isAllDivisorsDivNPrimeTestNeg") {
    val euler357 = new Euler357()
       val divisors = MathLib.properDivisorsScalaIncludingN(3)
       //print(divisors)
       assert(!euler357.isAllDivisorsDivNPrimeLong(divisors, 3))
  }

  test("isAllDivisorsDivNPrimeTest") {
    val euler357 = new Euler357()
    val divisors = MathLib.properDivisorsScalaIncludingN(30)
    assert(euler357.isAllDivisorsDivNPrimeLong(divisors, 30))
  }

}