import scala.meta.internal.ast._
import scala.meta.tql._
import scala.obey.model._
import scala.language.reflectiveCalls

@Tag("Scala", "Mine", "ErrorProne") object ProhibitHeandAndLast extends WarnRule {
  def description = "Prohibit the use of .head and .last, which are equivalent to calling a function on a null."

  def apply = transform {
      case t: Source => t andCollect Message("", t)// TODO
    }.topDown
}
