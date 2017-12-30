package euler

class Euler0043 {

  def divisibleBy(number: String, divisor: Int): Boolean = {
    //println(s"$number / $divisor")
    number.toInt % divisor == 0
  }

  def run(): Long = {
    val start = System.currentTimeMillis()
    val nums:List[Long] = List('0', '1', '2', '3', '4', '5', '6', '7', '8', '9').permutations
      .map(chars => chars.mkString(""))
      .filter{s: String => !s.startsWith("0")}
      .filter{s: String => divisibleBy(s.substring(1, 4), 2) }
      .filter{s: String => divisibleBy(s.substring(2, 5), 3) }
      .filter{s: String => divisibleBy(s.substring(3, 6), 5) }
      .filter{s: String => divisibleBy(s.substring(4, 7), 7) }
      .filter{s: String => divisibleBy(s.substring(5, 8), 11) }
      .filter{s: String => divisibleBy(s.substring(6, 9), 13) }
      .filter{s: String => divisibleBy(s.substring(7, 10), 17)}
      .map(s => s.toLong).toList
      println(nums)
    nums.sum
  }

}