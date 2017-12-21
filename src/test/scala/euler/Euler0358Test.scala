package euler

import org.junit.Assert.{assertEquals, assertTrue}
import org.scalatest.FunSuite


class Euler0358Test extends FunSuite{
  val euler358 = new Euler358()

  test("testPadding") {
      val secretAgent = euler358.padNumber(7,3)
      assertEquals( "007", secretAgent )
    }

  test("cyclic142857"){
    val number = "142857"
    val rotation: List[String] = euler358.findAllRotation(number)
    val isCyc: Boolean = euler358.isCyclic(BigInt(number), rotation)
    assertTrue( isCyc )
  }

  test("rotations"){
    val rotations: List[String] = euler358.findAllRotation("142857")
    rotations.foreach(s => println(s))
  }

  test("testStrip") {
    val toStrip = "003"
    val stripped = euler358.removeLeadingZeros(toStrip)
    assertEquals("3", stripped)
  }
}