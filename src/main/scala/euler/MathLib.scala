package euler

import scala.collection.mutable
import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer
import java.lang.Long
import java.math.{BigDecimal, BigInteger}

object MathLib {

  def summer(liste : List[Long] ) : Long = liste.foldLeft(0l) { (s, e) => s + e } 


  def selectRfromN(r: Int, n: Int): BigInt = {
    val teller = fakultet(n)
    val nevner = fakultet(r) * fakultet(n-r)
/*
    if( teller.toLong <= 0){
      println ("Teller negativ")
    }
    if( nevner.toLong <= 0){
      println ("Nevner negativ")
    }
*/
    val retur = (teller / nevner)
    if( retur <= new BigInt( new BigInteger("0")) ){
      println ("Retur negativ for r=" + r + " n=" + n)
    }
    retur
  }

  /**
   * Alle faktorene (inkludert 1) som tall er delelig på, men ikke tallet selv.
   */
  def properDivisors(tall: Long): List[Long] = {
    var factors: List[Long] = 1 :: Nil
    var max = scala.math.ceil(scala.math.sqrt(tall.doubleValue))
    var i = 2

    do {
      val divisor: Long = tall % i
      if (divisor == 0) {
        factors = (tall/i) :: factors
        factors = i :: factors
      }
      i += 1
    } while (i <= max)
    factors = factors.sortWith( (a,b) => a<b)
    factors = factors.removeDuplicates
    factors
  }


  @Deprecated()
  def allFactors(tall: Long): List[Long] = {
    var factors: List[Long] = Nil
    var max = scala.math.ceil(scala.math.sqrt(tall.doubleValue))
    var i = 2

    do {
      if (tall % i == 0) {
        factors = tall :: factors
        factors = (tall / i) :: factors
      }
      i += 1
    } while (i <= max)
    factors
  }

  def hasFactor(tall: Long): Boolean = {
    var max = scala.math.ceil(scala.math.sqrt(tall.doubleValue))
    var i = 2

    while (i <= max) {
      if (tall % i == 0) {
        return true
      }
      i += 1
    }
    false
  }

  def pentagonal(tall: Int) : Long = {
    val t : Long = tall
    t*(3*t-1)/2
  }

  def triangle(tall: Int) : Long = {
    val t : Long = tall
    t*(t+1)/2
  }

  def hexagonal(tall: Int) : Long = {
    val t : Long = tall
    t*(2*t-1)
  }

  def isPrime(tall: Long) = allFactors(tall).isEmpty

  def isPrimeFast(tall: Long) = (tall == 1 || tall == 2 || (!hasFactor(tall) && tall>1))

  def allPrimesInRange(primeMax: Int) : List[Int] = {
    val result = List.range(2, primeMax)
    val primes = result.filter( isPrimeFast( _ ))
    primes
  }

  def triangleNumber(tall: Long): Long = {
    tall * (tall + 1) / 2
  }

  def fakultet(n: Int): BigInt = {
    if (n <= 1) {
      return 1
    }
    else {
      var p: BigInt = fakultet(n - 1) * n
//      println(p);
      return p
    }
  }


  def tverrsum(tall: String): Int = {
    tall.foldLeft(0)(_ + _.toInt - '0'.toInt)
  }

   def isPermutation(a: Int, b: Int): scala.Boolean = {
    if (a == b) return false

    var strA = a.toString
    var strB = b.toString

    if  (strA.size==3){
      strA = "0" + strA
    }
    if  (strB.size==3){
      strB = "0" + strB
    }

    var manglerTegn = false
    strA.foreach {
      i => if (!strB.contains(i)) {
        manglerTegn = true
      }
      else{
        strB = strB.replaceFirst(i.toString, " ")
      }
    }
    strB = b.toString
    strB.foreach {
      i => if (!strA.contains(i)) {
        manglerTegn = true
      }
      else{
        strA = strA.replaceFirst(i.toString, " ")
      }
    }

    !manglerTegn
  }

  def properDevisors(n: Int): java.util.List[Int] = {
    var factors: List[Int] = Nil
    val max = scala.math.ceil(n.doubleValue / 2)
    var i = 1

    do {
      if (n % i == 0) {
        factors = i :: factors
      }
      i += 1
    } while (i <= max)
    asList(ListBuffer(factors: _*))
  }

