package Model.Expression;

import Model.ADT.Interfaces.MyIDictionary;
import Model.ADT.Interfaces.MyIHeap;
import Model.Exceptions.ToyException;

public class BoolExpr extends Expr{
    private Expr expr1, expr2;
    private String operator;

    public BoolExpr(Expr expr1, Expr expr2, String operator) {
        this.expr1 = expr1;
        this.expr2 = expr2;
        this.operator = operator;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> symTable, MyIHeap<Integer> heap) throws ToyException {
        int lhs = expr1.eval(symTable, heap), rhs = expr2.eval(symTable, heap), result = -1;
        switch (operator)
        {
            case "<":
                result = lhs < rhs ? 1 : 0;
                break;
            case "<=":
                result = lhs <= rhs ? 1 : 0;
                break;
            case "==":
                result = lhs == rhs ? 1 : 0;
                break;
            case "!=":
                result = lhs != rhs ? 1 : 0;
                break;
            case ">":
                result = lhs > rhs ? 1 : 0;
                break;
            case ">=":
                result = lhs >= rhs ? 1 : 0;
                break;
        }

        if (result == -1) throw new ToyException("Can't evaluate: " + this.toString());
        return result;
    }

    @Override
    public String toString() {
        return "(" + expr1 + " " + operator + " " + expr2 + ")";
    }
}
