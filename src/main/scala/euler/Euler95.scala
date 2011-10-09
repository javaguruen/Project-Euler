package euler

import java.lang.Long
import collection.mutable.HashMap

class Euler95 {

  var kjeder = new HashMap[Int, List[Long]]
  val start = 1
  val slutt = 1000000

  def sumOfDivisors(number: Long): Long = {
    val factors: List[Long] = MathLib.properDivisors(number)
    val sum = factors.foldLeft(0l) {
      (s, elem) => s + elem
    }
    sum
  }

  def findLongestChain(): List[Int] = {
    println("Finner lengste kjeder...")
    var maxLength = -1
    var longestChain: List[Int] = Nil
    for (i <- start until slutt) {
      if (i % 100000 == 0) {
        println("\t" + i)
      }
      if (!kjeder.contains(i)) {
        println(" finner ikke kjede for " + i)
      }
      else {
        val chain = kjeder(i)
        val length = chain.size
        if (length > maxLength) {
          maxLength = length
          longestChain = i :: Nil
        }
        else if (length == maxLength) {
          longestChain = i :: longestChain
        }
      }
    }
    longestChain
  }

  def finnKjedeForTall2(tall: Int): scala.List[Long] = {
    var kjede: List[Long] = tall :: Nil
    var nestetall = tall.toLong

    var ferdig = false
    while (!ferdig) {
      val divisors = MathLib.properDivisors(nestetall)
      val sumDivisors = MathLib.summer( divisors )

      if ( sumDivisors > slutt || sumDivisors == 1 || sumDivisors == nestetall) {
        ferdig = true
        kjede = Nil
      }
      else if (kjede.contains(sumDivisors)) {
        if ( sumDivisors == tall){
          ferdig = true
          kjede = sumDivisors :: kjede
        }
        else{
          ferdig = true
          kjede = Nil
        }
      }
      else {
        kjede = sumDivisors :: kjede
        nestetall = sumDivisors
      }
    }
    kjede.reverse
  }

  def run(): Int = {
    //    for ( tall <- 220 until 221){
    println("Finner kjeder...")
    for (tall <- start until slutt) {
      if (tall % 100000 == 0) {
        println("\t" + tall)
      }
      var kjede: scala.List[Long] = finnKjedeForTall2(tall)
      kjeder(tall) = kjede
    }

    val longestChain = findLongestChain()
    println("Lengste kjeder har lengde " + longestChain.size)
    println("Lengste kjeder " + longestChain)
    longestChain.foreach( e => println( kjeder(e)))
    var chain = kjeder( longestChain(0) ).sortWith( (a,b) => a<b )
    println("******************")
    println (chain)
    -1
  }
}