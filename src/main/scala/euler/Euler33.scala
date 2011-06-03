package euler

import collection.mutable.HashSet

object Euler33 {
  def main(args: Array[String]): Unit = {
    val hw = new Euler33()
    hw.run
  }
}

class Euler33 {


  def run(): Long = {
    var sum: Int = 0
    val theSet = new HashSet[Int]

    for (nevner <- 11 until 100) {
      for (teller <- 10 until nevner) {
        if (teller % 10 != 0) {
          val originalBroek: Double = teller / nevner.doubleValue
          val redusertBroek = reduserBroek(teller, nevner)
          if (originalBroek == redusertBroek) {
            println(teller + "/" + nevner + " == " + originalBroek)
            theSet.add(nevner)
          }
        }
      }
    }
    
    0
  }

  def reduserBroek(teller: Int, nevner: Int): Double = {
    var tellerS = teller.toString
    var nevnerS = nevner.toString
    if (nevnerS.contains(tellerS(0))) {
      nevnerS = nevnerS.replaceFirst(tellerS(0).toString, "").trim
      tellerS = tellerS.replaceFirst(tellerS(0).toString, "").trim
    }
    else if (nevnerS.contains(tellerS(1))) {
      nevnerS = nevnerS.replaceFirst(tellerS(1).toString, "").trim
      tellerS = tellerS.replaceFirst(tellerS(1).toString, "").trim
    }

    if (tellerS.size == 2) {
      return -1.0
    }
    else {
      return tellerS.toDouble / nevnerS.toDouble
    }

  }
}