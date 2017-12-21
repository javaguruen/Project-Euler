package euler

import org.scalatest.FunSuite

class Euler0058Test extends FunSuite {
  val euler58 = new Euler58()


  test("antallPrimtallIListe") {
    assert(5 == euler58.antallPrimtall(List(1, 3, 5, 7, 9, 2, 0, 4)))
  }


  test("incrementalFor4") {
    assert(4 == euler58.getIncrementByPreviousSideLength(3))
  }

  test("getDiagonalValuesForSidelength3") {
    assert(List(3, 5, 7, 9) == euler58.getDiagonalValuesForSidelengthGivenStartValue(3, 1))
  }

  test("getDiagonalValuesForSidelength5") {
    assert(List(13, 17, 21, 25) == euler58.getDiagonalValuesForSidelengthGivenStartValue(5, 9))
  }


}