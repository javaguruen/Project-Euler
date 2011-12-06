package euler

class Euler18 {

  def run(): Long = {
    var alines : Array[ Array[String] ] = new Array[Array[String]](15)
    var i = 0
    val lines = io.Source.fromFile("src/main/resources/Euler18.txt", "utf-8").getLines()
    lines.foreach( line => {
      println( line )
      val ar = line.split(" ")
      alines(i) = ar
      i += 1
    } )

    var root = alines(0)(0)
    var aRoots = new Array[ Array[Euler18Node] ](15)
    aRoots(0) = new Array[ Euler18Node](0)
    //aRoots(0)(0) = new Euler18Node( root )
    0
  }
}