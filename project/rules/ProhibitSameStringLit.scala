import scala.meta.internal.ast._
import scala.meta.tql._
import scala.obey.model._
import scala.language.reflectiveCalls

@Tag("Scala", "Mine", "Style") object ProhibitSameStringLit extends WarnRule {
  def description = "Prohibit the use of same string literal in a program"

  def apply = Matcher { tree =>
    val findStrs = collect[List] {
      case t: Lit.String => t
    }.topDown
    val msgs: List[Message] = findStrs(tree).result.groupBy(x => x.value).filter(_._2.length > 1).map { str =>
      Message("Repeated String", str._2.head)
    }.toList
    Option((tree, msgs))
  }
}
