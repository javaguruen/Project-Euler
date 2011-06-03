package euler

import java.math.BigInteger

class Euler20 {
  def run(): Long = {
    var hundre  : BigInt = MathLib.fakultet(100);
    println(hundre + " " + MathLib.tverrsum(hundre.toString))
    0
  }
}