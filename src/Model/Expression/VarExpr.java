package Model.Expression;

public class VarExpr extends Expr {
    private String id;

    @Override
    int eval(MyIDictionary<String, Integer> symTable) { return symTable.lookup(id); }
}
