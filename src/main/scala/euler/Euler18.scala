package euler

class Euler18 {
  val dim = 100
  val filnavn = "src/main/resources/Euler67.txt"
  def run(): Long = {
    var alines : Array[ Array[String] ] = new Array[Array[String]](dim)
    var i = 0
    val lines = io.Source.fromFile(filnavn, "utf-8").getLines()
    lines.foreach( line => {
      println( line )
      val ar = line.split(" ")
      alines(i) = ar
      i += 1
    } )

    var aRoots = new Array[ Array[Euler18Node] ](dim)
    for( i <- (dim-1) to 0 by -1){
      val row : Array[String] = alines(i)
      aRoots(i) = new Array[ Euler18Node](row.size)
      for( j <- 0 until row.size ){
      if( i==(dim-1)){
        aRoots(i)(j) = new Euler18Node(alines(i)(j).toInt, 0, 0)
      }
      else {
        aRoots(i)(j) = new Euler18Node(alines(i)(j).toInt, aRoots(i+1)(j).maxPath, aRoots(i+1)(j+1).maxPath)
      }
      }
    }
    println("Lengste sti er " + aRoots(0)(0).maxPath)
/*
    var root = alines(0)(0)
    //aRoots(0)(0) = new Euler18Node( root )
    println aRoots(0)
    */
    0
  }
}