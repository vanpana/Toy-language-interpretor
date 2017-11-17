package Model.Expression;

import Model.ADT.Interfaces.MyIDictionary;
import Model.ADT.Interfaces.MyIHeap;
import Model.Exceptions.DivisionByZero;
import Model.Exceptions.ToyException;


public class ArithExpr extends Expr{
    private Expr e1, e2;
    private Operation operation;

    public ArithExpr(Operation operation, Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
        this.operation = operation;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> symTable, MyIHeap<Integer> heap) throws ToyException {
        try{
            int eval1 = e1.eval(symTable, heap), eval2 = e2.eval(symTable, heap);

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
        catch (ToyException te){
            throw new ToyException(te.getMessage());
        }

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
