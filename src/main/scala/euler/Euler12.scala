package euler

class Euler12 {
  def run(): Long = {
    val maks = 500
    var factorCount = 0
    var i : Long = 1
    var triangle : Long = 0
    var maksFactorCount = 0
    do {
      triangle = MathLib.triangleNumber(i)
      factorCount = MathLib.allFactors(triangle).size + 2
      maksFactorCount = scala.math.max(maksFactorCount, factorCount)
      //println("Maks: " + maksFactorCount + " i: " + i + " Triangeltall: " + triangle + " har antall faktorer " + factorCount)
      i += 1
    } while (factorCount < maks)
    triangle
  }
}