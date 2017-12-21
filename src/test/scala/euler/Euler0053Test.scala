package euler

import org.scalatest.FunSuite

class Euler0053Test extends FunSuite{

  test("fakultet0Test"){
    val fak0 = MathLib.fakultet(0)
    assert( 1L == fak0)
  }

  test("select10from23Test"){
    assert( 1144066 == MathLib.selectRfromN(10, 23))
  }

  test("antallUtvalg3fra5Test"){
    val euler53 = new Euler53
    assert( 12 == euler53.velgAlleTall(3, 5).size)
  }

  test("utvalg2fra2Test"){
    val euler53 = new Euler53
    assert( List(1, 1, 2) == euler53.velgAlleTall(2, 2).sortWith( (a, b) => a<b).map(_.longValue()))
  }

  test("utvalg4fra4Test"){
    val euler53 = new Euler53
    assert( List(1, 2, 3, 4 , 1, 3, 6, 1, 4, 1 ).sortWith((a,b) => a < b) === euler53.velgAlleTall(4, 4).sortWith( (a, b) => a<b))
  }

}