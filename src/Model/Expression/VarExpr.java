package Model.Expression;

import Model.ADT.Interfaces.MyIDictionary;

public class VarExpr extends Expr {
    private String id;

    @Override
    public int eval(MyIDictionary<String, Integer> symTable) { return symTable.get(id); }

    @Override
    public String toString() {
        return this.id;
    }
}
