package euler

import org.junit.{Ignore, Before, Test}

class Euler49Test  {
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