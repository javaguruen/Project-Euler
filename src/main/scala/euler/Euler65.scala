package euler

class Euler65 {

  val pattern = makePattern(33)
  val maksantall = 5

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
    for (i <- 1 to maksantall) {
      val (eTeller, eNevner) = conv(i);
      println("c(" + i + "): e = " + eTeller + " / " + eNevner)
    }
    1
  }

  def conv(maksantall: Int): (Long, Long) = {
    if (maksantall == 1) {
      return (pattern(1), 1)
    }
    val (teller, nevner) = (1, pattern(maksantall))
    return convRek(maksantall - 1, teller, nevner);
  }

  def convRek(i: Int, teller: Long, nevner: Long): (Long, Long) = {
    val pattern_i: Long = pattern(i)
    if (i == 1) {
      return (pattern_i * nevner + teller, nevner)
    }
    if (i == maksantall - 1) {
      val t = pattern_i * nevner + teller
      val n = nevner
      return convRek(i - 1, n, t)
    }
    else {
      val t = pattern_i * nevner + 1
      val n = nevner
      return convRek(i - 1, n, t)
    }
  }


  def convBroek(cnr: Int, maksantall: Int): (Long, Long) = {
    if (1 == maksantall) {
      return (pattern(maksantall), 1)
    }
    if (cnr == maksantall) {
      var teller = pattern(cnr - 1) * pattern(cnr) + 1
      var nevner = pattern(cnr)
      //prLongln("maks-> 1 / " + nevner)
      return (1, nevner)
      //return ( pattern(maksantall-1) + 1, pattern(maksantall))
    }
    /*
        if (cnr == 1) {
          val (tt, nn) = convBroek(cnr + 1, maksantall)
          return (2*nn+tt, nn)
        }
    */
    if (cnr < maksantall) {
      val (tt, nn) = convBroek(cnr + 1, maksantall)
      //      var teller =
      return (nn, pattern(cnr) * nn + 1)
    }
    /*
        if( cnr == maksantall) {
          return 1.0 / pattern(cnr)
        }
        else{
          return 1.0 / ( pattern(cnr) + conv( cnr+1, maksantall ) )
        }
    */ (-1, -1)
  }

  /*
    def conv(cnr: Int, maksantall: Int): Double = {
      if (cnr == maksantall) {
        return 1.0 / pattern(cnr)
      }
      else {
        return 1.0 / (pattern(cnr) + conv(cnr + 1, maksantall))
      }
    }
  */
}