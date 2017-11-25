package Repository;

import Model.PrgState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository {
    private ArrayList<PrgState> prgList;
    private final String logFilePath;

    public Repository(String logFilePath){
        this.prgList = new ArrayList<>();
        this.logFilePath = logFilePath;
    }

    @Override
    public void setCurrentProgram(PrgState prgState) {
        if (prgList.size() == 0) prgList.add(prgState);
        else this.prgList.set(0, prgState);
    }

    @Override
    public void logPrgStateExec(PrgState prgState) throws IOException
    {
        PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
        logFile.println(prgState.toString());
        logFile.close();
    }

    @Override
    public ArrayList<PrgState> getPrgList() {
        return prgList;
    }

    @Override
    public void setPrgList(List<PrgState> prgList) {
        this.prgList = new ArrayList<>(prgList);
    }
}
