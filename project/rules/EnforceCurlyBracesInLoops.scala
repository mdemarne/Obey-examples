import scala.meta.internal.ast._
import scala.meta.tql._
import scala.obey.model._
import scala.language.reflectiveCalls

@Tag("Scala", "Mine", "Style") object EnforceCurlyBracesInLoops extends FixRule {
  def description = "Enforce the use of curly braces for loops"

  def apply = transform {
      case t: Source => t andCollect Message("", t)// TODO
    }.topDown
}
