package euler

class Euler58 {


  def getDiagonalValuesForSidelengthGivenStartValue(sideLength : Int,  startValue : Int) : List[Int] = {
    val increment : Int = getIncrementByPreviousSideLength( sideLength-2)
    var diagonals : List[Int] = Nil
    (1 to 4).foreach( (it:Int)  => diagonals ::= (startValue + (it*increment).toInt) )
    diagonals.reverse
  }

  def getIncrementByPreviousSideLength(prevSideLength : Int) : Int = {
    prevSideLength + 1
  }

  def antallPrimtall( liste : List[Int]) : Int = {
    val primes = liste.filter( i => MathLib.isPrimeFast( i ) )
    primes.size
  }
  
  
  def run() : Int = {
    var sideLength = 1
    var forrigeMaks = 1
    var forholdPrimtall = 100.0
    var antPrimtall = 0
    var antallTall = 1 //tallet 1
    var printGrense = 100.0
    while( forholdPrimtall > 10.0){
      sideLength += 2
      val newDiagoanls = getDiagonalValuesForSidelengthGivenStartValue( sideLength, forrigeMaks)
      val antallNyePrimtall = antallPrimtall( newDiagoanls )
      antPrimtall += antallNyePrimtall
      antallTall += 4
      forholdPrimtall = (antPrimtall.toFloat/antallTall)*100.0
      if  (forholdPrimtall < printGrense ){
        println("Sidelengde=" + sideLength + " primtall: " + antPrimtall + " antallTall: " + antallTall)
        println("\tForholdstall=" + forholdPrimtall)
        printGrense = scala.math.floor( forholdPrimtall )
      }
    }
    sideLength
  }


}