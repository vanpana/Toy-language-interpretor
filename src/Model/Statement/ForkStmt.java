package Model.Statement;

import Model.Exceptions.ToyException;
import Model.PrgState;

public class ForkStmt implements IStmt {
    private IStmt stmt;

    public ForkStmt(IStmt stmt) {
        this.stmt = stmt;
    }

    @Override
    public PrgState execute(PrgState state) {
        PrgState forkedState = new PrgState(stmt);

        forkedState.setId(state.getId() * 10);
        forkedState.setSymTable(state.getSymTable().cloneMap());
        forkedState.setHeap(state.getHeap());
        forkedState.setFileTable(state.getFileTable());
        forkedState.setOut(state.getOut());

        return forkedState;
    }
}
