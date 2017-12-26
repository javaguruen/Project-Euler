package euler

class Euler10 {
  def run(): Long = {
    val maks = 2000000
    var i = 3
    var antallPrimtall = 0
    var primSum : Long = 2
    var listOfPrimes : List[Int] = 2 :: Nil
    do{
      if (MathLib.isPrimeFast(i)) {
        antallPrimtall += 1
        primSum += i
        listOfPrimes = i :: listOfPrimes
        //println("Primtall: " + i + " sum saa langt " + primSum)
      }
      i += 2
    } while (i < maks)
    //println( listOfPrimes )
    primSum
  }
}