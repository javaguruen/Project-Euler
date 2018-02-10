package euler

import java.math.BigInteger
import java.text.DecimalFormat

import scala.annotation.tailrec


class Euler0104 {

  def run(): Int = find().intValue()

  @tailrec
  private def fibo(i: Long, fn1: BigInt, fn2: BigInt): BigInt = {
    if( fn1 < 0){
      throw new RuntimeException(s"Negative number i=$i -> overflow")
    }
    println(s"i=$i, fibo(i) == ${fn1+fn1}")
    val fi = MathLib.fibonacci(i).toString()
    if( MathLib.isPandigital(fi.take(9))
      && MathLib.isPandigital(fi.takeRight(9))){
      BigInt(i)
    } else {
      fibo(i+1, fn1+fn2, fn1)
    }
  }


  def find(): Long = {
    //var i = 2749
    var i = 106099
    val fi = fibo(i, MathLib.fibonacci(i-1), MathLib.fibonacci(i-1))
    print(s"found fi=$fi")
    fi.intValue()
  }

}