package euler

import scala.collection.mutable
import scala.annotation.tailrec


class Euler60 {
  def from(i: Long): Stream[Long] = Stream.cons(i, from(i + 1))
  case class TuplePair(n1: Long, n2: Long) {}
  val pairCache = new mutable.HashMap[TuplePair, Boolean]

  def run(): Int = {
    //val tall = ( 3 to 10000000)
    lazy val tall = from(3L)
    val primtall = tall.filter(t => MathLib.isPrimeFast(t)).take(1000)
    val pairs = findPairs( primtall )
    val okPairs =  pairs.filter( p => pairConcatenatedIsPrime(p._1, p._2))

    var parliste = lagliste( okPairs, Nil)
    val map = new mutable.HashMap[Long, List[Long]]()
    parliste.foreach( tupple => {
      var valuesP1 =  map.getOrElse(tupple._1, Nil)
      map.put( tupple._1, tupple._2 :: valuesP1)
      var valuesP2 =  map.getOrElse(tupple._2, Nil)
      map.put( tupple._2, tupple._1 :: valuesP2)
    } )

    var liste3 = map.getOrElse(3L, Nil)
    var temp = for{
      a <- liste3
      b <-liste3 if( b>a )
      if( map(a).contains(b))
    } yield (3, a, b)
    println( temp )
    //var minsteKey = map.keySet.foldLeft( Long.MaxValue){ (a,b) => Math.min(a,b)}
    //println( map )
    -1
  }



/*
    var smallestSum = Long.MaxValue

    //val primtall = Numbers.filter( t => MathLib.isPrimeFast(t)).take(10000)

    val primtallArray = primtall.toArray
    println("Primtall: " + primtall.size)

    val femtuppel = for {
      first <- primtall
      second <- primtall if second > first
      third <- primtall if third > second
      fourth <- primtall if fourth > third
      fifth <- primtall if fifth > fourth
    } yield (first, second, third, fourth, fifth)

    for (femt <- femtuppel) {

      val femtList = List(femt._1, femt._2, femt._3, femt._4, femt._5)
      val pairs = for {
        i <- femtList
        j <- femtList
        if j > i} yield (i, j)

      var allPairsOk = isAllPairsOk( pairs )
      if( allPairsOk) {
        if (sumList(femtList) < smallestSum) {
          smallestSum = sumList(femtList)
        }
      }
    }

    def sumList( tall : List[Int]) : Int = {
      var sum : Int = 0
      tall.foreach( n => sum = sum + n)
      sum
    }
*/

    /*
        val en = primtallArray(first)
        if (isAllFivePrimeConcatinatedFastAllParam(primtallArray(first), primtallArray(secnd), primtallArray(third), primtallArray(fourth), primtallArray(fifth) )) {
          val sum = primtallArray(first) + primtallArray(secnd) +  primtallArray(third) + primtallArray(fourth) + primtallArray(fifth)

          println(primtallArray)
          return sum
        }

    */

    /*
        for ( first <- 1 until primtall.size) {
          for (secnd <- first until primtall.size) {
            for (third <- secnd until primtall.size) {
              for (fourth <- third until primtall.size ) {
                for (fifth <-fourth until primtall.size) {
                }
              }
            }
          }

        }

    */
    //val riktige = primtall.filter( n=> isAllFivePrimeConcatenated(n))
    //println("riktige: " + riktige)

    //  val summer =
    //riktige.size
  def isAllPairsOk(pairs: List[(Int, Int)]) : Boolean = {
    for (p <- pairs) {
      val res = pairCache.get(TuplePair(p._1, p._2))
      res match {
        case Some(b : Boolean) => if( !b ) return false
        case None => {
          val ok = pairConcatenatedIsPrime(p._1, p._2)
          pairCache.put(TuplePair(p._1, p._2), ok)
          if (!ok) {
            return false
          }
        }
      }
    }
    println("Omg: 5tuple er kjempeprime! " + pairs)
    true
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


  def isAllFivePrimeConcatenated(candidate: Long) = {
    val knowns = List(3, 7, 109, 673)
    val res = knowns.filter(n => isAllFivePrimeConcatenatedFast(n))
    res.size == 4
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

  def isAllFivePrimeConcatenatedFast(candidate: Long): Boolean = {
    if (!pairConcatenatedIsPrime(candidate, 3)) {
      return false;
    }
    if (!pairConcatenatedIsPrime(candidate, 7)) {
      return false;
    }
    if (!pairConcatenatedIsPrime(candidate, 109)) {
      return false;
    }
    if (!pairConcatenatedIsPrime(candidate, 673)) {
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