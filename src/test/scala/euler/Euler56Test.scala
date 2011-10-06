package euler

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test

import java.math.BigInteger

class Euler56Test extends AssertionsForJUnit {

  @Test
  def maksPow(){
    //println( new BigInt(( scala.math.pow(99, 99) )
  }

  @Test
  def bigPow2x2(){
    assert( 4 === MathLib.bigPow(2,2) )
  }
  
  @Test
  def tverrsumPow10x100(){
    val tall: BigInt = MathLib.bigPow(1, 100)
    assert( 1 === MathLib.bigTverrsum (tall ) )
  }

  @Test
  def tverrsumPow100x100(){
    val tall: BigInt = MathLib.bigPow(100, 100)
    assert( 1 === MathLib.bigTverrsum (tall ) )
  }

  @Test
  def bigTversum(){
    val bigTall: BigInt = new BigInt(new BigInteger("99"))
    val bigTverrsum: Any = MathLib.bigTverrsum(bigTall)
    assert ( 18 === bigTverrsum)
  } 
  

}