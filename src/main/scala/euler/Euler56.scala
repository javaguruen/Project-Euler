package euler

import java.math.BigInteger

class Euler56 {
  def run(): Int = {
    val maks = 100
    var maxTverrsum = 0
    val bigZero = new BigInt( new BigInteger("0"))
    for (base <- 1 until maks) {
      for (exponent <- 1 until maks) {
        val produkt = MathLib.bigPow(base, exponent)
        if  (produkt <  bigZero){
          println("******  negativt produkt *********")
        }
        val tverrsum = MathLib.bigTverrsum(produkt)
        if  ( tverrsum > maxTverrsum ){
          println(base + " opphøyd i " + exponent + " = " + produkt)
          println("tverrsummen = " + tverrsum )
          maxTverrsum = tverrsum
        }
      }
    }
    maxTverrsum
  }
}

