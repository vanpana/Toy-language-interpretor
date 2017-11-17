package Repository;

import Model.PrgState;

public interface IRepository {
    PrgState getCurrentProgram();
    void setCurrentProgram(PrgState prgState);
    void logPrgStateExec();
}
