package euler

import org.junit.{Ignore, Test}
import org.slf4j.{LoggerFactory, Logger}

class Euler243Test {
  private val logger: Logger = LoggerFactory.getLogger("Euler243")

  @Test
  def isResilience12() {
    val target: Double = 4.0 / 10.0
    val euler243 = new Euler243
    assert( euler243.resilience(12, target) )
  }
}