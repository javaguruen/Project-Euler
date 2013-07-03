package euler

import scala.collection.mutable
import scala.annotation.tailrec


class Euler60 {
  def from(i: Long): Stream[Long] = Stream.cons(i, from(i + 1))
  case class TuplePair(n1: Long, n2: Long) {}

  def run(): Int = {
    lazy val tall = from(3L)
    val primeNumbers = tall.filter(t => MathLib.isPrimeFast(t)).take(1200)
    val primeNumberPairs = findPairs( primeNumbers )
    val concatenablePrimePairs =  primeNumberPairs.filter( p => pairConcatenatedIsPrime(p._1, p._2))

    val parliste = lagliste( concatenablePrimePairs, Nil)
    val map = new mutable.HashMap[Long, List[Long]]()
    parliste.foreach( tupple => {
      val valuesP1 =  map.getOrElse(tupple._1, Nil)
      map.put( tupple._1, tupple._2 :: valuesP1)
      val valuesP2 =  map.getOrElse(tupple._2, Nil)
      map.put( tupple._2, tupple._1 :: valuesP2)
    } )

    val startKey = 7800L
    var maksKey = Long.MinValue
    map.keySet.foreach(key => {
      maksKey = Math.max(key, maksKey)
      if( key >startKey ){
      val listOfConcatenablePrimes = map.getOrElse(key, Nil)
        val fivePrimeSets = for {
          a <- listOfConcatenablePrimes
          b <- listOfConcatenablePrimes if (b > a)
          c <- listOfConcatenablePrimes if (c > b)
          d <- listOfConcatenablePrimes if (d > c)
          if (map(a).contains(b))
          if (map(a).contains(c))
          if (map(b).contains(c))
          if (map(a).contains(d))
          if (map(b).contains(d))
          if (map(c).contains(d))
        } yield (key, a, b, c, d, key + a + b + c + d)
      if( fivePrimeSets.size > 0 ) {
        println( fivePrimeSets )
      }
      }
    } )
    println("MaksKey = " + maksKey)
    -1
  }

  def findPairs(stream: Stream[Long])  = {
    val liste = for{
      i <- stream
      j <- stream
      if j>i
    } yield( i,j)
    liste
  }

  @tailrec
  private def lagliste(stream: Stream[(Long, Long)], liste: List[(Long, Long)]) : List[(Long, Long)] = {
    stream match{
      case xs #::xt => lagliste( stream.tail, xs :: liste)
      case _ => liste
    }
  }

  def isAllFivePrimeConcatinatedFastAllParam(n1: Long, n2: Long, n3: Long, n4: Long, n5: Long): Boolean = {
    if (!pairConcatenatedIsPrime(n1, n2)) {
      return false;
    }
    if (!pairConcatenatedIsPrime(n1, n3)) {
      return false;
    }
    if (!pairConcatenatedIsPrime(n1, n4)) {
      return false;
    }
    if (!pairConcatenatedIsPrime(n1, n5)) {
      return false;
    }


    if (!pairConcatenatedIsPrime(n2, n3)) {
      return false;
    }
    if (!pairConcatenatedIsPrime(n2, n4)) {
      return false;
    }
    if (!pairConcatenatedIsPrime(n2, n5)) {
      return false;
    }
    if (!pairConcatenatedIsPrime(n3, n4)) {
      return false;
    }
    if (!pairConcatenatedIsPrime(n3, n5)) {
      return false;
    }
    if (!pairConcatenatedIsPrime(n4, n5)) {
      return false;
    }
    true
  }

  def isPrime(number: Long): Boolean = {
    MathLib.isPrimeFast(number)
  }

  def pairConcatenatedIsPrime(n1: Long, n2: Long): Boolean = {
    val comb1: String = n1.toString + n2.toString
    val comb2: String = n2.toString + n1.toString
    MathLib.isPrimeFast(comb1.toLong) && MathLib.isPrimeFast(comb2.toLong)
  }
}