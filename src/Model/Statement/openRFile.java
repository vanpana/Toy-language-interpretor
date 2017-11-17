package Model.Statement;

import Model.ADT.Classes.MyFileReader;
import Model.Exceptions.ExpressionException;
import Model.Exceptions.FileException;
import Model.Exceptions.ToyException;
import Model.PrgState;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class openRFile implements IStmt{
    private static int fd = 2;
    private String var_file_id;
    private String filename;

    public openRFile(String var_file_id, String filename) {
        this.var_file_id = var_file_id;
        this.filename = filename;
    }

    @Override
    public PrgState execute(PrgState state) throws ToyException {
        if (state.getFileTable().values().size() > 0)
            for(MyFileReader mfr : state.getFileTable().values())
                if (filename.equals(mfr.toString()))
                    throw new ExpressionException("File already open.");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            state.getFileTable().put(++fd, new MyFileReader(filename, reader));
            state.getSymTable().put(var_file_id, fd);
            return state;
        }
        catch (IOException ioe)
        {
            throw new FileException("File not found.");
        }

    }

    @Override
    public String toString() {
        return "openRFile( " + var_file_id + ", " + filename + ")";
    }
}
