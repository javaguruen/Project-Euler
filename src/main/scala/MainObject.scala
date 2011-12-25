import euler._
import java.util.Date

object MainObject{
  def main(args : Array[String])  {
    val start = new Date()
    println( "Starter kjøring: " + start)
    val euler = new Euler18()
    val resultat = euler.run()
    val ferdig = new Date()
    println( "Ferdig: " + ferdig)
    println("Tid medgått: " + (ferdig.getTime-start.getTime())/1000.0 + " sek.")
    println("Resultat = " + resultat)
  }
}
//n=2.000.000 sum=1661123099 tid(s)=151