package Model.Expression;

abstract public class Expr {
    abstract int eval(MyIDictionary<String, Integer> symTable);
    //override toString
}
