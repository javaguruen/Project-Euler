package euler

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test

class Euler95Test extends AssertionsForJUnit {
  val euler95 = new Euler95()


  @Test
  def sumOfDivisorsOf220(){
    assert( 284 === euler95.sumOfDivisors (220l) )
  }
  
  @Test
  def appendingAvLister(){
    var listeTo = List(4, 5, 6)
    var listeTre = List(7, 8, 9) ::: listeTo
    
    println (listeTo)
    println (listeTre)

    println (listeTo)
    println (listeTre)
  }
  
  @Test
  def kjedeAvTre(){
    assert( List(220, 284, 220) === euler95.finnKjedeForTall2( 220 ))
  }

  @Test
  def kjede6ErNil(){
    assert( Nil === euler95.finnKjedeForTall2( 6 ))
  }

  @Test
  def kjede25ErNil(){
    assert( Nil === euler95.finnKjedeForTall2( 6 ))
  }

  @Test
  def kjedeAvFem(){
    assert( List(12496, 14288, 15472, 14536, 14264, 12496) === euler95.finnKjedeForTall2( 12496 ))
  }

  @Test
  def kontrollSvar(){
    val liste = List(2924, 2620, 2924, 3124, 4156, 8306, 9550, 12724, 9620, 7120, 5900, 4404, 2652, 1380)
    liste.foreach( e => {println ("E=" + e); println( MathLib.properDivisors(e)); println(MathLib.properDivisors(e).foldLeft(0l){(su, el) => su+el}) })
  }
}