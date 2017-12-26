package euler

import org.scalatest.FunSuite

class Euler0021Test extends FunSuite {
  val euler21 = new Euler21()

  test("d1") {
    val devisorer = MathLib.properDivisors(1L)
    assert(devisorer.size == 1)
    assert(devisorer.contains(1))
  }

  test("d2"){
    val devisorer = MathLib.properDivisors(2)
    assert( devisorer.size == 2 )
    assert( devisorer.contains( 2 ) )
  }

  test("d3"){
    val devisorer = MathLib.properDivisors(3)
    assert( devisorer.size == 1 )
    assert( devisorer.contains( 1 ) )
  }

  test("d4") {
    val devisorer = MathLib.properDivisors(4)
    assert( devisorer.size == 2 )
    assert( devisorer.contains( 1 ) )
    assert( devisorer.contains( 2 ) )
  }

  test("d6"){
    val devisorer = MathLib.properDivisors(20)

    assert( devisorer.contains(1))
    assert( devisorer.contains(2))
    assert( devisorer.contains(5))
    assert( devisorer.contains(10))
  }
}
