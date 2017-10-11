package Model.Expression;

import Model.ADT.Interfaces.MyIDictionary;
import Model.Exceptions.DivisionByZero;

abstract public class Expr {
    abstract public int eval(MyIDictionary<String, Integer> symTable) throws DivisionByZero;
    abstract public String toString();
}
