package euler

import org.slf4j.LoggerFactory
import scala.math._

class Euler370 {

  val logger = LoggerFactory.getLogger("Euler370")

  def isGeometricTriangle(a: Long, b: Long, c: Long) = (b * b == a * c)

  val maksOmkrets = (scala.math.pow(10, 6)).toLong


  def isHeltall(tall: Double): Boolean = {
    abs(tall - floor(tall + 0.5)) < 0.00001
  }

  def litenNokOmkrets(a: Long, b: Long, c: Long): Boolean = (a + b + c) <= maksOmkrets

  def run(): Long = {
    val rangeEnkel = List.range(1, sqrt(maksOmkrets).toInt + 10)
    val rangeSqr = rangeEnkel.map(a => a * a)
    println(rangeSqr)

    //val maksOmkrets = (2.5 * scala.math.pow(10, 13)).toLong
    var a = 1
    var geometricTriangles = 0
    println("maksOmkrets/3=" + maksOmkrets/3)

    for (a <- 1 to (maksOmkrets / 3).toInt + 1) {
      //logger.info("*** A=" + a)
      rangeSqr.foreach(rangeElem => {
        val c: Long = rangeElem * a
        if (c > 0) {
          val b = scala.math.sqrt(a * c).toInt
          if (litenNokOmkrets(a, b, c)) {
            geometricTriangles += 1
            logger.info("Fant geometrisk triangel nr " + geometricTriangles + " for a=" + a + ", b=" + b + ", c=" + c)
          }
        }
      }
      )
    }
    geometricTriangles
  }
}