package euler

import org.scalatest.FunSuite

class RomanNummeralsTest extends FunSuite {

  test("Rom2Des") {
    val des = RomanNummerals.romertall2tall("CMLXIX")
    assert(des == 969)
    val des2 = RomanNummerals.romertall2tall("MMXXVIII")
    assert(des2 == 2028)
  }

  test("konvertering") {
    val romertall = RomanNummerals.convert(2399)
    assert(romertall == "MMCCCXCIX")
    val romertall49 = RomanNummerals.convert(49)
    assert(romertall49 == "XLIX")
  }
}
