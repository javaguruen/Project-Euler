package euler

/**
 * Created by IntelliJ IDEA.
 * User: Bjorn
 * Date: 11.aug.2010
 * Time: 21:14:56
 * To change this template use File | Settings | File Templates.
 */

class Euler05 {

  def delbar(maks: Int, numbers: Array[Int], _loesning : Int): Int = {
    var loesning: Int = _loesning
    for (i <- 20 to maks) {
      var teller = 0
      numbers.foreach(number => if (i % number == 0) teller += 1)
      if (teller == numbers.length) {
        loesning = i
        return i
      }
    }
    -1
  }

  def run: Unit = {
    var numbers = Array(20, 19, 18, 17, 16, 15, 14, 13, 12, 11)
    val maks = 427674624
    
    var loesning  = 0
    loesning = delbar(maks, numbers, loesning)
    println ("Losningen er " + loesning)

  }

}