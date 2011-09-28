package euler

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test

class Euler53Test extends AssertionsForJUnit {

  @Test
  def fakultet0Test(){
    val fak0 = MathLib.fakultet(0)
    assert( 1L === fak0)
  }

  @Test
  def select10from23Test(){
    assert( 1144066 === MathLib.selectRfromN(10, 23))
  }

  @Test
  def antallUtvalg3fra5Test(){
    val euler53 = new Euler53
    assert( 12 === euler53.velgAlleTall(3, 5).size)
  }

  @Test
  def utvalg2fra2Test(){
    val euler53 = new Euler53
    assert( List(1, 1, 2) === euler53.velgAlleTall(2, 2).sortWith( (a, b) => a<b))
  }

  @Test
  def utvalg4fra4Test(){
    val euler53 = new Euler53
    assert( List(1, 2, 3, 4 , 1, 3, 6, 1, 4, 1 ).sortWith((a,b) => a < b) === euler53.velgAlleTall(4, 4).sortWith( (a, b) => a<b))
  }

}