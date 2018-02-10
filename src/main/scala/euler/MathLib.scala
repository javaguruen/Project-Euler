package euler

import _root_.java.math.BigInteger

import org.slf4j.{Logger, LoggerFactory}

import scala.annotation.tailrec
import scala.collection.mutable

object MathLib {
  def isOdd(i: Int): Boolean = { i%2 != 0 }

  private val logger: Logger = LoggerFactory.getLogger("MathLib")

  def isSquareNumber(n: Int): Boolean = {
    val kvad = Math.sqrt(n.toDouble)
    Math.abs(kvad - Math.round(kvad).toDouble) < 0.001
  }

  def isSquareNumber(n: Long): Boolean = {
    val kvad = Math.sqrt(n.toDouble)
    Math.abs(kvad - Math.round(kvad)) < 0.0000000000000001
  }

  def isHeltall(n: Double): Boolean = {
    Math.abs(n - Math.round(n)) < 0.0000000000000001
  }

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
      //println ("Retur negativ for r=" + r + " n=" + n)
    }
    retur
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

  def fibonacci(n: Long): BigInt ={

    @tailrec
    def fibo(i: Long, n: Long, fn1: BigInt, fn2: BigInt): BigInt = {
      if( fn1 < 0){
        throw new RuntimeException(s"Negative number i=$i -> overflow")
      }
      if (i < n){
        fibo(i+1, n, fn1+fn2, fn1)
      } else {
        fn1 + fn2
      }
    }

    n match {
      case 1 => BigInt(1)
      case 2 => BigInt(1)
      case _ => fibo(3, n, BigInt(1), BigInt(1))
    }

  }

  def sieve(n: Int): List[Int] = {
    val nsArray = (0 to n).toArray
    for( i <- 2 to n){
      if( i != -1){
        var c = 2
        while( i*c <= n){
          //println(s"$i is prime. Clearing ${i*c}")
          nsArray(i*c) = -1
          c += 1
        }
      }
    }

    nsArray.filter(n => n>=2).toList

    /*
    func Sieve(size int) []int {
	//base := time.Now()
	//create a slice of ints
	theSieve := make([]int,size)
	var thePrimes []int

	//fill the thing
	for i:=1; i< size;i++ {
		theSieve[i] = i
	}
	//afterFill := time.Since(base)
	//crossed out is -1
	for j:=2;j<size;j++{
		if (theSieve[j] != -1) {
			if !IsPrime(j) {
				crossOutFromHereonOut(theSieve,j,size)
			}
		}
	}
	//afterCrosses := time.Since(base)
	//at the end, collect all the remainding numbers that now must be primes
	for k:= 3; k< size;k++ {
		if (theSieve[k] != -1) {
			thePrimes = append(thePrimes, theSieve[k])
		}
	}
	//allDone := time.Since(base)
	return thePrimes
}

func crossOutFromHereonOut(sieve[] int, factor int, sievelength int) {
	for i:=factor; i<sievelength;i+=factor {
		if (sieve[i] != -1) {
			sieve[i]=-1
		}
	}
}

     */

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

  /**
   * Alle faktorene (inkludert 1) som tall er delelig på, men ikke tallet selv.
   */
  def properDivisors(tall: Long): List[Long] = {
    var factors: List[Long] = 1 :: Nil
    var max = scala.math.ceil(scala.math.sqrt(tall.toDouble))
    var i = 2

    do {
      val divisor: Long = tall % i
      if (divisor == 0) {
        val t: Long = (tall/i)
        factors =  t :: factors
        factors = i :: factors
      }
      i += 1
    } while (i <= max)
    val k : List[Long] = factors.sortWith(_<_) //{ (a,b) => a<b }
    val l : List[Long] = k.toSet.toList //().asInstanceOf[List[Long]]
    l
  }
/*
  @Deprecated("Bruk properDivisors(Long): List[Long]")
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
*/

  def properDivisorsScalaIncludingN(n: Long): List[Long] = {
    n :: properDivisors ( n )
  }


  def isPandigital(tall: String): Boolean = {
    if (tall.contains("0")) {
      return false
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
        //println ("Candidate " + candidate + " is palindrome (" + sum + " after " + i + " reverseAndAdd")
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

}