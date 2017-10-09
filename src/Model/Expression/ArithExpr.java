package Model.Expression;

import Model.ADT.Interfaces.MyIDictionary;

enum Operation {PLUS, MINUS, MULTIPLY, DIVIDE}

public class ArithExpr extends Expr{
    private Expr e1, e2;
    private Operation operation;

    public ArithExpr(Expr e1, Expr e2, Operation operation) {
        this.e1 = e1;
        this.e2 = e2;
        this.operation = operation;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> symTable){
        if (operation == Operation.PLUS) return e1.eval(symTable) + e2.eval(symTable);
        else if (operation == Operation.MINUS) return e1.eval(symTable) - e2.eval(symTable);
        else if (operation == Operation.MULTIPLY) return e1.eval(symTable) * e2.eval(symTable);
        else if (operation == Operation.DIVIDE) return e1.eval(symTable) / e2.eval(symTable);
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
