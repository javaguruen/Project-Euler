package euler

/**
 * Created by IntelliJ IDEA.
 * User: Bjorn
 * Date: 11.aug.2010
 * Time: 21:14:56
 * To change this template use File | Settings | File Templates.
 */

class Euler07 {
  def run: Unit = {

    var primeCounter = 0
    var i = 3
    do {
      if (MathLib.isPrime(i)) {
        //println(i+" er et primtall, det " + (primeCounter +1) + " i rekken")
        primeCounter += 1
      }
      i += 1
    } while (primeCounter < 5)

  }

}