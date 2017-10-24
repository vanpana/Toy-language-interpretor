package Repository;

import Model.PrgState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository {
    private PrgState prgState;
    private String logFilePath;

    public Repository() {
        this.prgState = null;
        logFilePath = "";
    }

    public Repository(String logFilePath){
        this.prgState = null;
        this.logFilePath = logFilePath;
    }

    @Override
    public PrgState getCurrentProgram() {
        return prgState;
    }

    @Override
    public void setCurrentProgram(PrgState prgState) {
        this.prgState = prgState;
    }

    @Override
    public void logPrgStateExec()
    {

        try{
            PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));

            //TODO: How to print them together?
            logFile.println(prgState.toString());

            logFile.close();
        }
        catch (IOException ioe)
        {
            //TODO: cascade throw e
            System.out.println(ioe.getMessage());
        }


    }
}
