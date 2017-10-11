package Controller;

import Model.ADT.Interfaces.MyIStack;
import Model.Exceptions.ADTEmptyException;
import Model.Exceptions.ExpressionException;
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

    private PrgState oneStep(PrgState state) throws ExpressionException, ADTEmptyException {
        MyIStack<IStmt> stack = state.getStack();
        IStmt currentStatement = null;
        try{
            currentStatement = stack.pop();
            return currentStatement.execute(state);
        }
        catch (ADTEmptyException e){
            throw new ADTEmptyException(e.getMessage());
        }
        catch (ExpressionException e){
            throw new ExpressionException(e.getMessage());
        }

    }

    public void allSteps() throws ExpressionException, ADTEmptyException{
        // getting just the first program
        PrgState prg = repo.getCurrentProgram().get(0);
        while(!prg.getStack().isEmpty()){
            try{
                prg = oneStep(prg);
                //System.out.print(prg.toString());
                //display program state eventually
            }
            catch (ADTEmptyException e){
                throw new ADTEmptyException(e.getMessage());
            }
            catch (ExpressionException e){
                throw new ExpressionException(e.getMessage());
            }
        }
        System.out.print(prg.getOut());
    }
}
