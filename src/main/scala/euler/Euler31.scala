package euler

import org.slf4j.LoggerFactory

class Euler31 {

  object Coins {
    def apply(p1: Int, p2: Int, p5: Int, p10: Int, p20: Int, p50: Int, p100: Int, p200: Int): Coins =
      new Coins(p1, p2 / 2, p5 / 5, p10 / 10, p20 / 20, p50 / 50, p100 / 100, p200 / 200)
  }

  case class Coins(p1: Int, p2: Int, p5: Int, p10: Int, p20: Int, p50: Int, p100: Int, p200: Int)


  val logger = LoggerFactory.getLogger("Euler31")

  def run(): Long = {
    val target = 200
    val possibilities =
      for (
        p200 <- 0 to target by 200;
        p100 <- 0 to (target-p200) by 100;
        p50 <- 0 to (target-p200-p100) by 50;
        p20 <- 0 to (target-p200-p100-p50) by 20;
        p10 <- 0 to (target-p200-p100-p50- p20) by 10;
        p5 <- 0 to (target-p200-p100-p50- p20-p10) by 5;
        p2 <- 0 to (target-p200-p100-p50- p20-p10-p5) by 2;
        p1 <- 0 to (target-p200-p100-p50- p20-p10-p5-p2) by 1;
        if (List(p1, p2, p5, p10, p20, p50, p100, p200).sum == target))
        yield Coins(p1, p2, p5, p10, p20, p50, p100, p200)
    println(possibilities.toList)

    possibilities.size
  }

  def numberOfSolutions(pence: Int): Int = {
    var rest = pence
    var solutions = 0
    if (rest == 1) {
      solutions += 1
      return solutions
    }
    if (rest == 2) {
      solutions += 2

    }
    if (rest > 2) {
      solutions += 1
      solutions += numberOfSolutions(rest - 2)
    }
    solutions
  }
}