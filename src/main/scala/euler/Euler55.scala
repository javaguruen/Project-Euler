package euler

class Euler55 {

  def reverseAndAddTimes(tall: Int, antall: Int): Int = {
    (1 to antall).foldLeft(tall)( (sum, t) => MathLib.reverseAndAdd ( sum ) )
  }

  def run() : Int = {
    var antallLychrel = 0
    for( i <- 1 until 10000){
      if ( MathLib.isLychrelNumber( i )){
        antallLychrel += 1
      }
    }
    println(" Antall lychrel number = " + antallLychrel)
    antallLychrel
  }

}