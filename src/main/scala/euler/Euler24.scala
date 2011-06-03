package euler

import util.Sorting

class Euler24 {
  def run(): Long = {
    //permute( List(0, 1, 3 ,4 ,5, 6, 7, 8, 9) )
    var list: scala.List[_root_.scala.Predef.String] = permute(List(0, 1, 3, 4, 5, 6, 7,8,9), "")
    list = list.sort( (s,t)=> s < t )
    println ("antall: " + list.size )
    list = list.drop( 274239 )
    println ( list.head )

    0
  }

  def permute(tall: List[Int], fixed: String): List[String] = {
    var permutasjoner = List[String]()

    if (tall.size == 2) {
      val arr = tall.toArray
      permutasjoner = (fixed + arr(0) + arr(1)) :: permutasjoner
      permutasjoner = (fixed + arr(1) + arr(0)) :: permutasjoner

    }
    else {
      var shorter = tall
      for (i <- 1 to tall.size) {
        var fix = shorter.head
        shorter = shorter.drop(1)
        permutasjoner = permute(shorter, (fixed+fix.toString)) ::: permutasjoner
        shorter = fix :: shorter.reverse
        shorter = shorter.reverse
      }
    }
    permutasjoner
  }
}