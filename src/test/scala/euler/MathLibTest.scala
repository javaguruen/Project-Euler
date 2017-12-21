package euler

import org.scalatest.FunSuite

class MathLibTest extends FunSuite {

  test("pentagonalTest") {
    // Uses ScalaTest assertions
    assert(1 == MathLib.pentagonal(1))
    assert(5 == MathLib.pentagonal(2))
    assert(40755 == MathLib.pentagonal(165))
  }

  test("triangleTest") {
    assert(1 == MathLib.triangle(1))
    assert(3 == MathLib.triangle(2))
    assert(40755 == MathLib.triangle(285))
  }

  test("hexagonalTest") {
    assert(1 == MathLib.hexagonal(1))
    assert(6 == MathLib.hexagonal(2))
    assert(15 == MathLib.hexagonal(3))
    assert(40755 == MathLib.hexagonal(143))
  }

  test("replaceStringTest") {
    val str = "9629"
    val strReplaces = str.replaceFirst("9", " ")
    //println ("replacedString=" + strReplaces)
    assert(" 629" == strReplaces)
  }

  test("fakultet0Test") {
    val fak0 = MathLib.fakultet(0)
    assert(1L == fak0)
  }

  test("primesInRangeTest") {
    val primes: List[Int] = MathLib.allPrimesInRange(6)
    assert(List(2, 3, 5) == primes)
  }

  test("isPrimeFastIncludes2") {
    assert(MathLib.isPrimeFast(3))
    assert(MathLib.isPrimeFast(2))
  }

  test("isPermutation") {
    assert(MathLib.isPermutation(2969, 9629))
  }

  test("select3from5") {
    assert(10 == MathLib.selectRfromN(3, 5))
  }

  test("palindromeTest") {
    assert(MathLib.isPalindrome(121))
    assert(MathLib.isPalindrome(2))
    assert(!MathLib.isPalindrome(12))
  }

  test("lychrelNumberTest") {
    assert(!MathLib.isLychrelNumber(3))
    assert(MathLib.isLychrelNumber(10677))
  }

  test("faktorer") {
    assert(List(1, 2, 4, 7, 14) == MathLib.properDivisors(28l).sortWith(_ < _))
    assert(List(1, 3) == MathLib.properDivisors(9))
  }

  test("triangleAreaBySideLengthsTest") {
    assert(12 == MathLib.triangleAreaBySideLengths(5, 5, 6))
  }
  test("64 er kvadrattall") {
    assert(MathLib.isSquareNumber(64))
  }

  test("4 er kvadrattall") {
    assert(MathLib.isSquareNumber(4))
  }

  test("5 er ikke kvadrattall") {
    assert(!MathLib.isSquareNumber(5))
  }

  test("63 er ikke kvadrattall") {
    assert(!MathLib.isSquareNumber(63), "Skal være kvadrattall")
  }

}