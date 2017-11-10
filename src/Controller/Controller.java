package Controller;

import Model.ADT.Interfaces.MyIStack;
import Model.Exceptions.ToyException;
import Model.PrgState;
import Model.Statement.IStmt;
import Repository.IRepository;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {
    private IRepository repo;

    public Controller(IRepository repo) {
        this.repo = repo;
    }

    public void setMain(PrgState state) {
        repo.setCurrentProgram(state);
    }

    Map<Integer,Integer> conservativeGarbageCollector(Collection<Integer> symTableValues, Map<Integer,Integer> heap){
        return heap.entrySet().stream()
                .filter(e->symTableValues.contains(e.getKey())).
                        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
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
                System.out.print(prg.toString());
                //display program state eventually
            } catch (ToyException e) {
                throw new ToyException(e.getMessage());
            }
        }
    }
}

