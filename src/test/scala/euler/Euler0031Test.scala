package euler

import org.scalatest.FunSuite

class Euler0031Test extends FunSuite{

  val euler = new Euler31()

  test("test1Pence") {
    assert(1 == euler.numberOfSolutions(1))
  }

  test("test2Pence"){
    assert( 2 == euler.numberOfSolutions( 2 ))
  }

}
