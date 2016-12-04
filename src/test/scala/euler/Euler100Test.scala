package euler

import org.scalatest.{BeforeAndAfter, FunSuite}
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class Euler100Test extends FunSuite with BeforeAndAfter {
  var euler : Euler100 = _

  before{
    euler = new Euler100()
  }

  test("2 0"){
    val p = euler.prob2Blue(2,0)
    assert(p === 1.0)
  }

  test("15 6"){
    val p = euler.prob2Blue(15,6)
    assert(p === 0.5)
  }

  test("85 35"){
    val p = euler.prob2Blue(85,35)
    assert(p === 0.5)
  }

  test("Find 15 6 min 5"){
    val p  = euler.find(5)
    assert(p._1 === 15)
  }

  test("Find 85 35 min 80"){
    val p  = euler.find(80)
    assert(p._1 === 85)
  }

  test("Er heltall n=1001549160045"){
    val n=1001549160045L
    val utregning = (1.0+ Math.sqrt(1 + (n*(n-1))))/2.0
    assert( MathLib.isHeltall( utregning ))
  }
}
