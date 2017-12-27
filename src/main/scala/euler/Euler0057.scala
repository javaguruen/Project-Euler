package euler

object Euler0057{
  def main(args: Array[String]): Unit ={
    var count=0
    val euler = new Euler0057

    for(i <- 1 to 1000){
      val f = euler.run(i)
      println(s"$i: $f")
      if( f.numerator.toString.length > f.denumerator.toString.length) count += 1
    }
    println(s"Count == $count")
  }

}
class Euler0057 {


  def run(iter: Int): Fraction = {
    val frac = expand(iter)
    Fraction(frac.denumerator + frac.numerator, frac.denumerator)
  }

  def expand(iter: Int): Fraction = {
    if( iter == 1){
      Fraction(1, 2)
    } else {
      val frac = expand(iter-1)
      val den = Fraction(frac.denumerator*2+frac.numerator, frac.denumerator)
      Fraction(den.denumerator, den.numerator)
    }
  }

  case class Fraction(numerator: BigInt, denumerator: BigInt)

}
