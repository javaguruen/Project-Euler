package euler

import java.util.{Date, Calendar, GregorianCalendar}


class Euler19 {

  def run(): Long = {
    var startDato = new GregorianCalendar(1901, 0, 6)
    println( startDato.getTime )
    var sluttDato = new GregorianCalendar(2001, 1, 1)
    var antallSondager = 0;
    while (startDato.before(sluttDato)) {
      if ( startDato.get(Calendar.DAY_OF_MONTH) == 1 ) {
        antallSondager += 1
      }
      startDato.add( Calendar.DAY_OF_WEEK, 7)
    }
    antallSondager
  }

  def isSoendag(dato : GregorianCalendar) : Boolean = {
    dato.get( Calendar.DAY_OF_WEEK) == 1
  }
}
