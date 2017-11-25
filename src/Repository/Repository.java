package Repository;

import Model.PrgState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Repository implements IRepository {
    private ArrayList<PrgState> prgList;
    private String logFilePath;

    public Repository(String logFilePath){
        this.prgList = null;
        this.logFilePath = logFilePath;
    }

    @Override
    public void setCurrentProgram(PrgState prgState) {
        this.prgList.set(0, prgState);
    }

    @Override
    public void logPrgStateExec(PrgState prgState) throws IOException
    {

        try{
            PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
            logFile.println(prgState.toString());

            logFile.close();
        }
        catch (IOException ioe)
        {
            throw ioe;
        }
    }

    @Override
    public ArrayList<PrgState> getPrgList() {
        return prgList;
    }

    @Override
    public void setPrgList(ArrayList<PrgState> prgList) {
        this.prgList = prgList;
    }
}
