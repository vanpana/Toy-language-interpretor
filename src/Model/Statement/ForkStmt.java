package Model.Statement;

import Model.PrgState;

public class ForkStmt implements IStmt {
    private final IStmt stmt;

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

    @Override
    public String toString() {
        return "fork(" + stmt + ")";
    }
}
