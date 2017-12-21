package euler

import java.util.{Calendar, GregorianCalendar}
import java.math.MathContext
import org.slf4j.{LoggerFactory, Logger}


class Euler26 {

  val logger = LoggerFactory.getLogger("Euler26.class")

  def run(): Long = {
    val mc = new MathContext(5000)
    var ferdig = false
    var teller = BigDecimal(1, mc)
    var i = 1
    var maksSykel = 1
    while(i<=1000){
      val nevner = BigDecimal(i, mc)
      val desimaltall = (teller/nevner).toString()
      logger.debug("1/" + i + " = " + desimaltall)
      val sykellengde = detectCycle( desimaltall )
      if( sykellengde > 500 ) {
        logger.info("1/"+ i + " sykellengde=" + sykellengde)
        if( sykellengde > maksSykel){
          maksSykel = sykellengde
        }
      }
      i = i + 1
    }
    maksSykel
  }

  def detectCycle(input : String) : Int =  {
    for (offset <- 2 to 10) {
      for (cycleLength <- 1 to 2000) {
        //logger.debug("Leter etter sykellengde " + cycleLength + " med offsett " + offset)
        if (detectSingleCycle(offset, cycleLength, input)) {
          //logger.debug("Fant sykkel på offset " + offset + " med lengde "+ cycleLength)
          return cycleLength
        }
      }
    }
    0
  }

  def detectSingleCycle(offset : Int, size : Int, input : String) : Boolean = {
    val tekstlengde: Int = input.length()
    if (offset + 2*size > tekstlengde ) {
      return false
    }
    var n = 1
    val candidate = input.substring(offset, offset + size)
    while( offset + (n+1)*size < tekstlengde ){
      val nextOffset = offset + n*size
      val nextCandidate = input.substring(nextOffset, nextOffset + size)
      if( !candidate.equalsIgnoreCase(nextCandidate) ){
        return false
      }
      n += 1
    }
    true
  }

}
