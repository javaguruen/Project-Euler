package euler

import org.scalatest.FunSuite

class Euler0026Test extends FunSuite{

  var euler26 = new Euler26()


  test("test1div6") {
    val tall = "0.16666666666"
    assert(euler26.detectSingleCycle(3, 1, tall))
  }

  test("test1div7") {
    val tall = "0.142857142857142857142857142857142857142857142857142857"
    assert(euler26.detectSingleCycle(2, 6, tall))
    assert(!euler26.detectSingleCycle(2, 4, tall))
  }

  test("test1div7Cycle"){
    val tall = "0.142857142857142857142857142857142857142857142857142857"
    assert(6 == euler26.detectCycle(tall))
  }

}