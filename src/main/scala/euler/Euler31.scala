package euler

import org.slf4j.LoggerFactory

class Euler31 {

  val logger = LoggerFactory.getLogger("Euler31")

  def run(): Long = {

    1
  }

  def numberOfSolutions(pence : Int) : Int = {
    var rest = pence
    var solutions = 0
    if( rest == 1){
      solutions += 1
      return solutions
    }
    if( rest == 2){
      solutions += 2

    }
    if( rest > 2){
      solutions += 1
      solutions += numberOfSolutions(rest-2)
    }
    solutions
  }
}