package euler

import collection.mutable.HashMap
import org.slf4j.{Logger, LoggerFactory}

class Euler95 {

  var kjeder = new HashMap[Int, List[Long]]
  val start = 1
  val slutt = 1000000
  private val logger : Logger = LoggerFactory.getLogger( "Euler95" )

  def sumOfDivisors(number: Long): Long = {
    val factors: List[Long] = MathLib.properDivisors(number)
    val sum = factors.foldLeft(0l) {
      (s, elem) => s + elem
    }
    sum
  }



  def findLongestChain(): List[Int] = {
    logger.info("Finner lengste kjeder...")
    var maxLength = -1
    var longestChain: List[Int] = Nil
    for (i <- start until slutt) {
      if (i % 100000 == 0) {
        logger.info("\t" + i)
      }
      if (!kjeder.contains(i)) {
        logger.info(" finner ikke kjede for " + i)
      }
      else {
        val chain = kjeder(i)
        val length = chain.size
        if (length > maxLength) {
          maxLength = length
          longestChain = i :: Nil
        }
        else if (length == maxLength) {
          longestChain = i :: longestChain
        }
      }
    }
    longestChain
  }

  def finnKjedeForTall2(tall: Int): scala.List[Long] = {
    var kjede: List[Long] = tall :: Nil
    var nestetall = tall.toLong

    var ferdig = false
    while (!ferdig) {
      val divisors = MathLib.properDivisors(nestetall)
      val sumDivisors = MathLib.summer( divisors )

      if ( sumDivisors > slutt || sumDivisors == 1 || sumDivisors == nestetall) {
        ferdig = true
        kjede = Nil
      }
      else if (kjede.contains(sumDivisors)) {
        if ( sumDivisors == tall){
          ferdig = true
          kjede = sumDivisors :: kjede
        }
        else{
          ferdig = true
          kjede = Nil
        }
      }
      else {
        kjede = sumDivisors :: kjede
        nestetall = sumDivisors
      }
    }
    kjede.reverse
  }

  def run(): Int = {
    //    for ( tall <- 220 until 221){
    logger.info("Finner kjeder...")
    logger.info("Finner kjeder")
    for (tall <- start until slutt) {
      if (tall % 100000 == 0) {
        logger.info("\t" + tall)
      }
      var kjede: scala.List[Long] = finnKjedeForTall2(tall)
      kjeder(tall) = kjede
    }

    val longestChain = findLongestChain()
    logger.info("Lengste kjeder har lengde " + longestChain.size)
    logger.info("Lengste kjeder " + longestChain)
    longestChain.foreach( e => println( kjeder(e)))
    var chain = kjeder( longestChain(0) ).sortWith( (a,b) => a<b )
    logger.info("******************")
    logger.info("" + chain)
    -1
  }

}