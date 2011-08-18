package euler

import collection.mutable.HashMap

class Euler49 {

  def findPrimesInRange: scala.List[Int] = {
    var primes: List[Int] = Nil
    for (n <- 1001 to 9999 by 2) {
      if (MathLib.isPrimeFast(n)) {
        primes = n :: primes
      }
    }
    primes
  }

  def permuteAllNumbers(primes: List[Int]): HashMap[Int, List[Int]] = {
    var permutasjoner = new HashMap[Int, List[Int]]
    primes.foreach {
      a: Int =>
        var liste: List[Int] = a :: Nil
        primes.foreach {
          b: Int =>
            if (MathLib.isPermutation(a, b)) {
              liste = b :: liste
            }
        }
        permutasjoner += a -> liste
    }
    permutasjoner
  }

  def runAlterativ(): Long = {
    for (n <- 1489 until (10000-2*3330) by 2) {
      val o = (n + 3330)
      val p = (o + 3330)
      if (MathLib.isPrimeFast(n) && MathLib.isPrimeFast(o) && MathLib.isPrimeFast(p)) {
        println("3 primes: " + n + ", " + o + ", " + p)
      }
    }
    2
  }

  def run(): Long = {
    val primes = findPrimesInRange
    println("primes=" + primes)

    var permutasjoner = permuteAllNumbers(primes)
    println("Permutasjoner totalt = " + permutasjoner.size)
    println("Permutasjoner 2969 = " + permutasjoner(2969))

    permutasjoner.foreach {
      case (key, values) =>
        val sortedListOfPermutations = values.sortWith((e1, e2) => (e1 < e2))
        for (i <- 0 until sortedListOfPermutations.size - 1) {
          for (j <- i + 1 until sortedListOfPermutations.size - 1) {
            val diff = sortedListOfPermutations(j) - sortedListOfPermutations(i)
            val possibleValue = sortedListOfPermutations(j) + diff
            if (sortedListOfPermutations.contains(possibleValue)) {
              println("******* SOLUTION ********")
              println("prime=" + key + " [" + sortedListOfPermutations(i) + ", " + sortedListOfPermutations(j) + ", " + possibleValue + "]")
              println("prime=" + key + " perms=" + sortedListOfPermutations)
            }
          }
        }
    }

    permutasjoner.size
  }
}