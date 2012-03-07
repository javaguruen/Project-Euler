package euler

class Euler65 {
  val pattern = makePattern(33)

  def makePattern(antallMoenster: Int) : Array[Int] = {
    val p = new Array[Int](1 + 3*antallMoenster)
    p(0) = 2
    for( i <- 0 until antallMoenster){
      p(1 + i*3) = 1
      p(1 + i*3 +1 ) = 2*(i+1)
      p(1 + i*3 + 2) = 1
    }
    p
  }


  def run(): Int = {
    val maksantall = 6
    val e = pattern(0) + conv(1, maksantall);
    println ("e=" + e)
    1
  }

  def conv( cnr : Int, maksantall : Int) : Double = {
    if( cnr == maksantall) {
      return 1.0 / pattern(cnr)
    }
    else{
      return 1.0 / ( pattern(cnr) + conv( cnr+1, maksantall ) )
    }
  }
}