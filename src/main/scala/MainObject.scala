import euler._
import java.util.Date

object MainObject{
  def main(args : Array[String])  {
    val start = new Date()
    println( "Starter kjøring: " + start)
    val euler = new Euler357()
    val resultat = euler.run(1000000)
    val ferdig = new Date()
    println( "Ferdig: " + ferdig)
    println("Tid medgått: " + (ferdig.getTime-start.getTime())/1000.0 + " sek.")
    println("Resultat = " + resultat)
  }
}