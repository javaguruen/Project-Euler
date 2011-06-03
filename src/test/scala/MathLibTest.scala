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
  def triangleTest(){
    assert( 1 === MathLib.triangle( 1 ))
    assert( 3 === MathLib.triangle( 2 ))
    assert( 40755 === MathLib.triangle( 285 ))
  }

  @Test
  def hexagonalTest(){
    assert(1 === MathLib.hexagonal( 1 ))
    assert(6 === MathLib.hexagonal( 2 ))
    assert(15 === MathLib.hexagonal( 3 ))
    assert(40755 === MathLib.hexagonal( 143 ))
  }
}