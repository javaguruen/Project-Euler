package euler

import org.scalatest.FunSuite


class Euler0057Test extends FunSuite {
  val euler = new Euler0057

  test("expand 1") {
    assert( euler.run(1) == euler.Fraction(3, 2))
  }

  test("expand 2") {
    assert( euler.run(2) == euler.Fraction(7, 5))
  }

  test("expand 3") {
    assert( euler.run(3) == euler.Fraction(17, 12))
  }

  test("expand 4") {
    assert( euler.run(4) == euler.Fraction(41, 29))
  }

}
