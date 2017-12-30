package euler

import org.scalatest.FunSuite

class Euler0043Test extends FunSuite {
  test("List.permutations"){
    val perms = List(1, 2, 3).permutations
    assert (perms.size == 6)
  }

  test("character list permutations"){
    val perms = List('0', '1', '2').permutations.toList
    assert (perms.size == 6)
    val s = perms.map( l => l.mkString(""))
    //println(s)
  }
}
