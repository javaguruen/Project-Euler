package euler

class Euler65 {

  val pattern = makePattern(33)
  val maksantall = 100

  def makePattern(antallMoenster: Int): Array[Long] = {
    val p = new Array[Long](1 + 3 * antallMoenster + 1)
    p(0) = -1
    p(1) = 2
    for (i <- 0 until antallMoenster) {
      p(2 + i * 3) = 1
      p(2 + i * 3 + 1) = 2 * (i + 1)
      p(2 + i * 3 + 2) = 1
    }
    p
  }


  def printPattern {
    for (i <- 0 until pattern.size) {
      print(pattern(i) + ", ")
    }
    println("\n")
  }

  def run(): Long = {
    printPattern
    var (t, n) = ( BigInt(0), BigInt(0) )
    for (i <- 1 to maksantall) {
      val (eTeller, eNevner) = conv(i);
      println("c(" + i + "): e = " + eTeller + " / " + eNevner)
      if( i==maksantall){
        t = eTeller
        n = eNevner
      }
    }
    val tverrsum = t.toString().foldLeft(0){ (sum, e) => sum +  e.toInt - '0'.toInt}
    println("Tverrsum = " + tverrsum)
    tverrsum
  }

  def conv(m: Int): (BigInt, BigInt) = {
    if (m == 1) {
      return ( BigInt(pattern(1)), BigInt(1) )
    }
    var (teller , nevner) = convRek(2, m)
    return (nevner * BigInt(2) + teller, nevner)
  }

  def convRek(i: Int, m : Int): (BigInt, BigInt) = {
    val pattern_i: Long = pattern(i)
    if (i == m ) {
      val t = 1
      val n = pattern_i
      return (BigInt(t), BigInt(n) )
    }
    else {
      val (teller, nevner) = convRek(i+1, m)
      val t = nevner
      val n = nevner*pattern_i + teller
      return (t,n)
    }
  }
}