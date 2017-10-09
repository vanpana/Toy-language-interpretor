package Repository;

import Model.PrgState;

import java.util.List;

public interface IRepository {
    List<PrgState> getCurrentProgram();
}
