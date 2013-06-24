package euler

class Euler60 {


  def run() : Int = {
    val tall = ( 3 to 10000000)
    val primtall = tall.filter( t => MathLib.isPrimeFast(t)).take(100000)
    val primtallArray = primtall.toArray
    println( "Primtall: " + primtall.size)

    for ( first <- 1 to 10) {
      for (secnd <- first to 10) {
        for (third <- secnd to 10) {
          for (fourth <- third to 10 ) {
            for (fifth <-fourth to 10) {
              val en = primtallArray(first)
              if (isAllFivePrimeConcatinatedFastAllParam(primtallArray(first), primtallArray(secnd), primtallArray(third), primtallArray(fourth), primtallArray(fifth) )) {
                val sum = primtallArray(first) + primtallArray(secnd) +  primtallArray(third) + primtallArray(fourth) + primtallArray(fifth)

                println(primtallArray)
                return sum
              }
            }
          }
        }
      }

    }
    //val riktige = primtall.filter( n=> isAllFivePrimeConcatenated(n))
    //println("riktige: " + riktige)

  //  val summer =
    //riktige.size
    -1
  }

  def isAllFivePrimeConcatenated( candidate : Long ) = {
    val knowns = List (3, 7, 109, 673)
    val res = knowns.filter(n => isAllFivePrimeConcatenatedFast(n))
    res.size == 4
  }
  def isAllFivePrimeConcatinatedFastAllParam( n1 : Long, n2 : Long, n3:Long, n4:Long, n5:Long) : Boolean = {
    if (!pairConcatenatedIsPrime(n1, n2 )) {
      return false;
    }
    if (!pairConcatenatedIsPrime(n1, n3 )) {
      return false;
    }
    if (!pairConcatenatedIsPrime(n1, n4)) {
      return false;
    }
    if (!pairConcatenatedIsPrime(n1, n5)) {
      return false;
    }


    if (!pairConcatenatedIsPrime(n2, n3 )) {
      return false;
    }
    if (!pairConcatenatedIsPrime(n2, n4 )) {
      return false;
    }
    if (!pairConcatenatedIsPrime(n2, n5)) {
      return false;
    }
    if (!pairConcatenatedIsPrime(n3, n4)) {
      return false;
    }
    if (!pairConcatenatedIsPrime(n3, n5)) {
      return false;
    }
    if (!pairConcatenatedIsPrime(n4, n5)) {
      return false;
    }
    true
  }
  def isAllFivePrimeConcatenatedFast( candidate : Long ) : Boolean = {
    if (!pairConcatenatedIsPrime(candidate, 3 )) {
      return false;
    }
    if (!pairConcatenatedIsPrime(candidate, 7 )) {
      return false;
    }
    if (!pairConcatenatedIsPrime(candidate, 109 )) {
      return false;
    }
    if (!pairConcatenatedIsPrime(candidate, 673 )) {
      return false;
    }
   true
  }
  def isPrime(number : Long) : Boolean = {
    MathLib.isPrimeFast( number )
  }

  def pairConcatenatedIsPrime(n1 : Long, n2 : Long) : Boolean ={
    val comb1 : String = n1.toString + n2.toString
    val comb2 : String = n2.toString + n1.toString
    MathLib.isPrimeFast( comb1.toLong ) && MathLib.isPrimeFast( comb2.toLong)
  }
}