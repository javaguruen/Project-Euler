package euler

import org.scalatest.{BeforeAndAfter, FunSuite}

class Euler0049Test extends FunSuite with BeforeAndAfter{
  var euler49 : Euler49 = _

  before{
    euler49 = new Euler49()
  }

/*
  @Before
  def init(){
    euler49 = new Euler49()
  }
*/

  test("isPermutasjonTest") {
    assert( MathLib.isPermutation(1234, 4321))
  }

test("isPermutasjonLeadingZeroTest") {
    assert( MathLib.isPermutation(234, 4320))
  }

test("isPermutasjonFalseTest"){
    assert( !MathLib.isPermutation(1234, 4325))
  }

test("isPermutasjonFalseRepeatingNumbersTest"){
    assert( !MathLib.isPermutation(1234, 4322))
  }
}