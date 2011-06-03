package euler

class Euler48 {


  def run(): Long = {
    var sum : Long = 0
    for( n <- 1 to 1000){
      sum += myMultiplier ( n )
      println ("n=" + n + " sum = " + sum)
    }

    sum
  }


  def myMultiplier(number : Int) : Long = {
    var truncProduct : Long = number
    for( n <- 1 until number ){
      truncProduct = truncProduct * number;
      val stringProd = truncProduct.toString
      if( truncProduct.toString.length > 10){
        truncProduct = truncProduct.toString.substring( stringProd.length-11, stringProd.length).toLong
      }
    }
    truncProduct
  }
}