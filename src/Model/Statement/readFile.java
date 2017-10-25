package Model.Statement;

import Model.ADT.Classes.MyFileReader;
import Model.Exceptions.ADTEmptyException;
import Model.Exceptions.ExpressionException;
import Model.Expression.Expr;
import Model.PrgState;

public class readFile implements IStmt {
    private Expr expr_file_id;
    private String var_name;

    public readFile(Expr expr_file_id, String var_name) {
        this.expr_file_id = expr_file_id;
        this.var_name = var_name;
    }

    @Override
    public PrgState execute(PrgState state) throws ExpressionException, ADTEmptyException {
        int fd = expr_file_id.eval(state.getSymTable());
        MyFileReader reader = state.getFileTable().get(fd);
        if (reader == null)
            throw new ExpressionException("No descriptor found!");
        state.getSymTable().put(var_name, reader.getInteger());
        return state;
    }
}
