package Controller;

import Model.ADT.Classes.MyFileReader;
import Model.ADT.Interfaces.MyIDictionary;
import Model.ADT.Interfaces.MyIStack;
import Model.Exceptions.ToyException;
import Model.Expression.ConstExpr;
import Model.PrgState;
import Model.Statement.IStmt;
import Model.Statement.closeRFile;
import Repository.IRepository;

import java.util.Collection;
import java.util.HashMap;
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

    private Map<Integer,Integer> conservativeGarbageCollector(Collection<Integer> symTableValues, Map<Integer, Integer> heap){
        return heap.entrySet().stream()
                .filter(e->symTableValues.contains(e.getKey())).
                        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private void closeAllFiles(PrgState prg) {
        prg.getFileTable().entrySey().forEach(
                key -> {
                    try {
                        new closeRFile(new ConstExpr(key.getKey())).execute(prg);
                    } catch (ToyException e) {
                        System.out.println(e.getMessage());
                    }
                });
    }

    private PrgState oneStep(PrgState state) throws ToyException {
        MyIStack<IStmt> stack = state.getStack();
        IStmt currentStatement;
        currentStatement = stack.pop();
        return currentStatement.execute(state);
    }

    public void allSteps() throws ToyException {
        // getting just the first program
        PrgState prg = repo.getCurrentProgram();
        while (!prg.getStack().isEmpty()) {
            try {
                prg = oneStep(prg);
                prg.getHeap().setContent((HashMap<Integer, Integer>)conservativeGarbageCollector(
                        prg.getSymTable().getContent().values(),
                        prg.getHeap().getItems())
                );
                repo.logPrgStateExec();
                System.out.print(prg.toString());
                //display program state eventually
            } catch (ToyException e) {
                throw new ToyException(e.getMessage());
            }
        }
        closeAllFiles(prg);
    }
}

