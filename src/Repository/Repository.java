package Repository;

import Model.PrgState;

import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository {
    List<PrgState> programList;

    public Repository() {
        this.programList = new ArrayList<>();
    }

    @Override
    public List<PrgState> getCurrentProgram() {
        return programList;
    }
}
