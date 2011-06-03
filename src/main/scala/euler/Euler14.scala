package euler

class Euler14 {
  def run(): Long = {
    var startingNumber = 1
    var longestChain = -1
    var longestChainLol : List[Long] = Nil

    do {
      var myList = makeChain(startingNumber)
      var currentSize = myList.size
      //  println("Kjedelengde ved startnummer "+startingNumber+" : " + currentSize)
      if (currentSize > longestChain) {
        longestChain = currentSize
        longestChainLol = myList
      }
      //    printList(myList)
      startingNumber += 1
      if (startingNumber % 1000 == 0) {
        print( " "+ startingNumber)
      }
    } while (startingNumber < 1000000)
    println
    println("Teh longest chain!: " + longestChain)
    printList(longestChainLol)
    longestChain
  }

  def makeChain(start: Long): List[Long] = {
    var chain: List[Long] = start :: Nil
    var n = start
    while (n != 1) {
      if (n % 2 == 0) {
        n = n / 2
      } else {
        n = 3 * n + 1
      }
      chain = n :: chain
    }
    chain.reverse
  }

  def printList(theList: List[Long]): Unit = {
    theList.foreach(n => print(n + " "))
    println
  }

}