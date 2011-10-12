package euler

import org.slf4j.{Logger, LoggerFactory}

class Euler93 {

  private val logger: Logger = LoggerFactory.getLogger("Euler93")

  def sumOfSquaredSiffers(i: Int) : Int = {
    i.toString.foldLeft(0){ (s,e) => s + ( (e-'0')*(e-'0'))}
  }

  def chainEndsWith89(i: Int): Boolean = {
    var next = i
    while( next != 1 && next != 89){
      next = sumOfSquaredSiffers( next )
    }

    next == 89
  }

  def run(): Int = {
    var antallEnder89 = 0
    for( i <- 2 until 10000000){
      if( chainEndsWith89( i )){
        antallEnder89 += 1
      }
    }
    logger.info("antall = " + antallEnder89)
    antallEnder89
  }
}