package math

import java.util.Date
import collection.SortedSet
import collection.immutable.TreeSet

object RowlandPrimeGenerator{
  def main(args : Array[String]){
    def rpg = new RowlandPrimeGenerator(1L)
    rpg.run()
  }
}
class RowlandPrimeGenerator(val start : Long){
  def run() ={
    println ( new Date() + " starting")
    var forrigeA = 7L
    var primtall : TreeSet[Long] = TreeSet(2)

    var a=2
    var n=2L
    while( n< Int.MaxValue && n > 0){
      val bigA = BigInt(n)
      val an = forrigeA + bigA.gcd( BigInt(forrigeA) ).longValue
      val diff = an - forrigeA
      if( diff > 1){
        println("Fant primtallet: " + diff)
        primtall = primtall + diff
        println (primtall)
      }
      forrigeA = an
      n +=1
    }
    println ( new Date() + " ferdig")
  }
}