package Model.Expression;

public class ConstExpr extends Expr {
    private int number;

    @Override
    int eval(MyIDictionary<String, Integer> symTable){ return number; }
}
