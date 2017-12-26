package no.hamre.euler

def start = System.currentTimeMillis()

final int MAKS = 100_000_000
Character[][] array = new Character[2][MAKS]
array[0] = new Character[MAKS]
array[1] = new Character[MAKS]



def i = 1
array[i][0]='1'
array[i][1]='0'

//def tall = i as String
def maks = Math.pow(10.0, 12.0)
while( i < maks ){
    next( array, i %2 )
    if( i % 10_000 == 0) println("$i : tid(${(System.currentTimeMillis() - start)/1000.0} s.")
    i++
}

def (en, to, tre) = antall( array[i%2] )
println( "A(${i})=$en, B(${i})=$to, C(${i})=$tre ")


def antall(Character[] tall){
    int ant1=0
    int ant2=0
    int ant3=0
    tall.each{ n->
        switch(n) {
            case  '1' : ant1++; break;
            case  '2' : ant2++; break;
            case  '3' : ant3++; break;
        }
    }
    return [ant1, ant2, ant3]
}


def next(Character[][] array, int indeks){

    def tegn = array[indeks][0]
    def Integer antallAvTegn=1

    def arrayNestTall = (indeks+1) % 2
    def nesteindeks = 0

    def i=1
    while( array[indeks][i] != '0'){

      if( array[indeks][i] == tegn){
          antallAvTegn++
      }
      else{
          array[arrayNestTall][nesteindeks++] =  antallAvTegn.toString().charAt(0)
          array[arrayNestTall][nesteindeks++] =  tegn.toString().charAt(0)
          tegn = array[indeks][i]
          antallAvTegn = 1
      }
        i++
    }
    array[arrayNestTall][nesteindeks++] =  antallAvTegn.toString().charAt(0)
    array[arrayNestTall][nesteindeks++] =  tegn.toString().charAt(0)
    array[arrayNestTall][nesteindeks++] =  '0'
}


