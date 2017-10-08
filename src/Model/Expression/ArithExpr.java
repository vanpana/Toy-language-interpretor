package Model.Expression;

enum Operation {PLUS, MINUS, TIMES, DIVIDED}

public class ArithExpr extends Expr{
    private Expr e1, e2;
    private Operation operation;


    @Override
    int eval(MyIDictionary<String, Integer> symTable){
        if (operation == Operation.PLUS) return e1.eval(symTable) + e2.eval(symTable);
        else if (operation == Operation.MINUS) return e1.eval(symTable) - e2.eval(symTable);
        else if (operation == Operation.TIMES) return e1.eval(symTable) * e2.eval(symTable);
        else if (operation == Operation.DIVIDED) return e1.eval(symTable) / e2.eval(symTable);
    }
}
