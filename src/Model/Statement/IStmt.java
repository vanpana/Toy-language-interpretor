package Model.Statement;

import Model.PrgState;

public interface IStmt {
    //toString override
    PrgState execute(PrgState state);
}
