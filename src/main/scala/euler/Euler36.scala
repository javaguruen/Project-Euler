package euler

import collection.mutable.HashSet

object Euler36 {
  def main(args: Array[String]): Unit = {
    val hw = new Euler36()
    hw.run
  }
}

class Euler36 {
  var primes = List(2)
//  var palindrome = List [Int] :: Nil
  var palindrome = List (0)
  def run(): Long = {


    for (tall <- 1 to 1000000  by 2 ) {
      if (is10and2palindromic (tall)) {
        palindrome = tall :: palindrome
      }
    }
    println ("Antall 10 og2 palindromer: " + palindrome.size)
    println (palindrome)

    println ("Sum er " + palindrome.foldLeft(0){ (i, s) => i+s}  )

    0
  }

  def is10and2palindromic (p : Int) : Boolean = {
    return isPalindrome(p.toString) && isPalindrome (Integer.toBinaryString(p))
  }

  def isPalindrome (s : String) : Boolean = {
    return (s == s.reverse)
  }

}