package Model.Expression;

import Model.ADT.Interfaces.MyIDictionary;
import Model.Exceptions.ADTEmptyException;
import Model.Exceptions.DivisionByZero;
import Model.Exceptions.ToyException;

abstract public class Expr {
    abstract public int eval(MyIDictionary<String, Integer> symTable, MyIDictionary<Integer, Integer> heap) throws ToyException;
    abstract public String toString();
}
