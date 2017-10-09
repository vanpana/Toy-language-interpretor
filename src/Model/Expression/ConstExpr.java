package Model.Expression;

import Model.ADT.Interfaces.MyIDictionary;

public class ConstExpr extends Expr {
    private int number;

    @Override
    int eval(MyIDictionary<String, Integer> symTable){ return number; }
}
