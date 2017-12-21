package euler

import org.scalatest.FunSuite

class Euler0055Test extends FunSuite{

  val euler55 = new Euler55

  test("reverseTest"){
    assert( "21" == "12".reverse )
  }

  test("reverseAndAddTest"){
    assert( (12+21) == MathLib.reverseAndAdd( 12 ) )
    assert( (8+8) == MathLib.reverseAndAdd( 8 ) )
  }

  test("reverseAndAdd2Test"){
    assert( (12+21) == euler55.reverseAndAddTimes( 12 , 1) )
    assert( 7337 == euler55.reverseAndAddTimes( 349, 3 ) )
  }


}