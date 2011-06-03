package euler

class Euler09{

  def run() : Int = {
    val maks = 1000
    for( a <- 1 until maks){
      for( b <- (a+1) until maks+1){
        for( c <- (b+1) until maks+2){
          if( (a*a) + (b*b) == (c*c) ){
            println ("a:" + a + " b:" + b + "  c:" + c)
            if( ( a+b+c) == 1000 ){
              return (a*b*c)
            }
          }
        }
      }
    }
    -1
  }
}