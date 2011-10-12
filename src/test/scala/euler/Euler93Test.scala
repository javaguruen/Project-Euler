package euler

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test

class Euler93Test extends AssertionsForJUnit {
  val euler93 = new Euler93()


  @Test
  def nextInCharn44(){
    assert( 32 === euler93.sumOfSquaredSiffers( 44 ) )
  }
  
  @Test
  def nextInCharn85(){
    assert( 89 === euler93.sumOfSquaredSiffers( 85 ) )
  }

  @Test
  def nextInCharn1(){
    assert( 1 === euler93.sumOfSquaredSiffers( 1 ) )
  }

  @Test
  def chainEndsWith89_145(){
    assert( true === euler93.chainEndsWith89( 145 ) )
  }

  @Test
  def chainEndsWith1_44(){
    assert( false === euler93.chainEndsWith89( 44 ) )
  }


}