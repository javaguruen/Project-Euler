package euler

class Euler81 {

  val dim = 80
  //val filnavn = "src/main/resources/Euler81x.txt"
  val filnavn = "src/main/resources/Euler81.txt"

  def run(): Long = {
    var alines: Array[Array[String]] = new Array[Array[String]](dim)
    var i = 0
    val lines = io.Source.fromFile(filnavn, "utf-8").getLines()
    lines.foreach(line => {
      println(line)
      val ar = line.split(",")
      alines(i) = ar
      i += 1
    })



    var paths: Array[Array[Int]] = new Array[Array[Int]](dim)
    for (col <- dim - 1 to 0 by -1) {
          paths(col) = new Array[Int](dim)
    }
      for (row <- dim - 1 to 0 by -1) {
        for (col <- dim - 1 to 0 by -1) {
        //println("col=" + col + " row=" + row + "value=" + alines(row)(col))
        val value = alines(row)(col).toInt
        var rightValue = Int.MaxValue
        var downValue = Int.MaxValue
        if( col < dim-1)
          rightValue = paths(row)(col+1).toInt;
        if( row < dim-1)
          downValue = paths(row+1)(col).toInt;
        if( col == dim-1 && row==dim-1){
          downValue = 0
          rightValue = 0
        }
        paths(row)(col) = value + scala.math.min (rightValue, downValue)
          //println("\tpaths=" + paths(row)(col))
      }
    }
    for (row <- 0 until dim) {
      for (col <- 0 until dim ) {
        print( paths(row)(col)  + " ")
      }
      println("")
    }
    val minsteSum = paths(0)(0)
    println("Korteste sti = " + minsteSum)

    /*
    var root = alines(0)(0)
    //aRoots(0)(0) = new Euler18Node( root )
    println aRoots(0)
    */
    minsteSum.toLong
  }
}