package euler

import org.scalatest.FunSuite

class Euler0050Test extends FunSuite {

  test("consecutivePrimesTest") {
    val euler50 = new Euler50()
    val (maksAntallConescPrimes, sum) = euler50.findConsecutivePrimesBelowStartingAt( Array(2, 3, 5), 0, 100 )
    assert( 2 == maksAntallConescPrimes)
    assert( 5 == sum)
  }

  test("consecutivePrimesExample100Test") {
    val euler50 = new Euler50()
    val (maksAntallConescPrimes, sum) = euler50.findConsecutivePrimesBelow(100)
    assert( 6 == maksAntallConescPrimes)
    assert( 41 == sum)
  }

  test("consecutivePrimesExample1000Test") {
    val euler50 = new Euler50()
    val (maksAntallConescPrimes, sum) = euler50.findConsecutivePrimesBelow(1000)
    assert( 21 === maksAntallConescPrimes)
    assert(  953 === sum)
  }
}