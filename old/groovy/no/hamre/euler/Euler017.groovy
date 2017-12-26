package no.hamre.euler

enum Tall {

  one(1, "one"),
  two(2, "two"),
  three(3, "three"),
  four(4, "four"),
  five(5, "five"),
  six(6, "six"),
  seven(7, "seven"),
  eight(8, "eight"),
  nine(9, "nine"),
  ten(10, "ten"),
  eleven(11, "eleven"),
  twelve(12, "twelve"),
  thirteen(13, "thirteen"),
  fourteen(14, "fourteen"),
  fifteen(15, "fifteen"),
  sixteen(16, "sixteen"),
  seventeen(17, "seventeen"),
  eighteen(18, "eighteen"),
  nineteen(19, "nineteen"),
  twenty(20, "twenty"),
  thirty(30, "thirty"),
  fourty(40, "forty"),
  fifty(50, "fifty"),
  sixty(60, "sixty"),
  seventy(70, "seventy"),
  eighty(80, "eighty"),
  ninety(90, "ninety"),
  hundred(100, "hundred"),
  thousand(1000, "thousand")

  public static String tekstFromValue(int value) {
    switch (value) {
      case 1: return one.tekst;
      case 2: return two.tekst;
      case 3: return three.tekst;
      case 4: return four.tekst;
      case 5: return five.tekst;
      case 6: return six.tekst;
      case 7: return seven.tekst;
      case 8: return eight.tekst;
      case 9: return nine.tekst;
      case 10: return ten.tekst;
      case 11: return eleven.tekst;
      case 12: return twelve.tekst;
      case 13: return thirteen.tekst;
      case 14: return fourteen.tekst;
      case 15: return fifteen.tekst;
      case 16: return sixteen.tekst;
      case 17: return seventeen.tekst;
      case 18: return eighteen.tekst;
      case 19: return nineteen.tekst;
      case 20: return twenty.tekst;
      case 30: return thirty.tekst;
      case 40: return fourty.tekst;
      case 50: return fifty.tekst;
      case 60: return sixty.tekst;
      case 70: return seventy.tekst;
      case 80: return eighty.tekst;
      case 90: return ninety.tekst;
      case 100: return hundred.tekst;
      case 1000: return thousand.tekst;
    }
  }

  private final int verdi;
  private final String tekst;

  Tall(int verdi, String tekst) {
    this.verdi = verdi;
    this.tekst = tekst;
  }

  public String getTekst() {
    return tekst
  };

  public int getVerdi() {
    return verdi;
  }
}


int characterCount = 0;
for (int i = 1; i <= 1000; i++) {
  def word = ""
  def tempI = i
  def t = (int)(tempI / 1000)
  def ferdig = false
  if (t != 0) {
    characterCount += Tall.tekstFromValue(1).length()
    characterCount += Tall.tekstFromValue(1000).length()
    word = Tall.tekstFromValue(1) + " " + Tall.tekstFromValue(1000)
    ferdig = true;
  }
  else {
    while (!ferdig) {
      t = (int)(tempI / 100)
      if (t > 0) {
        characterCount += Tall.tekstFromValue(t).length()
        if( tempI % 100 != 0 )
          characterCount += "and".length()
        characterCount += Tall.tekstFromValue(100).length()
        word += Tall.tekstFromValue(t) + " "
        word += Tall.tekstFromValue(100)
        if( tempI % 100 != 0 )
          word += " and "
        tempI = tempI % 100
      }
      else {
        t = tempI % 100
        if (t > 20) {
          def tiere = (int)(t / 10)
          characterCount += Tall.tekstFromValue(tiere * 10).length()
          word += Tall.tekstFromValue(tiere*10)
          def enere = t % 10
          if( enere > 0){
            characterCount += Tall.tekstFromValue(enere).length()
            word += "-" + Tall.tekstFromValue(enere)
          }
          ferdig = true
        }
        else {
          if( t > 0){
            characterCount += Tall.tekstFromValue(t).length()
            word += Tall.tekstFromValue(t)

          }
          ferdig = true
        }
      }
    }
  }
  println( word )
}

println("Characters used = ${characterCount}")