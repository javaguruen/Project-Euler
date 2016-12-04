package actors

import scala.actors.Actor


object Coordinator{
  def main(args : Array[String] ) {
    val actor = new Coordinator
    actor.start
  }
}

class Coordinator extends Actor{
  def act  {
    println ("start act")

    val a1  = Array[Int]( 1,2)
    val a2  = Array[Int]( 2,3)

    val s1: Summerer = new Summerer(this, 1)
    s1.start
    s1 ! a1
    val s2: Summerer = new Summerer(this, 2)
    s2.start
    s2 ! a2

    var antallSvar =0
    while( antallSvar < 2){
      receive{
        case s : String => println (s)
      }
    }
   }
}

class Summerer( coordinator : Actor, id : Int ) extends Actor{
  def act{
    println ("Summerer nr " + id + " in action")
    while(true ){
      receive{
        case a : Array[Int] => {
          val sum = a.foldLeft(0){ (i,s) => i+s }
          coordinator ! ("ID=" + id + " Sum=" + sum)
        }
        case msg => println (msg)
      }
    }
  }
}

