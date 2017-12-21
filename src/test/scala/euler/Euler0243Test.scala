package euler

import org.scalatest.FunSuite
import org.slf4j.{Logger, LoggerFactory}

class Euler0243Test extends FunSuite{
  val logger: Logger = LoggerFactory.getLogger("Euler243")

  test("isResilience12"){
    val target: Double = 4.0 / 10.0
    val euler243 = new Euler243
    assert( euler243.resilience(12, target) )
  }
}