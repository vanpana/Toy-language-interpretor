package Model.Expression;

import Model.ADT.Interfaces.MyIDictionary;
import Model.ADT.Interfaces.MyIHeap;
import Model.Exceptions.ToyException;

abstract public class Expr {
    abstract public int eval(MyIDictionary<String, Integer> symTable, MyIHeap<Integer> heap) throws ToyException;
    abstract public String toString();
}
