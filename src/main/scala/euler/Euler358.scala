package euler

import org.slf4j.LoggerFactory


class Euler358 {

  val logger = LoggerFactory.getLogger("Euler358")

  def removeLeadingZeros(s: String): String = {
    BigInt(s).toString()
  }

  def findAllRotation(n: String) : List[String] = {
    var liste : List[String] = Nil
    liste = n :: liste
    for( i<- 1 until n.length() ){
      liste = removeLeadingZeros((n.substring(i) + n.substring (0, i))) :: liste
    }
    liste
  }

  def isCyclic(number: BigInt, list: List[String]) : Boolean = {
    for (i <- 2 to list.length) {
      if( i>2) logger.debug("tester cyclic, i=" + i)
      var candidate = (number * 2).toString()
      if (!list.contains(candidate)) {
        return false
      }
    }
    true
  }

  def padNumber(number: Int, digits: Int): String = {
    val numberString = number.toString
    val alreadyGotSize = numberString.length()
    val toPad = digits - alreadyGotSize
    var padding = ""
    if (toPad == 0) {
      return numberString
    } else {
      for (i <- 1 to toPad) {
        padding += "0"
      }
      padding+numberString
    }
  }

  def run(): Long = {
    val startNumber="00000000137"
    val sluttNumber="56789"

    val max = 100
    val maxDigit = 3
    var found : List[String] = Nil

    for(i <- 0 to max){
      val number = startNumber + padNumber(i, maxDigit) + sluttNumber
      val rotations = findAllRotation( number )
      val bigTall = BigInt( number )
      var isCyc = isCyclic(bigTall, rotations)
      if( isCyc ){
        logger.info("number=" + number + " isCyclic=" + isCyc)
        found = number :: found
      }
      if( i % 100000 == 0){
        logger.info("number=" + number)
      }

    }
    println("Found = " + found.size)
    found.foreach( n => println(n))
    0L
  }

}