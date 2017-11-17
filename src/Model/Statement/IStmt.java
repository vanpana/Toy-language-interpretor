package Model.Statement;

import Model.Exceptions.ToyException;
import Model.PrgState;

public interface IStmt {
    PrgState execute(PrgState state) throws ToyException;
    String toString();
}
