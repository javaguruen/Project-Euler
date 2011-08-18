package euler

import org.scalatest.junit.AssertionsForJUnit
import org.junit.{Before, Test}

class Euler49Test extends AssertionsForJUnit {
  var euler49 : Euler49 = null


  @Before
  def init(){
    euler49 = new Euler49()
  }

  @Test
  def isPermutasjonTest() {
    assert( true == MathLib.isPermutation(1234, 4321))
  }

  @Test
  def isPermutasjonLeadingZeroTest() {
    assert( true == MathLib.isPermutation(234, 4320))
  }

  @Test
  def isPermutasjonFalseTest() {
    assert( false == MathLib.isPermutation(1234, 4325))
  }

  @Test
  def isPermutasjonFalseRepeatingNumbersTest() {
    assert( false == MathLib.isPermutation(1234, 4322))
  }
}