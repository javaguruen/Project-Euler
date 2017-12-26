package euler

import scala.io.Source

class Euler13 {

  def run(): Long = {
    var sum = BigInt(0)
    val iterator: Iterator[_root_.scala.Predef.String] = Source.fromFile("euler13.txt").getLines
    while( iterator.hasNext ){
      val tallString = iterator.next
      val tall = BigInt(tallString)
      sum += tall
    }
    0L
  }
}