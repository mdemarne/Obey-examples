import scala.meta.internal.ast._
import scala.meta.tql._
import scala.obey.model._
import scala.language.reflectiveCalls

@Tag("Scala", "Mine", "Style") object ProhibitSameStringLit extends WarnRule {
  def description = "Prohibit the use of same string literal in a program"

  def apply = transform {
      case t: Source => t andCollect Message("", t)// TODO
    }.topDown
}
