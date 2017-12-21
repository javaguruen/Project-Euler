package euler

import org.scalatest.FunSuite

class Euler0094Test extends FunSuite {
  val euler94 = new Euler94()


  test("areaOf556") {
    assert(12 === euler94.getAreaOneMore(5))
  }

}