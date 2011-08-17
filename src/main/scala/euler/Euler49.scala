package euler

import collection.mutable.HashMap
import util.Sorting
import euler.MathLib

class Euler49 {
  var primes: List[Int] = Nil
  var permutasjoner = new HashMap[Int, List[Int]]

   def run(): Long = {

    var threePermutable: List[Int] = Nil

    for (n <- 1001 to 9999 by 2) {
      if (MathLib.isPrimeFast(n)) {
        primes = n :: primes
        permutasjoner += n -> List(n)
      }
    }
    println("primes=" + primes)

    primes.foreach {
      a : Int =>
        primes.foreach {
          b : Int =>
            if (MathLib.isPermutation(a, b)) {
                var liste : List[Int] = permutasjoner(a)
                liste = b :: liste
                permutasjoner += a -> liste
            }
        }
    }
    println("Permutasjoner totalt = " + permutasjoner.size)

    permutasjoner = permutasjoner.filter{ case (k,v) => v.size >= 3 }
    println("Permutasjoner > 3 = " + permutasjoner.size)

    permutasjoner = permutasjoner.filter{ case (k,v) => has3Diff(v) }
    println("Permutasjoner 3+diff = " + permutasjoner.size)
    permutasjoner.foreach{ m =>
        println("Perm(" + m._1 + "=" + m._2)
    }

    permutasjoner.size
  }

  def has3Diff( aList : List[Int] ) : scala.Boolean = {
    var allDiffs = new HashMap[Int, List[Int] ]
    for (i <- 0 until aList.size-1) {
      for (j <- i+1 until aList.size) {
        val a : Int = aList(i)
        val b : Int = aList(j)
        val diff = (b-a).abs
        if (diff < 0) println("-------------------< 0")
        if  ( allDiffs.contains(diff)){
          var tidligere = allDiffs(diff)
          if ( !tidligere.contains( a ) ){
            tidligere = a :: tidligere
           }
          if ( !tidligere.contains( b ) ){
            tidligere = b :: tidligere
           }
          allDiffs += diff -> tidligere
        }
        else{
          allDiffs += diff -> List(a,b)
        }
      }
    }

    allDiffs = allDiffs.filter{ case (k,v) => v.toSet.size > 2 }
    allDiffs.size > 1
  }


}