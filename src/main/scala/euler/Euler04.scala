package euler

import collection.mutable.ListBuffer

/**
 * Created by IntelliJ IDEA.
 * User: Bjorn
 * Date: 11.aug.2010
 * Time: 21:14:56
 * To change this template use File | Settings | File Templates.
 */

class Euler04 {
  def run: Unit = {
    var largest =Integer.MIN_VALUE

    for (i <- 100 to 999) {
      for (j <- 100 to 999) {
        val candidate = i *j;
        if (isPalindrome (candidate)) {
          if (candidate > largest) {
            largest = candidate
            println(candidate)
          }
        }
      }
    }
    println("OMG LARGEST! : "+largest)
  }


  def isPalindrome ( candidate : Int) : Boolean = {
    val str = ""+candidate
    return str.equalsIgnoreCase(str.reverse)
  }

}