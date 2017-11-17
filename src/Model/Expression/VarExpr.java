package Model.Expression;

import Model.ADT.Interfaces.MyIDictionary;
import Model.ADT.Interfaces.MyIHeap;
import Model.Exceptions.ADTEmptyException;

public class VarExpr extends Expr {
    private String id;

    public VarExpr(String id) {
        this.id = id;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> symTable, MyIHeap<Integer> heap) throws ADTEmptyException {
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
