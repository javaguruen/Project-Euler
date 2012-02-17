package euler

import org.slf4j.LoggerFactory

class Euler40 {

  val logger = LoggerFactory.getLogger("Euler40")

  def run(): Long = {
    var builder = new StringBuilder()
    var i = 1
    while( builder.length < 1000000 ){
      builder.append(i)
      i += 1
    }
    val string = builder.toString()
    val d1 = string(1-1).toInt - '0'.toInt
    val d10 = string(10-1).toInt  - '0'.toInt
    val d100 = string(100-1).toInt - '0'.toInt
    val d1000 = string(1000-1).toInt - '0'.toInt
    val d10000 = string(10000-1).toInt - '0'.toInt
    val d100000 = string(100000-1).toInt - '0'.toInt
    val d1000000 = string(1000000-1).toInt - '0'.toInt

    d1*d10*d100*d1000*d10000*d100000*d1000000
  }
}