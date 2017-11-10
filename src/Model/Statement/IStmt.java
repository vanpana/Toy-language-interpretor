package Model.Statement;

import Model.Exceptions.ADTEmptyException;
import Model.Exceptions.ExpressionException;
import Model.Exceptions.ToyException;
import Model.PrgState;

public interface IStmt {
    PrgState execute(PrgState state) throws ToyException;
    String toString();
}
