package euler

import org.slf4j.LoggerFactory
import scala.math._

//796340
//796693

//==> 861805
class Euler370 {

  val logger = LoggerFactory.getLogger("Euler370")

  def isGeometricTriangle(a: Long, b: Long, c: Long) = (b * b == a * c)

  val maksOmkrets = (scala.math.pow(10, 6)).toLong

  def litenNokOmkrets(a: Long, b: Long, c: Long): Boolean = {
    if (a <= 0 || b <= 0 || c <= 0) {
      throw new Exception("litenNokOmkrets overflow")
    }
    (a + b + c) <= maksOmkrets
  }

  def run(): Long = {
    println("Doing the rangemaking")
    val rangeEnkel = List.range(1, sqrt(maksOmkrets).toInt + 100)
    val rangeSqr = rangeEnkel.map(a => BigInt(a) * BigInt(a))
    println("...done")
    println("Maks in range=" + rangeSqr(rangeSqr.size - 1))

    //val maksOmkrets = (2.5 * scala.math.pow(10, 13)).toLong
    var a = 1
    var geometricTriangles = 0
    for (a <- 1 to (maksOmkrets / 3).toInt + 100) {
      logger.debug("*** A=" + a)
      rangeSqr.foreach(rangeElem => {
        if (rangeElem <= 0) {
          throw new Exception("rangeElem overflow")
        }
        val c = rangeElem * a
        if (c <= 0) {
          throw new Exception("C overflow: a=" + a + ", rangeElem=" + rangeElem)
        }
        if (c > 0) {
          val cTimesA: BigInt = c * a
          if (cTimesA <= 0) {
            throw new Exception("C*a overflow: a=" + a + ", c=" + c)
          }
          val b = scala.math.sqrt(cTimesA.toLong).toLong
          if (litenNokOmkrets(a, b, c.longValue())) {
            geometricTriangles += 1
            logger.debug("Fant geometrisk triangel nr " + geometricTriangles + " for a=" + a + ", b=" + b + ", c=" + c)
          }
        }
      }
      )
      if (!rangeSqr.contains(a) && litenNokOmkrets(a, a, a)) {
        geometricTriangles += 1
        logger.debug("Fant geometrisk triangel nr " + geometricTriangles + " for a=b=c=" + a )
      }
    }
    geometricTriangles
  }
}