package euler

import org.scalatest.FunSuite

class Euler0093Test extends FunSuite {
  val euler93 = new Euler93()


  test("nextInCharn44") {
    assert(32 === euler93.sumOfSquaredSiffers(44))
  }

  test("nextInCharn85") {
    assert(89 === euler93.sumOfSquaredSiffers(85))
  }

  test("nextInCharn1") {
    assert(1 === euler93.sumOfSquaredSiffers(1))
  }

  test("chainEndsWith89_145") {
    assert(true === euler93.chainEndsWith89(145))
  }

  test("chainEndsWith1_44") {
    assert(false === euler93.chainEndsWith89(44))
  }
}