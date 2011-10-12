package euler


import collection.mutable.HashMap
import org.slf4j.{Logger, LoggerFactory}

class Euler94 {

  private val logger: Logger = LoggerFactory.getLogger("Euler94")

  def findSumPerimeters(): Long = {
    var sum: Long = 0
    for (i <- 2 until 500000000) {
      //400000000
      val areaOneLess = getAreaOneLess(i)
      if (isDoubleAlsoInteger(areaOneLess) && (i + i + (i - 1)) < 1000000000) {
        //if (isTriangleAlmostEqilateral(i,i,(i-1)) && ) {
        logger.info("Heltall for 2*i=" + i + " og " + (i - 1))
        sum = sum + (i + i + (i - 1))
      }
      val areaOneMore = getAreaOneMore(i)
      if (isDoubleAlsoInteger(areaOneMore) && (i + i + (i + 1)) < 1000000000) {
        //if (isTriangleAlmostEqilateral(i,i,(i-1)) && ) {
        logger.info("Heltall for 2*i=" + i + " og " + (i + 1))
        sum = sum + (i + i + (i - 1))
      }

      /*
           if (isTriangleAlmostEqilateral(i,i,(i+1)) && (i +i + (i+1))< 1000000000) {
             logger.info("Heltall for 2*i=" + i + " og " + (i+1))
              sum = sum + (i+i+(i+1))
            }
      */
    }
    sum
  }

  def getAreaOneLess(a: Int): Double = {
    ((a - 1) / 2.0) * scala.math.sqrt((3 * a * a + 2 * a - 1) / 4.0)
  }

  def getAreaOneMore(a: Int): Double = {
    ((a + 1) / 2.0) * scala.math.sqrt((3 * a * a - 2 * a - 1) / 4.0)
  }

  def isTriangleAlmostEqilateral(a: Int, b: Int, c: Int): Boolean = {
    val area: Double = MathLib.triangleAreaBySideLengths(a, b, c)
    isDoubleAlsoInteger(area)
  }

  def isDoubleAlsoInteger(d: Double): Boolean = {
    val diff: Double = scala.math.abs(d - scala.math.floor(d))
    val grense = 0.0000000001
    if (diff < grense) {
      //logger.info("double er heltall : " + d)
    }
    diff < grense
  }


  def run(): Int = {
    val sum: Long = findSumPerimeters()
    logger.info("sum = " + sum)
    sum.intValue()
  }
}