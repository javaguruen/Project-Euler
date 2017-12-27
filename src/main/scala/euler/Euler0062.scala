package euler


object Euler0062{
  def main(args: Array[String]): Unit ={
//    val euler = new Euler0062()
    var map: Map[String, List[Long]] = Map()
    for(i <- 345 to 8384){
      val il = i.longValue()
      val cube: Long = il*il*il
      if( i < 0 ) throw new RuntimeException(s"Overflow for i = $i")
      val sortedCube: String = cube.toString.sortWith( _ < _)
      if( map.get(sortedCube).isDefined){
        val list: List[Long] = map(sortedCube)
        map -= sortedCube
        map += (sortedCube -> (i.longValue() :: list))
      } else {
        map += (sortedCube -> List(i.longValue()))
      }
      if( map(sortedCube).size == 5){
        println(s"Solution for i=$i: ${map(sortedCube)} = ${cube}")
      }
    }
  }
}

class Euler0062 {
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
