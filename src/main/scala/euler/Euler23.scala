package euler

class Euler23 {
  def run(): Long = {
    var alleSummer: Map[Int, Int] = Map()
    var vennligsum = 0
    val maks = 28124
    var sumD: Array[Int] = new Array[Int](maks+1);
    var abundantList: List[Int] = Nil
    for (i <- 1 until maks) {
      val devisors = MathLib.properDivisors(i)
      val sum = summer(devisors)
      //      println("sum[" + i + "] = " + sum)
      if (sum > i) {
        println("OMG! abundant number! " + i + " " + sum)
        abundantList = i :: abundantList
      }
    }
    println("Abundanter ( " + abundantList.size + ") " + abundantList)
    alleSummer = summerAlleMuligeKombinasjonerAvAbundanteTall(abundantList)
    println("Alle summer " + alleSummer);
    val heltallIkkeSumAvToAbundant = finnAlleHeltallIkkeSumAvAbundant( alleSummer, maks )
    println("Alle heltall ikke sum: " + heltallIkkeSumAvToAbundant)
    var sumAlle = heltallIkkeSumAvToAbundant.foldLeft(0){ _ + _}
    println("Sum alle som ikke er sum av ... " + sumAlle)
    sumAlle
  }

  def finnAlleHeltallIkkeSumAvAbundant( alleSummer : Map[Int, Int], maks : Int) : List[Int] = {
    var liste = List.range(1, maks)
    liste.filter ( !alleSummer.contains(_))
  }

  def summerAlleMuligeKombinasjonerAvAbundanteTall(dataInn: List[Int]): Map[Int, Int] = {
    var myMap : Map[Int, Int] = Map()
    val size = dataInn.size
    for (i <- 0 until size ) {
      for (j <- i until size) {
        val sum: Int = dataInn(i) + dataInn(j)
        myMap += ( sum -> sum)
      }
    }
    myMap
  }

  def summer(tall: List[Long]): Int = {
    var sum = 0L;
    for (i <- 0 until tall.size) {
      sum = sum + tall(i)
    }
    sum.intValue()
  }

}