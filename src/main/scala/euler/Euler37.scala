package euler

import java.util.Date
import java.lang.String


class Euler37 {
/*
Lol: dobbelttrunkable primtall: 37
Lol: dobbelttrunkable primtall: 53
Lol: dobbelttrunkable primtall: 73
Lol: dobbelttrunkable primtall: 313
Lol: dobbelttrunkable primtall: 317
Lol: dobbelttrunkable primtall: 373
Lol: dobbelttrunkable primtall: 797
Lol: dobbelttrunkable primtall: 3137
Lol: dobbelttrunkable primtall: 3797
Lol: dobbelttrunkable primtall: 739397

start=900000000
 */
  def run(): Long = {
    var truncablePrimes : List[Long] = Nil
    var primes : List[Long] = 2L ::3L :: 5L :: 7L :: 11L :: 13L :: 17L :: 19L :: Nil

    //var start =  900000000;
    println ("Max Long=" + Long.MaxValue)
    println ("Max Int=" + Int.MaxValue)
    var start : Long= 23L;
    //var start : Long= 8L;
    //       9223372036854775807
    //var start = 8;
    var teller = start
    while (truncablePrimes.length < 11 && start > 0 ) {
      if( teller%10000000==0){
        println ("start=" + start + " " + new Date() )
        println (" primes=" + primes )
      }
      val substring: String = start.toString().substring(1)
      if( substring.contains('0') ||
        substring.contains('2') ||
        substring.contains('4') ||
        substring.contains('6') ||
        substring.contains('8') ){

      }
      else{

        if (MathLib.isPrimeFast(start)) {
          primes = start :: primes
          //println(start + " er primtall ")
          if ( isLeftTrunkable(start, primes) && isRigthTrunkable (start, primes)) {
            println( "Lol: dobbelttrunkable primtall: " + start)
            truncablePrimes = start :: truncablePrimes
          }
        }
      }
      
      teller+=1
      start += 2
    }
    println ( truncablePrimes )
    println (" primes=" + primes )
    println ( "sum=" + truncablePrimes.foldLeft(0L){ (i,s) => i+s }  )
    0
  }


  def isLeftTrunkable(p: Long, primes : List[Long]) : Boolean = {
    val antallSiffer = p.toString().length
    for (tall <- antallSiffer - 1 to 0 by -1 ) {
      val candidate = p.toString().substring(tall)
      //println("leftTrunc(" + p + ") candidate " + candidate)
      val c = candidate.toLong
      if( !primes.contains( c )){
        return false
      }
      /*
      if (!MathLib.isPrimeFast(c)) {
        return false
      }
      */
    }
    true
  }

    def isRigthTrunkable(p: Long, primes : List[Long]) : Boolean = {
    val iterations = p.toString().length
    for (tall <- 1 to iterations) {
      val candidate = p.toString().substring(0,tall )
      //println("rightTrunc(" + p + ") candidate " + candidate)
      val c = candidate.toLong
      if( !primes.contains( c )){
        return false
      }
      /*
      if (!MathLib.isPrimeFast(c)) {
        return false
      }
       */
    }
    true
  }
}