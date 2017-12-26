package no.hamre.euler

/**
 * Created by IntelliJ IDEA.
 * User: Bjorn
 * Date: 27.jul.2010
 * Time: 22:16:00
 * To change this template use File | Settings | File Templates.
 */
def treshold = 4000000
def sum = 2
def s1=1
def s2=2
print "$s1 $s2 "
while( sum < treshold){
  def s = s1 + s2
  if( s % 2 == 0){
    sum += s
    if( sum >= treshold){
      sum -= s;
      break
    }
  }
  print "$s "
  s1=s2
  s2 = s
}
println "\n sum=$sum"