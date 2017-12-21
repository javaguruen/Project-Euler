package euler

import org.scalatest.FunSuite

class Euler0060Test extends FunSuite {
  val euler60 = new Euler60()


  test("erPrimtall") {
    assert(euler60.isPrime(5))
  }
}
