package euler

import java.math.BigInteger

import org.scalatest.FunSuite

class Euler0056Test extends FunSuite {

  test("bigPow2x2") {
    assert(4 == MathLib.bigPow(2, 2))
  }

  test("tverrsumPow10x100") {
    val tall: BigInt = MathLib.bigPow(1, 100)
    assert(1 == MathLib.bigTverrsum(tall))
  }

  test("tverrsumPow100x100") {
    val tall: BigInt = MathLib.bigPow(100, 100)
    assert(1 == MathLib.bigTverrsum(tall))
  }

  test("bigTversum") {
    val bigTall: BigInt = new BigInt(new BigInteger("99"))
    val bigTverrsum: Any = MathLib.bigTverrsum(bigTall)
    assert(18 == bigTverrsum)
  }


}