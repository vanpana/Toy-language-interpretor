package Model.Expression;

import Model.ADT.Interfaces.MyIDictionary;
import Model.ADT.Interfaces.MyIHeap;
import Model.Exceptions.DivisionByZero;
import Model.Exceptions.ToyException;


public class ArithExpr extends Expr{
    private final Expr e1;
    private final Expr e2;
    private final Operation operation;

    public ArithExpr(Operation operation, Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
        this.operation = operation;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> symTable, MyIHeap<Integer> heap) throws ToyException {
        try{
            int eval1 = e1.eval(symTable, heap), eval2 = e2.eval(symTable, heap);

            switch (operation) {
                case PLUS:
                    return eval1 + eval2;
                case MINUS:
                    return eval1 - eval2;
                case MULTIPLY:
                    return eval1 * eval2;
                case DIVIDE:
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
        switch (operation) {
            case PLUS:
                returnable += " + ";
                break;
            case MINUS:
                returnable += " - ";
                break;
            case MULTIPLY:
                returnable += " * ";
                break;
            case DIVIDE:
                returnable += " / ";
                break;
        }
        returnable += e2.toString();

        return returnable;
    }
}
