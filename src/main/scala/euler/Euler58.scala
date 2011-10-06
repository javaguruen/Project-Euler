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
    var diagonals : List[Int] = 1 :: Nil
    var sideLength = 1
    var forrigeMaks = 1
    var forholdPrimtall = 100f
    var antPrimtall = 0
    while( forholdPrimtall > 10f){
      sideLength += 2
      val newDiagoanls = getDiagonalValuesForSidelengthGivenStartValue( sideLength, forrigeMaks)
      diagonals = newDiagoanls ::: diagonals

      val antallNyePrimtall = antallPrimtall( newDiagoanls )
      antPrimtall += antallNyePrimtall
      val antallTall = diagonals.size
       forholdPrimtall = (antPrimtall.toFloat/antallTall)*100.0f
    }
    sideLength
  }


}