package euler

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test

import java.math.BigInteger

class Euler58Test extends AssertionsForJUnit {
  val euler58 = new Euler58()


  @Test
  def incrementalFor4(){
    assert( 4 === euler58.getIncrementByPreviousSideLength(3) )
  }

  @Test
  def incrementalFor0(){
    assert( 1 === euler58.getIncrementByPreviousSideLength(-1) )
  }

  @Test
  def getDiagonalValuesForSidelength3(){
    assert ( List(3, 5, 7, 9) === euler58.getDiagonalValuesForSidelengthGivenStartValue( 3, 1) )
  }


  @Test
  def getDiagonalValuesForSidelength5(){
    assert ( List(13, 17, 21, 25) === euler58.getDiagonalValuesForSidelengthGivenStartValue( 5, 9) )
  }


}