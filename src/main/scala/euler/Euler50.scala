package euler


class Euler50 {

  def findConsecutivePrimesBelowStartingAt(arrayOfPrimes: Array[Int], startPosition: Int, maxSum : Int) : (Int, Int) = {
    var sum  = 0
    var maxSumThatIsPrime  = 0
    var antall = 0
    var antallThatIsPrime = 0
    for ( i <- startPosition until arrayOfPrimes.size) {
      sum += arrayOfPrimes(i)
      antall += 1
      if  (sum >= maxSum){
        return ( antallThatIsPrime, maxSumThatIsPrime)
      }
      if (arrayOfPrimes.contains(sum)) {
        maxSumThatIsPrime = sum
        antallThatIsPrime = antall
      }
    }
    (antallThatIsPrime, maxSumThatIsPrime)
  }

  def run() : Int = {
    val (antall, sum) = findConsecutivePrimesBelow(1000000)
    sum
  }

  def findConsecutivePrimesBelow(maxSum : Int) : (Int, Int) = {

    var maxFoundSum = 0
    var maxNumberOfPrimes = 0
    lazy val primeList2 : List[Int] = MathLib.allPrimesInRange(maxSum)

    val arrayOfPrimes = primeList2.toArray
    for (i <- 0 until arrayOfPrimes.size) {
      if  ( i % 10000 == 0 ) println(".")
      val (numberOfConsecPrimes, sum) = findConsecutivePrimesBelowStartingAt(arrayOfPrimes, i, maxSum)
      if  (numberOfConsecPrimes > maxNumberOfPrimes){
        maxNumberOfPrimes = numberOfConsecPrimes
        maxFoundSum = sum
        //println("Found new max: antall="+maxNumberOfPrimes + " sum="+maxFoundSum)
      }
    }
    (maxNumberOfPrimes, maxFoundSum)
  }

}