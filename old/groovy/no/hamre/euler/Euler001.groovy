package no.hamre.euler

/**
 * Created by IntelliJ IDEA.
 * User: Bjorn
 * Date: 27.jul.2010
 * Time: 21:57:00
 * To change this template use File | Settings | File Templates.
 */
def sum = 0;
(1..<1000).each() { it ->
  if( it % 3 == 0 || it % 5 == 0){
    sum += it
    println "adding $it"
  }
}
println "sum=$sum"