  def properDivisorsScala(n: Int): List[Int] = {
    var factors: List[Int] = Nil
    val max = scala.math.ceil(n.doubleValue / 2)
    var i = 1

    do {
      if (n % i == 0) {
        factors = i :: factors
      }
      i += 1
    } while (i <= max)
    factors
  }

  def properDivisorsScalaIncludingN(n: Int): List[Int] = {
    n :: properDivisorsScala ( n )
  }


  def isPandigital(tall: String): Boolean = {
    if (tall.contains("0")) {
      return false;
    }
    var maps = mutable.Map.empty[Char, Char]
    for (i <- 0 until tall.length ) {
      maps = maps + (tall(i) -> tall(i))
      if( ( ( tall(i))-'0') > tall.length ){
        return false
      }
    }
    return maps.keys.size == tall.length
  }

  def isPalindrome ( candidate : Int) : Boolean = {
    val str = ""+candidate
    return str.equalsIgnoreCase(str.reverse)
  }

  def isPalindrome ( candidate : BigInt) : Boolean = {
    val str = candidate.toString()
    str.equalsIgnoreCase(str.reverse)
  }

  def reverseAndAdd(tall: Int): Int = {
    val reversed = tall.toString.reverse.toInt
    tall + reversed
  }

  def reverseAndAdd(tall: BigInt): BigInt = {
    val reversed = new BigInt( new BigInteger(tall.toString.reverse))
    tall + reversed
  }

  
  def isLychrelNumber(candidate : Int) : Boolean = {
    var sum = new BigInt( new BigInteger( candidate.toString ) )
    for ( i <- 1 until 50){
      sum = MathLib.reverseAndAdd( sum )
      if ( isPalindrome( sum ) ){
        println ("Candidate " + candidate + " is palindrome (" + sum + " after " + i + " reverseAndAdd")
        return false
      }
    }
    true
  }
  
  def bigPow(base : Int,  exponent :Int ) : BigInt = {
    val bigBase : BigInt = new BigInt ( new BigInteger ( base.toString ) )
    var result : BigInt =  bigBase
    for ( i <- 1 until exponent) {
      result = result.*( bigBase )
    }
    result
  }

  def bigTverrsum(tall : BigInt ) : Int = {
    tall.toString().foldLeft(0){ (sum, tegn) => sum + (tegn.toInt - '0'.toInt) }
  }

  def triangleAreaBySideLengths(a: Int,  b : Int,  c : Int) : Double = {
    //Hero's (or Heron's formule (http://www.wikihow.com/Calculate-the-Area-of-a-Triangle)
    val s = (a + b + c) / 2.0

    scala.math.sqrt( s * (s-a) * (s-b) * (s-c) )
  }

  def triangleAreaBySideLengthsBigDecimal(a: Int, b: Int, c: Int) : scala.math.BigDecimal = {
    var s = scala.math.BigDecimal( (a+b+c)/2.0)
//    scala.math.sqrt( s * (s-a) * (s-b) * (s-c) )
    val sa : scala.math.BigDecimal = s-a
    val sb : scala.math.BigDecimal = s-b
    val sc : scala.math.BigDecimal = s-c

    val tmp : scala.math.BigDecimal =  (s * (sa) * (sb) * (sc))
    scala.math.sqrt(tmp.toDouble)

  }

  def resilience(denominator : Int) : Double = {
    var factorsDenominator = properDivisors( denominator )
    var nonCancellableNominators = 1
    for( nominator <- 2 until denominator){
      if( !factorsDenominator.contains( nominator )){
        val factorsNominator = properDivisors( nominator )
        val tempList = factorsDenominator ::: factorsNominator
        val tempSet = tempList.toSet
        if( tempSet.size == (factorsDenominator.size + factorsNominator.size -1 )){
          nonCancellableNominators += 1
          println("teller=" + nominator)
          println("factorsNominator " + factorsNominator)
          println("factorsDenominator " + factorsDenominator)
        }
      }
    }
    nonCancellableNominators.toDouble/(denominator-1)
  }
}