package Model.Statement;

import Model.ADT.Classes.MyFileReader;
import Model.Exceptions.ToyException;
import Model.Expression.Expr;
import Model.PrgState;

public class ReadFile implements IStmt {
    private final Expr expr_file_id;
    private final String var_name;

    public ReadFile(Expr expr_file_id, String var_name) {
        this.expr_file_id = expr_file_id;
        this.var_name = var_name;
    }

    @Override
    public PrgState execute(PrgState state) throws ToyException {
        int fd = expr_file_id.eval(state.getSymTable(), state.getHeap());
        MyFileReader reader = state.getFileTable().get(fd);
        if (reader == null)
            throw new ToyException("No descriptor found!");
        state.getSymTable().put(var_name, reader.getInteger());
        return null;
    }

    @Override
    public String toString() {
        return "ReadFile(" + expr_file_id.toString() + ", " + var_name + ")";
    }
}
