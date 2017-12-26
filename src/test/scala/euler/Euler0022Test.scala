package euler

import org.scalatest.FunSuite


class Euler0022Test extends FunSuite{
  val euler22 = new Euler22()

  test("scoreNameBA"){
     val score = euler22.scoreName("BA")
     assert( 3 == score )
  }
}
