package Model.Expression;

import Model.ADT.Interfaces.MyIDictionary;
import Model.Exceptions.ADTEmptyException;
import Model.Exceptions.DivisionByZero;

abstract public class Expr {
    abstract public int eval(MyIDictionary<String, Integer> symTable) throws DivisionByZero, ADTEmptyException;
    abstract public String toString();
}
