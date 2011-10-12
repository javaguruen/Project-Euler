package euler

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test

class Euler94Test extends AssertionsForJUnit {
  val euler94 = new Euler94()


  @Test
  def areaOf556(){
    assert( 12 === euler94.getAreaOneMore( 5 ) )
  }
  
}