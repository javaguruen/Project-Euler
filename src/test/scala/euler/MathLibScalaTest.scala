package euler

import org.junit.Test
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class MathLibScalaTest extends FunSuite{

  test("64 er kvadrattall"){
    assert(MathLib.isSquareNumber(64) )
  }

  test("4 er kvadrattall"){
    assert(MathLib.isSquareNumber(4) )
  }

  test("5 er ikke kvadrattall"){
    assert(!MathLib.isSquareNumber(5) )
  }

  test("63 er ikke kvadrattall"){
    assert( !MathLib.isSquareNumber(63) , "Skal være kvadrattall")
  }

}