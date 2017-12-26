package no.hamre.euler


def tall = 600851475143L
println factor(tall)



def factor(tall) {
  def factors = []
  for (long i = 3; i <= tall; i+=2) {
    if (tall % i == 0) {
      def factor = tall / i
      factors.add( i )
      if (factor == i) {
        factors.add(factor)
      }
      else {
        tall = (long) (tall / i)
      }
    }
    if( i % 1000000 == 0) print "."
  }
  factors
}