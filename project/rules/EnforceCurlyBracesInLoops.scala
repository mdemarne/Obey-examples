import scala.meta.internal.ast._
import scala.meta.tql._
import scala.obey.model._
import scala.language.reflectiveCalls

@Tag("Scala", "Mine", "Style") object EnforceCurlyBracesInLoops extends FixRule {
  def description = "Enforce the use of curly braces for loops"

  def message(t: Tree) = Message("You should use curly braces", t)

  def apply = collect {
      case Term.While(_, b) if !b.isInstanceOf[Term.Block] => message(b)
      case Term.Do(b, _) if !b.isInstanceOf[Term.Block] => message(b)
    }.topDown
}
