package euler


class Euler0087 {


  def run(): Long = {
    val sumLimit: Int = 50000000
    var primes: List[Long] = MathLib.sieve( Math.sqrt(sumLimit).intValue()).map(_.longValue())
    val squares = primes.map(n => n * n).takeWhile( s => s < sumLimit)
    val cubes = primes.map(n => n * n * n).takeWhile( s => s < sumLimit)
    val forths = primes.map(n => n * n * n * n).takeWhile( s => s < sumLimit)

    println(s"Squares: ${squares.size}")
    println(s"Cubes: ${cubes.size}")
    println(s"Forths: ${forths.size}")

    println("Getting combos")
    val combos = for (s <- squares;
                      c <- cubes;
                      f <- forths if s + c + f < sumLimit)
      yield (s + c + f)
    println(s"Number of combos: ${combos.size}")
    val uniqueNumbers = combos.toSet.size
    println(s"Number of distinct numbers: ${uniqueNumbers}")
    uniqueNumbers
  }

}
