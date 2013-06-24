package euler

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test

class Euler60Test extends AssertionsForJUnit {
  val euler60 = new Euler60()


  @Test
  def erPrimtall(){
    assert( true === euler60.isPrime(5))
  }
}
