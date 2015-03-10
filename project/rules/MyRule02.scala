import scala.meta.internal.ast._
import scala.meta.tql._
import scala.obey.model._
import scala.language.reflectiveCalls

@Tag("List", "Set", "Test") object MyRule02 extends Rule {
  def description = "You used a list? Why not considering a Set?"

  def message(t: Term.Name): Message = Message(s"Changing list to set, for the fun of it", t)

  def apply = {
    transform {
      case t @ Term.Name("List") =>
        Term.Name("Set") andCollect message(t)
    }.topDown
  }
}
