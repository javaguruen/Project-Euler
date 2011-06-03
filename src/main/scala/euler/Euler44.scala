package euler


class Euler44 {
  def run(): Long = {
    val maksForsoek = 10000
    var alleP: Map[Long, Int] = Map()
    var minsteDiff = Long.MaxValue
    //myMap += ( sum -> sum)
    for( n <- 1 to maksForsoek){
      val pn = MathLib.pentagonal(n)
      if( pn < 0) println (" FOR STORT TALL")
      //println(" P(" + n +")=" + pn )
      alleP += (pn -> n )
    }
    for( j <- 1 to maksForsoek-1){
      for(k <- j to maksForsoek ){
        val pj = MathLib.pentagonal(j)
        val pk = MathLib.pentagonal(k)
        val sumPjPk = pj + pk
        if( alleP.contains(sumPjPk)){
          //println("Summen av P" + j + " og P" + k + " er pentagonal")
          val diffPjPk = scala.math.abs( pj - pk)
          if( alleP.contains(diffPjPk) ){
            println("Diffen av P" + j + " og P" + k + " er pentagonal")
            if( diffPjPk < minsteDiff){
              minsteDiff = diffPjPk
              println ("LOL ny minste diff")
            }
          }
        }
      }
    }
    println ("Minste diff = " + minsteDiff)

    0
  }
}