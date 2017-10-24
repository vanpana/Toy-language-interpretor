package Repository;

import Model.PrgState;

import java.util.List;

public interface IRepository {
    PrgState getCurrentProgram();
    void setCurrentProgram(PrgState prgState);
    void logPrgStateExec();
}
