package euler

import java.text.DecimalFormat
import java.math.{BigInteger, BigDecimal}


class Euler100 {

  def prob2Blue(blue: Long, red: Long): Double = {
    (blue.toDouble / (blue + red)) * (blue - 1) / (blue + red - 1).toDouble
  }

  def run(): Int = find(1000000000000L)._1.toInt

  def find(minTotal: Long): (Long, Long) = {
    var notFound = true
    var n = minTotal
    while (notFound) {
      //if( n%100000==0) println(s"n=${n}")
      val bigN = new BigInteger(n.toString)
      val bigNm1 = new BigInteger((n-1).toString)
      val big2N = bigN.multiply( new BigInteger("2"))
      val big2Nm1 = big2N.multiply( bigNm1 )
      val value = new BigInteger("1").add( big2Nm1 )
      //value.
      val temp = value.doubleValue()
      //val temp = 1L + (2L * n * (n - 1))
      if( temp < 0 ){
        //println(" temp=" + temp)
        System.exit(-100)
      }
      val blueD = (1.0 + Math.sqrt(temp)) / 2.0
      if (MathLib.isHeltall(blueD)) {
        val blue = blueD.toLong
        val red = (n - blue)
        //print(s"Potensiell n=${n} blå = ${blue} temp=${temp} ")
        if (prob2Blue(blue, red) > 0.040) {
          val myFormatter = new DecimalFormat("###.##")
          val bOut = myFormatter.format(blue)
          val rOut = myFormatter.format(red)
          val prob = prob2Blue(blue, red)
          val probOut = myFormatter.format(prob)
          //printf("Blue=%s red=%s\n", bOut, rOut)
          //printf(s"Prob(${blue}, ${red})=%s\n", new BigDecimal(prob).toPlainString())
          return (blue, red)
        } else {
          //println("**** Feil sannsynlighet")
          n += 1
        }
      } else {
        n += 1
      }
    }
    (-1, -1)
  }

}