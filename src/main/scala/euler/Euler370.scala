package euler

import org.slf4j.LoggerFactory


class Euler370 {

  val logger = LoggerFactory.getLogger("Euler370")

  def isGeometricTriangle(a: Long, b: Long, c: Long)= (b*b==a*c)

  def run(): Long = {
    val maksOmkrets = (scala.math.pow(10, 6)).toLong
    //val maksOmkrets = (2.5 * scala.math.pow(10, 13)).toLong
    var a = 1
    var b = 1
    var c = 1
    var geometricTriangles = 0

    for (a <- 1 to (maksOmkrets/3).toInt ) {
      logger.info("*** A=" + a)
      for (b <- a to maksOmkrets.toInt ) {
        if( b % 10000 == 0) logger.info("****** B=" + b)
        for (c <- b to b*b ) {
          if( a+b+c <= maksOmkrets){
            if( isGeometricTriangle(a, b, c) ){
              geometricTriangles += 1
              logger.info("Fant geometrisk triangel nr " + geometricTriangles + " for a=" + a + ", b=" + b + ", c="+c)
            }
          }
        }
      }
    }

    geometricTriangles
  }
}