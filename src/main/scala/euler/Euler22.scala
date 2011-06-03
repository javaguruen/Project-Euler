package euler

import io.Source
import collection.immutable.TreeSet

class Euler22 {
  def run(): Long = {
    var sum = BigInt(0)

    val myOrdering = Ordering.fromLessThan[String](_ < _)
    var navneliste: TreeSet[String] = TreeSet.empty(myOrdering)

    val iterator: Iterator[_root_.scala.Predef.String] = Source.fromFile("euler22.txt").getLines
    while (iterator.hasNext) {
      val navn = iterator.next
      println(navn)
      navneliste = navneliste.insert(navn)
    }

    println("-------------")
    var i = 1
    var sumTilNaa : Int = 0
    navneliste.foldLeft(0) {
      (previous, index) => {
        var score = scoreName( index ) * i
        i += 1
        sumTilNaa = previous + score
        sumTilNaa
      }
    }
    println (sumTilNaa)
    sumTilNaa
  }

  def scoreName(name: String): Int = {
    name.toList.foldLeft(0) { _ + _.toInt - 'A'.toInt + 1}
  }
}