package euler

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test

class Euler55Test extends AssertionsForJUnit {

  val euler55 = new Euler55

  @Test
  def reverseTest(){
    assert( "21" === "12".reverse )
  }

  @Test
  def reverseAndAddTest(){
    assert( (12+21) === MathLib.reverseAndAdd( 12 ) )
    assert( (8+8) === MathLib.reverseAndAdd( 8 ) )
  }
  @Test
  def reverseAndAdd2Test(){
    assert( (12+21) === euler55.reverseAndAddTimes( 12 , 1) )
    assert( 7337 === euler55.reverseAndAddTimes( 349, 3 ) )
  }


}