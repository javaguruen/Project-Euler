package euler


class Euler46 {
  private var primes : List[Int] = 1 :: Nil


  def run(): Long = {
    for (n <- 3 until 100000 by 2){
      if( MathLib.isPrimeFast( n )){
        primes = n :: primes;
        println ( n + " is prime")
      }
      else{
        if( !isGoldbachComposite(n)){
          println(n + " is not a Goldbach composite for N= " + n)
          return n
        }
      }

    }

    0
  }

  def isGoldbachComposite( number : Int) : Boolean = {
    for ( n <- primes) {
      val diff = Math.sqrt((number - n)/2);
//      println ("Diff is "+ diff)
      if (diff - diff.intValue < 0.00001) {
        println(number +"=" + n + " + 2 * sqr( " +diff + " ) ")
        return true
      }
    }
    

    false
  }
}