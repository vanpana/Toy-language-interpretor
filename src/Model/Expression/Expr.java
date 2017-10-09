package Model.Expression;

import Model.ADT.Interfaces.MyIDictionary;

abstract public class Expr {
    abstract public int eval(MyIDictionary<String, Integer> symTable);
    //override toString
}
