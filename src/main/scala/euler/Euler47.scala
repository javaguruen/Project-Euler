package euler

class Euler47 {
  private var primes : List[Int] = 1 :: Nil


  def run(): Long = {
    var consecutiveCount = 0;
    for (n <- 1 until 10000000 ){

      val list = MathLib.properDivisorsScala(n)
      val filteredlist = list.filter(n => MathLib.isPrimeFast(n) || n==2)
      if (filteredlist.size == 4) {
        consecutiveCount +=1
        if (consecutiveCount == 4) {
          println(consecutiveCount + " consecutive prime factor numbers for n: " +n)
          return n
        }
      } else {
        consecutiveCount = 0
      }
      if (filteredlist.size == 4)
        println (n+": " + filteredlist)
    }

    0
  }

 
}