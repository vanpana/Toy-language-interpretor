package Model.Expression;

import Model.ADT.Interfaces.MyIDictionary;
import Model.ADT.Interfaces.MyIHeap;
import Model.Exceptions.HeapException;
import Model.Exceptions.ToyException;

public class HeapReadingExpr extends Expr {
    private String var_name;

    public HeapReadingExpr(String var_name) {
        this.var_name = var_name;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> symTable, MyIHeap<Integer> heap) throws HeapException {
        try{
            int location = symTable.get(var_name);
            int value;
            if (heap.isDefined(location))
                value = heap.get(location);
            else throw new HeapException("Value is not found!");

            return value;
        }
        catch (ToyException e){
            throw new HeapException(e.getMessage());
        }

    }

    @Override
    public String toString() {
        return "read " + var_name + " from heap";
    }
}
