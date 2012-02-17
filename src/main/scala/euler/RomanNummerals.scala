package euler

object RomanNummerals {
  var romertall = ""

  def romertegn2tall(c: Char) : Int = {
    c match{
      case 'M' =>  1000
      case 'D' =>  500
      case 'C' => 100
      case 'L' => 50
      case 'X' => 10
      case 'V' => 5
      case 'I' => 1
    }
  }

  def romertall2tall(tegn: String): Int = {
    var sum = 0
    var tall = 0
    var forrigeTall = 2000
    for( n <- 0 until tegn.length()){
      tall = RomanNummerals.romertegn2tall( tegn(n) )
      if( n > 0 ){
        forrigeTall = RomanNummerals.romertegn2tall( tegn(n-1) )
      }
      if( forrigeTall < tall ){
        sum -= forrigeTall
        sum += tall - forrigeTall
      }
      else{
        sum += tall
      }
    }
    sum
  }

  /*
  Only I, X, and C can be used as the leading numeral in part of a subtractive pair.
  I can only be placed before V and X.
  X can only be placed before L and C.
  C can only be placed before D and M.
   */
  def convert(tall: Int): String = {
    var rest = tall;
    romertall = ""

    rest = taVekk(rest, 1000, "M");
    rest = taVekk(rest, 900, "CM");
    rest = taVekk(rest, 500, "D");
    rest = taVekk(rest, 400, "CD");
    rest = taVekk(rest, 100, "C");
    rest = taVekk(rest, 90, "XC");
    rest = taVekk(rest, 50, "L");
    //rest = taVekk(rest, 49, "IL");
    rest = taVekk(rest, 40, "XL");
    rest = taVekk(rest, 10, "X");
    rest = taVekk(rest, 9, "IX");
    rest = taVekk(rest, 5, "V");
    rest = taVekk(rest, 4, "IV");
    rest = taVekk(rest, 1, "I");

    romertall;
  }

  def taVekk(rest: Int, taVekk: Int, rtall: String): Int = {
    var r = rest
    val temp = r / taVekk;
    if (temp > 0) {
      for (i <- 0 until temp) {
        romertall += rtall;
      }
      r -= (temp * taVekk);
    }
    r
  }

}
