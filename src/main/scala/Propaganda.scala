package propaganda

object Propaganda {

  def main(args: Array[String]) {
    println("Starting the Propaganda!")

    var c = 3
    val v1 = List(1,2,3).toSet
    val v2 = Set('a','b','c').toList
    val h = new Hanoi(new Tower(0), new Tower(1), new Tower(2))
    h.init
    println("Initial "+h)
    h.solve
    println("Result "+h)
  }
}
