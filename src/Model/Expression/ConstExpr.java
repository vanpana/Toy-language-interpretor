package Model.Expression;

import Model.ADT.Interfaces.MyIDictionary;

public class ConstExpr extends Expr {
    private int number;

    public ConstExpr(int number) {
        this.number = number;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> symTable){ return number; }

    @Override
    public String toString() {
        return Integer.toString(this.number);
    }
}
