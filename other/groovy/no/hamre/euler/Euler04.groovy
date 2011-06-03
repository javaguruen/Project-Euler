package no.hamre.euler


def squareOfSums = Math.pow(100 * 101 / 2, 2)
def sumOfSquares = 0
def liste = (1..100)
liste.each() { int i ->
  println i
  sumOfSquares += (i * i)
}
println "square of sums = $squareOfSums"
println "sum of squares = $sumOfSquares"
def long diff = squareOfSums - sumOfSquares
println "Løsningen er ${diff}"
