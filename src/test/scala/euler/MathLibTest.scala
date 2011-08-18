package euler

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test

class MathLibTest extends AssertionsForJUnit {

  @Test
  def pentagonalTest() {
    // Uses ScalaTest assertions
    assert(1 === MathLib.pentagonal(1))
    assert(5 === MathLib.pentagonal(2))
    assert(40755 === MathLib.pentagonal(165))
  }

  @Test
  def triangleTest() {
    assert(1 === MathLib.triangle(1))
    assert(3 === MathLib.triangle(2))
    assert(40755 === MathLib.triangle(285))
  }

  @Test
  def hexagonalTest() {
    assert(1 === MathLib.hexagonal(1))
    assert(6 === MathLib.hexagonal(2))
    assert(15 === MathLib.hexagonal(3))
    assert(40755 === MathLib.hexagonal(143))
  }

  @Test
  def replaceStringTest() {
    val str = "9629"
    val strReplaces = str.replaceFirst("9", " ")
    println ("replacedString=" + strReplaces)
    assert ( " 629" == strReplaces )
  }

  @Test
  def primesInRangeTest() {
    val primes: List[Int] = MathLib.allPrimesInRange(6)
    assert(List(2, 3, 5) === primes)
  }

  @Test
  def isPrimeFastIncludes2() {
    assert(true === MathLib.isPrimeFast(3))
    assert(true === MathLib.isPrimeFast(2))
  }

  @Test
  def isPermutation() {
    assert(true === MathLib.isPermutation(2969, 9629))
  }
}