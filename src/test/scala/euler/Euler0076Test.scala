package euler

import org.scalatest.FunSuite

class Euler0076Test extends FunSuite {
  test("Sorting array") {
    val euler = new Euler0076
    assert(euler.sort(List(3, 2, 5)) == List(2, 3, 5))
  }

  test("adding sets") {
    val euler = new Euler0076
    assert(euler.getCombos(Set(List(1, 2), List(1, 1, 1)), Set(List(1, 1, 1))) == Set(List(1, 1, 1, 1, 2), List(1, 1, 1, 1, 1, 1)))
  }

  test("T2 find series") {
    val euler = new Euler076Take2()
    assert(6 == euler.findSeries(5))
    //assert(10 == euler.findSeries(6))
    assert(14 == euler.findSeries(7))
    assert(21 == euler.findSeries(8))
    assert(29 == euler.findSeries(9))
  }
}
