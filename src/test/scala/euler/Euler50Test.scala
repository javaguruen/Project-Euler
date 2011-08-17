package euler

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test

class Euler50Test extends AssertionsForJUnit {

  @Test
  def consecutivePrimesTest() {
    val euler50 = new Euler50()
    val (maksAntallConescPrimes, sum) = euler50.findConsecutivePrimesBelowStartingAt( Array(2, 3, 5), 0, 100 )
    assert( 2 === maksAntallConescPrimes)
    assert( 5 === sum)
  }
  @Test
  def consecutivePrimesExample100Test() {
    val euler50 = new Euler50()
    val (maksAntallConescPrimes, sum) = euler50.findConsecutivePrimesBelow(100)
    assert( 6 === maksAntallConescPrimes)
    assert( 41 === sum)
  }

  @Test
  def consecutivePrimesExample1000Test() {
    val euler50 = new Euler50()
    val (maksAntallConescPrimes, sum) = euler50.findConsecutivePrimesBelow(1000)
    assert( 21 === maksAntallConescPrimes)
    assert(  953 === sum)
  }
}