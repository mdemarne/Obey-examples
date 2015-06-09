import scala.meta.internal.ast._
import scala.meta.tql._
import scala.obey.model._
import scala.language.reflectiveCalls

@Tag("Scala", "Mine", "ErrorProne") object ProhibitHeandAndLast extends WarnRule {
  def description = "Prohibit the use of .head and .last, which are equivalent to calling a function on a null if the list is empty."

  def apply = collect {
      case Term.Select(_, s: Term.Name) if s.value == "head" => Message("Calling .head on a list if the list is empty is like calling a function on a null.", s)
      case Term.Select(_, s: Term.Name) if s.value == "last" => Message("Calling .last on a list if the list is empty is like calling a function on a null.", s)
    }.topDown
}
