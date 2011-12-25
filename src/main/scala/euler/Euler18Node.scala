package euler
import org.slf4j.LoggerFactory


class Euler18Node(val verdi : Int, val left : Int, val right : Int) {
  val maxPath = verdi + scala.math.max(left, right)
  val logger = LoggerFactory.getLogger( "Euler18" )
  logger.info("Verdi: " + verdi + ", left: " + left + ", right: " + right + " minPath: " + maxPath )
}