package Model.Expression;

import Model.ADT.Interfaces.MyIDictionary;
import Model.Exceptions.ADTEmptyException;
import Model.Exceptions.DivisionByZero;


public class ArithExpr extends Expr{
    private Expr e1, e2;
    private Operation operation;

    public ArithExpr(Operation operation, Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
        this.operation = operation;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> symTable) throws ADTEmptyException, DivisionByZero {
        int eval1 = e1.eval(symTable), eval2 = e2.eval(symTable);

        if (operation == Operation.PLUS) return eval1 + eval2;
        else if (operation == Operation.MINUS) return eval1 - eval2;
        else if (operation == Operation.MULTIPLY) return eval1 * eval2;
        else if (operation == Operation.DIVIDE)
        {
            if (eval2 == 0) throw new DivisionByZero("Can't divide by zero.");
            return eval1 / eval2;
        }
        return -1;
    }

    @Override
    public String toString() {
        String returnable = e1.toString();
        if (operation == Operation.PLUS) returnable += " + ";
        else if (operation == Operation.MINUS) returnable += " - ";
        else if (operation == Operation.MULTIPLY) returnable += " * ";
        else if (operation == Operation.DIVIDE) returnable += " / ";
        returnable += e2.toString();

        return returnable;
    }
}
