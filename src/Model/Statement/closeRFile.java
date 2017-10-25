package Model.Statement;

import Model.ADT.Classes.MyFileReader;
import Model.Exceptions.ADTEmptyException;
import Model.Exceptions.ExpressionException;
import Model.Expression.Expr;
import Model.PrgState;

public class closeRFile implements IStmt {
    private Expr expr_file_id;

    public closeRFile(Expr expr_file_id) {
        this.expr_file_id = expr_file_id;
    }

    @Override
    public PrgState execute(PrgState state) throws ExpressionException, ADTEmptyException {
        int fd = expr_file_id.eval(state.getSymTable());

        MyFileReader reader = state.getFileTable().get(fd);
        if (reader == null)
            throw new ExpressionException("No descriptor found!");
        reader.close();
        state.getFileTable().remove(fd);
        return state;
    }
}
