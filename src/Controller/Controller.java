package Controller;

import Model.ADT.Interfaces.MyIStack;
import Model.Exceptions.MyStmtExecException;
import Model.PrgState;
import Model.Statement.IStmt;
import Repository.IRepository;

public class Controller {
    IRepository repo;

    public Controller(IRepository repo) {
        this.repo = repo;
    }

    public void setMain(PrgState state){
        repo.getCurrentProgram().clear();
        repo.getCurrentProgram().add(state);
    }

    private PrgState oneStep(PrgState state) throws MyStmtExecException {
        MyIStack<IStmt> stack = state.getStack();
        if (stack.isEmpty()) throw new MyStmtExecException("Stack is empty!");
        IStmt currentStatement = stack.pop();
        return currentStatement.execute(state);
    }

    public void allSteps() throws MyStmtExecException{
        // getting just the first program
        PrgState prg = repo.getCurrentProgram().get(0);
        while(!prg.getStack().isEmpty()){
            try{
                prg = oneStep(prg);
                System.out.print(prg.toString());
                //display program state eventually
            }
            catch (MyStmtExecException e){
                throw new MyStmtExecException(e.getMessage());
            }
        }
        System.out.print(prg.getOut());
    }
}
