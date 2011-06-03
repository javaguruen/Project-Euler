package euler


class Euler45 {
  def run(): Long = {
    val max = 100000


    println("Finding pentagonals")
    val pentagonals = findNumbers(MathLib.pentagonal, Nil)
    printList(pentagonals, "Pentagonals")

    println("Finding hexagonals")
    val hexagonals = findNumbers(MathLib.hexagonal, Nil)
    printList(hexagonals, "Hexagonals")

    println("Finding intersections")
    var intersection = pentagonals.intersect(hexagonals)
    printList(intersection, "intersections")

    println("Finding triangles")
    val triagonals = findNumbers(MathLib.triangle, intersection)
    printList(triagonals, "Triangles")

    println("Finding intersections")
    intersection = intersection.intersect(triagonals)
    printList(intersection, "intersections")

    0
  }

  def printList(list: List[Long], navn: String) {
    println("---- Liste - " + navn)
    println("\tsize=" + list.size)
    val antall = Math.min(list.size, 5)
    for (i <- 0 until antall)
      println("\tlist(" + i + ")=" + list(i))
  }

  def findNumbers(f: (Int) => Long, master: List[Long]): List[Long] = {
    var n: Int = 1
    var value: Long = 0
    var liste: List[Long] = Nil;
    while (n > 0 && n<1000000 && value >= 0) {
      if( n % 1000000 == 0) println("n=" + n)
      value = f(n)
      if (value > 0) {
        if (master.size > 0) {
          //Add only if value in master list
          if (master.contains(value)) {
            liste ::= value
          }
        }
        else {
          //Add all
          liste ::= value
        }
      }
      else
        println("exit for f(" + n + ")=" + value)
      n += 1
    }
    liste
  }
}