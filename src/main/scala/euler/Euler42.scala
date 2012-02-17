package euler

import org.slf4j.LoggerFactory
import io.Source

class Euler42 {

  val logger = LoggerFactory.getLogger("Euler42")

  def numberfy(string: String): Int = {
    string.foldLeft( 0 )( (sum, s) => sum + (s.toInt - 'A'.toInt) + 1)
  }

  def maks(tall: Array[Int]): Int = {
    tall.foldLeft( 0 )( (maks, t) => scala.math.max(maks, t))
  }

  def run(): Long = {
    var raw : String = readFile()
    raw = raw.replaceAll("\"","")
    val wordList = raw.split(",")
    val numberList = wordList.map( s =>  numberfy(s) )
    val maksTall = maks( numberList )
    var triangleNumbers : List[Int] = Nil
    var triangle = 0
    var i=1
    while(  triangle < maksTall ){
      triangle = (i*(i+1)/2)
      triangleNumbers ::= triangle
      i += 1
    }
    val erTriangleTall = numberList.filter( t => triangleNumbers.contains( t ))
    erTriangleTall.size

  }

  def readFile() : String = {
    val iterator: Iterator[_root_.scala.Predef.String] = Source.fromFile("src\\main\\resources\\words.txt").getLines
        while( iterator.hasNext ){
          return iterator.next()
        }
    ""
  }
}