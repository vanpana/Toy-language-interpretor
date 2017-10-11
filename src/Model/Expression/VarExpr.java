package Model.Expression;

import Model.ADT.Interfaces.MyIDictionary;
import Model.Exceptions.ADTEmptyException;
import Model.Exceptions.ExpressionException;

public class VarExpr extends Expr {
    private String id;

    public VarExpr(String id) {
        this.id = id;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> symTable) throws ADTEmptyException {
        try{
            return symTable.get(id);
        }
        catch (ADTEmptyException e){
            throw new ADTEmptyException(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return this.id;
    }
}
