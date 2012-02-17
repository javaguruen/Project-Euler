package euler

import org.slf4j.LoggerFactory
import io.Source

class Euler89 {

  val logger = LoggerFactory.getLogger("Euler89")

  def run(): Long = {
    val romanWorst: List[String] = readFile()
    val desimalTalliste = romanWorst.map( r => RomanNummerals.romertall2tall(r))
    val romanBest = desimalTalliste.map( d => RomanNummerals.convert( d ))
    var charSaved = 0
    for( i<- 0 until romanWorst.size ){
      val saved = romanWorst(i).size - romanBest(i).size
      logger.info(i + ": " + romanWorst(i) + " = " + RomanNummerals.romertall2tall( romanWorst(i) ) + " = " + romanBest(i) + " diff=" + saved)
      if( saved < 0) throw new Exception("Feil konvertering for worst=" + romanWorst(i) + " til best " + romanBest(i))
      charSaved += saved
    }
    charSaved
  }

  def readFile(): List[String] = {
    var romertalliste : List[String]  = Nil
    val iterator: Iterator[_root_.scala.Predef.String] = Source.fromFile("src/main/resources/roman.txt").getLines
    while (iterator.hasNext) {
      val romertall = iterator.next
      romertalliste ::= romertall
    }
    romertalliste
  }
}