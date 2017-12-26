package euler

/**
 * Created by IntelliJ IDEA.
 * User: Bjorn
 * Date: 11.aug.2010
 * Time: 20:18:54
 * To change this template use File | Settings | File Templates.
 */

object Euler01ver2{
  def main( args : Array[String] ) {

    val tall = for{
        n <- 1 until 1000
        if n % 3 == 0 || n%5==0
      } yield n
    val sum = tall.sum
  }
}


class Euler01ver2(){

  def run() : Int ={
    def eu1( tall:Int) : Int = {
      if (tall%3==0 || tall%5==0)
        tall
      else
        0
    }

    summer(1000, eu1)
  }

  def summer(maks : Int, function : Int => Int ) : Int ={
    var sum=0
    for( tall <- 1 until maks){
      sum += function(tall)
    }
    sum
  }

}