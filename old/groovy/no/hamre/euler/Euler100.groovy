package no.hamre.euler

import java.text.DecimalFormat

class Euler100 {
    public static void main(String[] args) {
        def euler = new Euler100()
        euler.find(1000000000000L)
    }

    def prob2Blue(blue,  red){
        return ((blue as Double) / (blue + red) ) * (blue - 1) / ( (blue + red - 1)as double)
    }

    def find( minTotal){
        def notFound = true
        def n = minTotal
        while (notFound) {
            def kvadratrot = finnKvadratrot(n)
            def blueD = (1.0 + kvadratrot) / 2.0
            if ( isHeltall(blueD)) {
                def blue = blueD
                def red = (n - blue)
                println("Potensiell n=${n} blå = ${blue} temp=${temp}")
                if (prob2Blue(blue, red) > 0.040) {
                    def myFormatter = new DecimalFormat("###.##")
                    def bOut = myFormatter.format(blue)
                    def rOut = myFormatter.format(red)
                    def prob = prob2Blue(blue, red)
                    def probOut = myFormatter.format(prob)
                    printf("Blue=%s red=%s\n", bOut, rOut)
                    printf("Prob(${blue}, ${red})=%s\n", new BigDecimal(prob).toPlainString())
                    return [blue, red]
                } else {
                    println("**** Feil sannsynlighet")
                    n += 1
                }
            } else {
                n += 1
            }
        }
        return [-1, -1]
    }

    private double finnKvadratrot(long n) {
        def temp = 1L + (2L * n * (n - 1))
        if( temp < 0 ){
            println(" temp=" + temp)
            System.exit(-100)
        }

        Math.sqrt(temp)
    }

    def isHeltall(n) {
      return Math.abs(n - Math.round(n)) < 0.0000000000000001
    }
}
