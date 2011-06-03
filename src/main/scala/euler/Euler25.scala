package euler

class Euler25 {
  private val fs = scala.collection.mutable.Map[Int, BigInt]()

  def run(): Long = {
    var ferdig = false
    var svar: BigInt = 0
    var n = 1
    while (!ferdig) {
      svar = fibo(n)
      println ("f(" + n + ") = " + svar)
      ferdig = svar.toString.length >= 1000
      n = n + 1
    }
    println("Fibo svar er " + svar)
    println("N er " + (n - 1));


    0
  }

  def fibo(n: Int): BigInt = {
    
    if (n == 1) {
      fs += (1 -> BigInt(1))
      return 1
    }
    if (n == 2) {
      fs += (2 -> BigInt(1))
      return 1
    }
    fs += ( n -> ( fs(n-1) + fs(n-2) ) )
    fs(n)
  }
}