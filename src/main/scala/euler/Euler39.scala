package euler

import scala.math._
import org.slf4j.LoggerFactory

class Euler39 {
  val logger = LoggerFactory.getLogger("Euler39")

  def run(): Long = {
    var maksAntallSolutions = 0
    var maksP = 0
    var p = 0
    for( p  <- 1 to 1000){
      val antallSolutions = findNumberSolutions( p )
      if( antallSolutions > maksAntallSolutions ){
        logger.info("Ny maks=" + maksAntallSolutions + " for p=" + p)
        maksAntallSolutions = antallSolutions
        maksP = p
      }
    }
    maksP
  }

  def findNumberSolutions(p : Int) : Int =  {
    val max = (p / 2).toInt
    var numberOfSolutions = 0
/*
    for (val a:Int <- 1 to max ) {
      for (val b:Int <- a to max) {
        val leftside = a*a +b*b
        val rightside = (p-a-b) * (p-a-b)
        if (leftside == rightside) {
          numberOfSolutions += 1
        }
      }
    }
    */
    numberOfSolutions
  }
}