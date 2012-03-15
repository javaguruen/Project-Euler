package euler

import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue


class Euler358Test {
  val euler358 = new Euler358()

  @Test
    def testPadding() {
      val secretAgent = euler358.padNumber(7,3)
      assertEquals( "007", secretAgent )
    }

  @Test
  def cyclic142857(){
    val number = "142857"
    val rotation: List[String] = euler358.findAllRotation(number)
    val isCyc: Boolean = euler358.isCyclic(BigInt(number), rotation)
    assertTrue( isCyc )
  }

  @Test
  def rotations() {
    val rotations: List[String] = euler358.findAllRotation("142857")
    rotations.foreach(s => println(s))
  }

  @Test
  def testStrip() {
    val toStrip = "003"
    val stripped = euler358.removeLeadingZeros(toStrip)
    assertEquals("3", stripped)
  }
}