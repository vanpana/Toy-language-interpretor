package Model.Statement;

import Model.Exceptions.ADTEmptyException;
import Model.Exceptions.ExpressionException;
import Model.PrgState;

public interface IStmt {
    PrgState execute(PrgState state) throws ExpressionException, ADTEmptyException;
    String toString();
}
