package Controller;

import Model.ADT.Interfaces.MyIStack;
import Model.Exceptions.ADTEmptyException;
import Model.Exceptions.ExpressionException;
import Model.Exceptions.MyStmtExecException;
import Model.Exceptions.ToyException;
import Model.PrgState;
import Model.Statement.IStmt;
import Repository.IRepository;

public class Controller {
    private IRepository repo;

    public Controller(IRepository repo) {
        this.repo = repo;
    }

    public void setMain(PrgState state) {
        repo.setCurrentProgram(state);
    }

    private PrgState oneStep(PrgState state) throws ToyException {
        MyIStack<IStmt> stack = state.getStack();
        IStmt currentStatement;
        try {
            currentStatement = stack.pop();
            return currentStatement.execute(state);
        } catch (ToyException e) {
            throw e;
        }

    }

    public void allSteps() throws ToyException {
        // getting just the first program
        PrgState prg = repo.getCurrentProgram();
        while (!prg.getStack().isEmpty()) {
            try {
                prg = oneStep(prg);
                repo.logPrgStateExec();
                //System.out.print(prg.toString());
                //display program state eventually
            } catch (ToyException e) {
                throw new ToyException(e.getMessage());
            }
            System.out.print(prg.getOut());
        }
    }
}

