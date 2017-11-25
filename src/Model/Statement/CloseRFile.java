package Model.Statement;

import Model.ADT.Classes.MyFileReader;
import Model.Exceptions.FileException;
import Model.Exceptions.ToyException;
import Model.Expression.Expr;
import Model.PrgState;

public class CloseRFile implements IStmt {
    private final Expr expr_file_id;

    public CloseRFile(Expr expr_file_id) {
        this.expr_file_id = expr_file_id;
    }

    @Override
    public PrgState execute(PrgState state) throws ToyException {
        int fd = expr_file_id.eval(state.getSymTable(), state.getHeap());

        MyFileReader reader = state.getFileTable().get(fd);
        if (reader == null)
            throw new FileException("No descriptor found!");
        reader.close();
        state.getFileTable().remove(fd);
        return null;
    }

    @Override
    public String toString() {
        return "closeFile(" + expr_file_id.toString() + ")";
    }
}
