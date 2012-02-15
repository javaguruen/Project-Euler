package euler

import org.slf4j.LoggerFactory
import scala.math._

class Euler370BF {
    val logger = LoggerFactory.getLogger("Euler370BF")

    def isGeometricTriangle(a: Long, b: Long, c: Long)= (b*b==a*c)
    def isHeltall(tall: Double): Boolean = {
       abs(tall - floor(tall + 0.5)) < 0.00001
     }

    def run(): Long = {
      val maksOmkrets = (pow(10, 6)).toInt
      //val maksOmkrets = (2.5 * scala.math.pow(10, 13)).toLong
      var a = 1
      var c = 1
      var geometricTriangles = 0

      for (a <- 1 to (maksOmkrets/3).toInt ) {
        logger.info("*** A=" + a + ", antall funnet=" + geometricTriangles)
          for (c <- a to maksOmkrets-2*a ) {
            val b = scala.math.sqrt(a*c)
            if( isHeltall( b ) && (a+b.toLong+c <= maksOmkrets)){
                geometricTriangles += 1
                //logger.info("Fant geometrisk triangel nr " + geometricTriangles + " for a=" + a + ", b=" + b + ", c="+c)
            }
          }
        }

      geometricTriangles
    }
  }
