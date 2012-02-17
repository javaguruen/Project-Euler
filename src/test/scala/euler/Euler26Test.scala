package euler

import org.junit.Test
import java.util.{Calendar, GregorianCalendar}

class Euler26Test {

  var euler26 = new Euler26()


  @Test
  def test1div6() {
    val tall = "0.16666666666"
    assert(true == euler26.detectSingleCycle(3, 1, tall))
  }

  @Test
  def test1div7() {
    val tall = "0.142857142857142857142857142857142857142857142857142857"
    assert(true == euler26.detectSingleCycle(2, 6, tall))
    assert(false == euler26.detectSingleCycle(2, 4, tall))
  }

  @Test
  def test1div7Cycle() {
    val tall = "0.142857142857142857142857142857142857142857142857142857"
    assert(6 == euler26.detectCycle(tall))
  }

}