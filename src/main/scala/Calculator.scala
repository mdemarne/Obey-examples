
/* Dummy calculator: takes input in postfix notation without checking them and tries to dos something with it. */
object Calculator {
  var run = true
  var opStack: List[String] = Nil
  def main(args: Array[String]): Unit = {
    while(run)(act)  
  }
  private def act = {
    scala.io.StdIn.readLine.toLowerCase match {
      case "stop" => run = false
      case "apply" => {run = false; calc}
      case "+" => opStack :+= "+"
      case "-" => opStack :+= "-"
      case "*" => opStack :+= "*"
      case "/" => opStack :+= "/"
      case othr => 
        try {
          /* Verifying that this is a proper int by a bad trick */
          opStack :+= othr.toInt.toString
        } catch {
          case e: Throwable => println("Wrong input!")
        }
    }
  }
  private def calc = {
    try {
      def loop(ops: List[String]): Int = ops match {
       case x :: y :: "-" :: ops => 
         loop((x.toInt - y.toInt).toString :: ops)
       case x :: y :: "+" :: ops =>
         loop((x.toInt + y.toInt).toString :: ops)
       case x :: y :: "*" :: ops =>
         loop((x.toInt * y.toInt).toString :: ops)
       case x :: y :: "/" :: ops =>
         loop((x.toInt / y.toInt).toString :: ops)
       case x :: Nil => x.toInt
      }
      println(loop(opStack))
    } catch {
      case e: Throwable => println("Not a postfix notation!")
    }
  }
}
