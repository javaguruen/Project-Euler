package euler

class Euler53 {


  def velgAlleTall(maxR: Int, maxN: Int) : List[BigInt] = {
    assert(maxR <= maxN)
    var list :  List [BigInt] = Nil

    for (n <- 1 to maxN) {
      for (r <- 1 to scala.math.min(n, maxR)) {
        list ::= MathLib.selectRfromN(r, n)
      }
    }

    list
  }

  def run() : Int = {
    val maxN = 100
    val maxR = 100

    val utvalg = velgAlleTall(maxR, maxN)
    println ("Antall elementer på C(", maxR + ", " + maxN + ")=" + utvalg.size)
    val negativ = utvalg.filter( _ <= 0)
    println ("Antall negative = " + negativ.size)

    val overMill = utvalg.filter( _ >= 1000000)
    //println (overMill)
    overMill.size
  }

}