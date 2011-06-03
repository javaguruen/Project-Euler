package euler

import java.util.{Arrays, ArrayList}
import collection.mutable.ListBuffer

/**
 * Created by IntelliJ IDEA.
 * User: Bjorn
 * Date: 11.aug.2010
 * Time: 21:14:56
 * To change this template use File | Settings | File Templates.
 */

class Euler03 {
//  def run: Unit = {
//    val primtall: Long = (600851475143L);
//    val fact = factor2(primtall)
//    fact.foreach(i => println(i))
//    //return fact( fact.size() -1 )
//  }

//  def isPrime(tall: Long): Boolean = {
//    if (tall == 2) return true
//    if (tall == 1) return true
//
//    if (factor2(tall).size > 0) {
//      return false;
//    }
//    return true
//  }

//  def factor(tall: java.lang.Long): Array[java.lang.Long] = {
//    var factors = new ArrayList[java.lang.Long]()
//    for (i <- 2 until tall.longValue) {
//      if (tall.longValue % i == 0) {
//        val factor: java.lang.Long = tall.longValue / i
//        factors.add(factor)
//        if (factor == i) {
//          factors.add(factor)
//        }
//      }
//    }
//
//    var arr = new Array[java.lang.Long](factors.size())
//    for (y <- 0 until factors.size) {
//      arr(y) = factors.get(y)
//    }
//    //return arr.sorted
//    return arr
//  }

//  def factor2(tall: Long): List[Long] = {
//    val factors = new ListBuffer[Long]
//
//    for (i <- 3 to 4) {
//      if (tall % i == 0) {
//        var factor = tall / i
//        factors.append(factor)
//        if (factor == i) {
//          factor.add(factor)
//        }
//        else {
//          tall = (long)(tall / i)
//        }
//      }
//    }
//  }

}