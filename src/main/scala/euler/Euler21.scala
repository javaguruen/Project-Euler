package euler

class Euler21 {
  def run(): Long = {
    var vennligsum = 0
    var sumD : Array[Int] = new Array[Int](10001);
    for( i <- 1 until 10000){
      val devisors = MathLib.properDivisors( i.longValue() )
      val sum = summer(devisors)
      sumD(i) = sum
      if (sum != i) {
        if (sum < i ) {
          if (sumD(sum) == i) {
            vennligsum = vennligsum + i + sum
          }
        }
      }
    }
    vennligsum
  }

  def summer( tall : List[Long] ) : Int = {
    var sum = 0L;
    for( i <- 0 until tall.size ){
      sum = sum + tall(i)
    }
    sum.intValue()
  }

  def fakultet(n: Int): BigInt = {
    if (n == 1) {
      1
    }
    else {
      var p : BigInt = fakultet(n - 1) * n
      p
    }
  }
}