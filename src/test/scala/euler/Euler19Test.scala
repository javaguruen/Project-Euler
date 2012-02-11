package euler
import org.junit.{Ignore, Before, Test}
import java.util.{Calendar, GregorianCalendar}

class Euler19Test {

  @Test
  def isSoendag() {
    var cal = new GregorianCalendar(2012, 1, 5)
    println( cal.getTime )
    val euler19 = new Euler19
    assert( true == euler19.isSoendag(cal))
    cal.add(Calendar.DAY_OF_WEEK, 1)
    assert( false == euler19.isSoendag(cal))
    cal.add(Calendar.DAY_OF_WEEK, 6)
    assert( true == euler19.isSoendag(cal))

  }

}