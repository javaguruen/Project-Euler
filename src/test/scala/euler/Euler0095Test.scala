package euler

import org.scalatest.FunSuite

class Euler0095Test extends FunSuite {
  val euler95 = new Euler95()


  test("sumOfDivisorsOf220"){
    assert( 284 === euler95.sumOfDivisors (220l) )
  }
  
  test("appendingAvLister"){
    val listeTo = List(4, 5, 6)
    val listeTre = List(7, 8, 9) ::: listeTo
    
    println (listeTo)
    println (listeTre)

    println (listeTo)
    println (listeTre)
  }
  
  test("kjedeAvTre"){
    assert( List(220, 284, 220) === euler95.finnKjedeForTall2( 220 ))
  }

  test("kjede6ErNil"){
    assert( Nil === euler95.finnKjedeForTall2( 6 ))
  }

  test("kjede25ErNil"){
    assert( Nil === euler95.finnKjedeForTall2( 6 ))
  }

  test("kjedeAvFem"){
    assert( List(12496, 14288, 15472, 14536, 14264, 12496) === euler95.finnKjedeForTall2( 12496 ))
  }

  test("kontrollSvar"){
    val liste = List(2924, 2620, 2924, 3124, 4156, 8306, 9550, 12724, 9620, 7120, 5900, 4404, 2652, 1380)
    //liste.foreach( e => {println ("E=" + e); println( MathLib.properDivisors(e)); println(MathLib.properDivisors(e).foldLeft(0l){(su, el) => su+el}) })
  }
}