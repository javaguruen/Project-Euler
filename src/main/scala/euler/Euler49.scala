package euler

import collection.mutable.HashMap
import dbc.datatype.Boolean

class Euler49 {
  var primes: List[Int] = Nil
  var permutasjoner = new HashMap[Int, List[Int]]

  def run(): Long = {

    var threePermutable: List[Int] = Nil

    for (n <- 1001 to 9999 by 2) {
      if (MathLib.isPrimeFast(n)) {
        primes = n :: primes
        permutasjoner += n -> Nil
      }
    }
    println("primes=" + primes)
    primes.foreach {
      a : Int =>
        primes.foreach {
          b : Int =>
            if (isPermutation(a, b)) {
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
    var allDiffs = new HashMap[Int, (Int,Int)]
    for (i <- 0 until aList.size-1) {
      for (j <- i+1 until aList.size) {
        val a : Int = aList(i)
        val b : Int = aList(j)
        val diff = b-a
        if  ( allDiffs.contains(diff)){
          val tidligere = allDiffs(diff)
          if ( tidligere._1 == a || tidligere._1 == b || tidligere._2 == a || tidligere._2 == b){
            println("a=" + a + " b=" + b + " har diff=" + diff)
            println("  funnet for " + tidligere._1 + " og " + tidligere._2)
            println ("*************")
          }
        }
        allDiffs += diff -> (a,b)
      }
    }
    val sizeBefore = allDiffs.size
    val sizeAfter  = allDiffs.toSet.size
    (sizeBefore-sizeAfter) >= 2
  }

  def isPermutation(a: Int, b: Int): scala.Boolean = {
    if (a == b) return false

    var strA = a.toString
    var strB = b.toString

    var manglerTegn = false
    strA.foreach {
      i => if (!strB.contains(i)) {
        manglerTegn = true
      }
      else{
        strB = strB.replace(i, ' ')
      }
    }
    strB = b.toString
    strB.foreach {
      i => if (!strA.contains(i)) {
        manglerTegn = true
      }
      else{
        strA = strA.replace(i, ' ')
      }
    }

    !manglerTegn
  }
}