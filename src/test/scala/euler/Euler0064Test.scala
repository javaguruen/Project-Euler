package euler

import org.scalatest.{BeforeAndAfter, FunSuite}

class Euler0064Test extends FunSuite with BeforeAndAfter {
  var euler : Euler64 = _

  before{
    euler = new Euler64()
  }

  test("Pattern 2"){
    val p = euler.pattern(2)
    assert(p._1 === 1, "Heltall")
    assert(p._2 === List(2), "pattern")
    assert(p._3 === 1, "periode")
  }

  test("Pattern 3"){
    val p = euler.pattern(3)
    assert(p._1 === 1, "Heltall")
    assert(p._2.reverse === List(1,2), "pattern")
    assert(p._3 === 2, "periode")
  }

  test("Antall odde 13"){
    assert( euler.numberOfOddPeriods(13) === 4)
  }

  test("Antall odde 10000"){
    assert( euler.numberOfOddPeriods(10000) === 1322)
  }

  test("Pattern 13"){
    val p = euler.pattern(13)
    assert(p._1 === 3, "Heltall")
    assert(p._2.reverse === List(1,1,1,1,6), "pattern")
    assert(p._3 === 5, "periode")
  }

  test("Største heltall for 23 er 4"){
    assert(euler.heltallet(23) === 4 )
  }
}
