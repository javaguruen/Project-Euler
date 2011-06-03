package euler

import java.math.BigInteger

class Euler16 {
  def run(): Long = {
    var value = Math.pow(2.0, 1000.0)
    var b: BigInteger = new BigInteger("2").pow(1000)
    println(b)
    
    val strNum = b.toString
    var sum = 0
    //sum = strNum.foldLeft(0)( (s, c)=> s + c.toInt - '0'.toInt )
    sum = strNum.foldLeft(0)(  _ + _.toInt - '0'.toInt )
    println("Tverrsum = " + sum)
    //1366
    value.longValue
  }
}