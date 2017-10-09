package Model.Expression;

import Model.ADT.Interfaces.MyIDictionary;

public class VarExpr extends Expr {
    private String id;

    @Override
    int eval(MyIDictionary<String, Integer> symTable) { return symTable.get(id); }
}
