package euler

import org.slf4j.LoggerFactory


class Euler15 {
  val size=2
  val logger = LoggerFactory.getLogger( "Euler15")
  //var kart = Array.range(0,2).map(i => Array.range(0,2).map(j => (i,j)))
  var kart = new Array[ Array[Int]](3)





  def run(): Long = {
    var x = 0
    var y = 0
    var edged=0

    logger.info("Starter kjøring")
    println( kart )
    kart(0) = Array(-1, -1, -1)
    kart(1) = Array(-1, -1, -1)
    kart(2) = Array(-1, -1, -1)

    println( kart )



    findEdges(x, y)
  }

  def findEdges(x: Int, y: Int) : Int = {

    var edges = 0
    if( kart(x)(y) == -1){
      if( x < size){
        edges += 1 + findEdges (x+1, y)
      }
      if( y < size ){
        edges +=  1 + findEdges (x, y+1)
      }
      kart(x)(y) = edges
    }
    else{
      edges = 0
    }
    logger.debug("findEdge(" + x  + "," + y + ") = " + edges)
    edges
  }
}