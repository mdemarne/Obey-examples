package propaganda
object Propaganda {
  def main(args: Array[String]): Unit = {
    println("Starting the Propaganda!")
    val `c` = 3
    val v1 = Set(1, 2, 3)
    val v2 = Set('a', 'b', 'c').toList
    val h = new Hanoi(new Tower(0), new Tower(1), new Tower(2))
    h.init
    println("Initial " + h)
    h.solve
    var x = Set(1,2,3,4)
    println("Result " + h)
    val y = Set(1,2,3,3)
    val xx = x.toList
    val yy = y.toList
  }
}
