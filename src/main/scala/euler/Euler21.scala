package euler

class Euler21 {
  def run(): Long = {
    var vennligsum = 0
    var sumD : Array[Int] = new Array[Int](10001);
    for( i <- 1 until 10000){
      val devisors = MathLib.properDevisors( i )
      println ("devisors: " + devisors)
      val sum = summer(devisors)
      println ("sum[" + i + "] = " + sum)
      sumD(i) = sum
      if (sum != i) {
        if (sum < i ) {
          if (sumD(sum) == i) {
            println("OMG! par! " + i + " " + sum )
            vennligsum = vennligsum + i + sum
          }
        }
      }
    }
    println("Vennligsum" + vennligsum)
    vennligsum
  }

  def summer( tall : java.util.List[Int] ) : Int = {
    var sum = 0;
    for( i <- 0 until tall.size() ){
      sum = sum + tall.get(i)
    }
    sum
  }

  def fakultet(n: Int): BigInt = {
    if (n == 1) {
      return 1
    }
    else {
      var p : BigInt = fakultet(n - 1) * n
      println(p);      
      return p
    }
  }
}