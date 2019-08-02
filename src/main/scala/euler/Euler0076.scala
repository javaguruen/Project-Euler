package euler

import scala.annotation.tailrec


class Euler0076 extends Slf4jLogger {
  val max = 100
  val maxHalf: Int = max / 2

  var series = Map(1 -> Set(List[Int](1)))

  def run(): Long = {
    for (n <- 2 to max) {
      logger.info(s"##############\nCalculating $n")
      logger.info(s"Map is \n$series")
      something(n)
    }

    val combinations = series(max)
    println(s"#################\n${combinations}\nsize: ${combinations.size}")
    1
  }

  def sort(list: List[Int]): List[Int] = {
    list.sortWith((a, b) => a < b)
  }

  def getCombos(iSet: Set[List[Int]], jSet: Set[List[Int]]): Set[List[Int]] = {
    val is = for (i <- iSet; j <- jSet)
      yield sort(i ::: j)
    val js = for (j <- jSet; i <- iSet)
      yield sort(j ::: i)
    (is ++ js)
  }

  def something(n: Int) = {
    var temp = Set[List[Int]]()

    for (i <- n - 1 to n / 2 by -1) {
      logger.info(s"\nA combo is $i + ${n - i}")
      val current = sort(List(i, n - i))
      var iSet: Set[List[Int]] = series.get(i).get
      var jSet = series.get(n - i).get

      val combos = getCombos(iSet, jSet) + current
      temp ++= combos
    }
    series += (n -> temp)
  }
}

class Euler076Take2 {

  def findSeries(target: Int): Int = {
    var c = 0
    Range.inclusive(target-1, 1, -1).foreach{ i =>
      println(s"i == $i")
      c += findSubSeries(target - i, i, 0)
    }

    @tailrec
    def findSubSeries(rest: Int, max: Int, count: Int): Int ={
      /*if( rest == 1 ) {
        //Sum med +1 er eneste valg
        count + 1
      } else*/ if( rest == 0 ) {
        //Ikke flere kombinasjoner
        count
      }
      else if (max == 1) {
        //Bare rekke med +1 er mulig
        count + 1
      } else if (rest > max) {
        findSubSeries(rest - max, max, count)
      } else if (rest == max) {
        findSubSeries(rest, max - 1, count + 1)
      } else {
        findSubSeries(rest, max - 1, count)
      }
    }

    println(s"Target = $target, combos = $c")
    c
  }
}