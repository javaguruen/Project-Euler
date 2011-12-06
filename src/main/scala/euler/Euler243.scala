package euler

import org.slf4j.{Logger, LoggerFactory}

class Euler243 {

  private val logger: Logger = LoggerFactory.getLogger("Euler243")
  private var divisors = Map[Int, List[Long]]()

  def run(): Int = {
    var d = 10
    divisors += 10 -> MathLib.properDivisors(10L)
    val targetResilience = 15499.0/94744.0
    while( true ){
      d +=10
      if ( resilience( d, targetResilience ) ) {
        return d
      }
      if( d % 1000 == 0){
        logger.info("d=" + d)
      }

    }
    logger.info("Resilience < 15499/94744 for d=" + d)
    d
  }

  def getFactors(nominator: Int): scala.List[Long] = {
    var factorsFromKey = divisors.get(nominator)
    val factorsNominator = factorsFromKey match {
      case Some(liste) => liste
      case None => MathLib.properDivisors(nominator)
    }
    factorsNominator
  }

  def resilience(denominator : Int, target : Double) : Boolean = {
    var factorsDenominator = MathLib.properDivisors( denominator )
    divisors += denominator -> factorsDenominator

    val maxAntall = target * (denominator -1)
    var resilientFractions = 1
    for( nominator <- 3 until denominator by 2){
     if (!factorsDenominator.contains( nominator.longValue() )){
        //val factorsNominator = MathLib.properDivisors( nominator )
       val factorsNominator: scala.List[Long] = getFactors(nominator)

//        val factorsNominator = MathLib.properDivisors( nominator )
        val tempList = factorsDenominator ::: factorsNominator
        val tempSet = tempList.toSet
        if( tempSet.size == (factorsDenominator.size + factorsNominator.size -1 )){
          resilientFractions += 1
        }
        if (resilientFractions > maxAntall) {
          if( denominator % 1000 == 0){
            logger.info("d=" + denominator + " res=" + (resilientFractions.toDouble/(denominator-1)) + " target=" + target)
          }
          return false
        }
      }
    }
    if( denominator % 1000 == 0){
      logger.info("d=" + denominator + " res=" + (resilientFractions.toDouble/(denominator-1)) + " target=" + target)
    }
//    nonCancellableNominators.toDouble/(denominator-1)
    resilientFractions.toDouble/(denominator-1) < target
  }

}