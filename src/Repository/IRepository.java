package Repository;

import Model.PrgState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface IRepository {
    void setCurrentProgram(PrgState prgState);
    void logPrgStateExec(PrgState prgState) throws IOException;
    ArrayList<PrgState> getPrgList();
    void setPrgList(List<PrgState> prgList);
}
