package euler

class Euler28 {


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
    var sum = 1
    for ( sideLength <- 3 to 1001 by 2){
      val newDiagoanls = getDiagonalValuesForSidelengthGivenStartValue( sideLength, forrigeMaks)
      sum = newDiagoanls.foldLeft(sum){ (s, elem) => s + elem}
      forrigeMaks = newDiagoanls(3)
    }
    sum
  }


}