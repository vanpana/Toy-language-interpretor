package Model.Expression;

import Model.ADT.Interfaces.MyIDictionary;
import Model.ADT.Interfaces.MyIHeap;

public class ConstExpr extends Expr {
    private final int number;

    public ConstExpr(int number) {
        this.number = number;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> symTable, MyIHeap<Integer> heap){ return number; }

    @Override
    public String toString() {
        return Integer.toString(this.number);
    }
}
