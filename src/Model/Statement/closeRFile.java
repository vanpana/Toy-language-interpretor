package Model.Statement;

import Model.ADT.Classes.MyFileReader;
import Model.Exceptions.ADTEmptyException;
import Model.Exceptions.ExpressionException;
import Model.Exceptions.FileException;
import Model.Exceptions.ToyException;
import Model.Expression.Expr;
import Model.PrgState;

public class closeRFile implements IStmt {
    private Expr expr_file_id;

    public closeRFile(Expr expr_file_id) {
        this.expr_file_id = expr_file_id;
    }

    @Override
    public PrgState execute(PrgState state) throws ToyException {
        int fd = expr_file_id.eval(state.getSymTable());

        MyFileReader reader = state.getFileTable().get(fd);
        if (reader == null)
            throw new FileException("No descriptor found!");
        reader.close();
        state.getFileTable().remove(fd);
        return state;
    }

    @Override
    public String toString() {
        return "closeFile(" + expr_file_id.toString() + ")";
    }
}
