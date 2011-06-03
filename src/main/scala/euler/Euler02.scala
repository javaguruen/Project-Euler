package euler

/**
 * Created by IntelliJ IDEA.
 * User: Bjorn
 * Date: 11.aug.2010
 * Time: 20:18:54
 * To change this template use File | Settings | File Templates.
 */

class Euler02() {
  def run(): Int = {


    return fibopartall(4000000)
  }


  def fibopartall(maksFibo: Int): Int = {
    var gammelSum = 0;
    var sum = 2;
    var fibo1 = 1;
    var fibo2 = 2;
    var newFibo = 0;

    do {
      newFibo = fibo1 + fibo2;
      println("Raw fibonacci: " + newFibo)
      if (newFibo % 2 == 0 && newFibo < maksFibo) {
        sum = sum + newFibo;
        println("   sum " + sum)
      }
      fibo1 = fibo2;
      fibo2 = newFibo;
    } while (newFibo < maksFibo)

    sum
  }
}