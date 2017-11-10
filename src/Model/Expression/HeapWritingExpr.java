package Model.Expression;

import Model.ADT.Interfaces.MyIDictionary;
import Model.Exceptions.HeapException;
import Model.Exceptions.ToyException;

public class HeapWritingExpr extends Expr {
    private String var_name;
    private Expr expr;

    public HeapWritingExpr(String var_name, Expr expr) {
        this.var_name = var_name;
        this.expr = expr;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> symTable, MyIDictionary<Integer, Integer> heap) throws ToyException {
        try{
            int location = symTable.get(var_name);
            if (heap.isDefined(location))
                heap.put(location, expr.eval(symTable, heap));
            else throw new HeapException("Value is not found!");

            return 0;
        }
        catch (ToyException e){
            throw new HeapException(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Write " + expr + " to " + var_name + " on heap";
    }
}
