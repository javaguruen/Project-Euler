package euler

class Euler52 {


  def containsSameNumbers(i: Int, j: Int): Boolean = {
    MathLib.isPermutation(i, j)
  }

  def run() : Int = {
    for (i <- 0 until  Int.MaxValue){
      if ( containsSameNumbers(i, 2*i)
              && containsSameNumbers (i, 3*i)
              && containsSameNumbers (i, 4*i)
              && containsSameNumbers (i, 5*i)
              && containsSameNumbers (i, 6*i) ){
        println(" Found for i=" + i)
      }

    }
    0
  }

}