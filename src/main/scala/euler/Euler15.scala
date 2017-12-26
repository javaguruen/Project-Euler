package euler

import org.slf4j.LoggerFactory


class Euler15 {
  val size=2
  val logger = LoggerFactory.getLogger( "Euler15")
  //var kart = Array.range(0,2).map(i => Array.range(0,2).map(j => (i,j)))
  var kart = new Array[ Array[Long]](21)

  def run(): Long = {
    var x = 0
    var y = 0
    var edged=0

    logger.info("Starter kjøring")
    val dim: Int = 21
    for( i <-0 until dim){
      kart(i) = new Array[Long](dim)
    }

    for( i <- 0 until dim){
      kart(0)(i) = 1
    }
    for( i <- 0 until dim){
      kart(i)(0) = 1
    }

    for( row <- 1 until dim){
      for( col <- 1 until dim){
        kart(row)(col) = kart(row-1)(col) + kart(row)(col-1)
      }
    }

    val antallStier = kart(dim - 1)(dim - 1)
    antallStier
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