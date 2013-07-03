package euler

import scala.collection.mutable
import scala.annotation.tailrec


class Euler64 {

  def numberOfOddPeriods(n : Int) : Int = {
    var antallOdde = 0
    for ( i <- 2 to n){
      //println(" antall Odde i=" + i)
      if( !isSquareNumber(i)){
        val p = pattern(i)
        if( MathLib.isOdd( p._3 ) ){
          antallOdde += 1
        }
      }
    }
    antallOdde
  }

  //def pattern(i: Int) = (1, "2", 1)
  def pattern(n: Int) = {
    val heltall = heltallet(n)
    val list = continuedFractions(n)
    (heltall, list, list.size)
  }

  def continuedFractions(n: Int): List[Int] = {
    val m0 = 0D
    val d0 = 1D
    val a0 = Math.floor(Math.sqrt(n)).toInt

    var cfractionsList : List[Int] = Nil

    var mX = m0
    var dX = d0
    var aX = a0

    var done = false

    while (!done) {
      //for alltid gjør dette :
      val m1 = generateM_nplus1(dX, aX, mX)
      val d1 = generateD_nplus1(n, m1, dX)
      val a1 = generateA_nplus1(a0, m1, d1)

      mX = m1
      dX = d1
      aX = a1

      //println("An something is " + aX)
      cfractionsList = a1 :: cfractionsList
      done = (a1 == 2* a0)
    }
    cfractionsList
  }


  def generateM_nplus1(dn: Double, an: Int, mn: Double): Double = {
    dn * an - mn
  }

  def generateD_nplus1(s: Int, mnplus1: Double, dn: Double): Double = {
    (s - (mnplus1*mnplus1)) / dn.toDouble
  }

  def generateA_nplus1(a0: Int, mnplus1: Double, dnplus1: Double): Int = {
    Math.floor((a0 + mnplus1) / dnplus1.toDouble).toInt
  }

  def run(): Int = {
    numberOfOddPeriods(10000)
  }


  def isSquareNumber(n: Int): Boolean = {
    val kvad = Math.sqrt(n.toDouble)
    return Math.abs(kvad - Math.round(kvad).toDouble) < 0.000001
  }

  def heltallet(n: Int): Int = Math.sqrt(n.toDouble).floor.toInt
}