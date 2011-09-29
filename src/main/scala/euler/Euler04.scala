package euler

class Euler04 {
  def run: Unit = {
    var largest =Integer.MIN_VALUE

    for (i <- 100 to 999) {
      for (j <- 100 to 999) {
        val candidate = i *j;
        if ( MathLib.isPalindrome (candidate)) {
          if (candidate > largest) {
            largest = candidate
            println(candidate)
          }
        }
      }
    }
    println("OMG LARGEST! : "+largest)
  }

}