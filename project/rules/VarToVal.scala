import scala.meta.internal.ast._
import scala.meta.tql._
import scala.obey.model._
import scala.language.reflectiveCalls

@Tag("Var", "Val") object VarToVal extends Rule {
  def description = "Changing vars assigned once to vals"

  def message(n: Tree, t: Tree): Message = Message(s"The 'var' $n from ${t} was never reassigned and should therefore be a 'val'", t)

  def apply = {
    collect[Set] {
      case Term.Assign(b: Term.Name, _) => b
    }.topDown feed { assign =>
      (transform {
        case t @ Defn.Var(a, (b: Term.Name) :: Nil, c, Some(d)) if (!assign.contains(b)) =>
          Defn.Val(a, b :: Nil, c, d) andCollect message(b, t)
      }).topDown
    }
  }
}
