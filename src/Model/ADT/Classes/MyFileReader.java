package Model.ADT.Classes;

import java.io.BufferedReader;
import java.io.IOException;

public class MyFileReader {
    private final String filename;
    private final BufferedReader breader;

    public MyFileReader(String filename, BufferedReader breader) {
        this.filename = filename;
        this.breader = breader;
    }

    public void close(){
        try {
            breader.close();
        }
        catch (IOException ioe){
            //TODO: cascade throw
            System.out.println(ioe.getMessage());
        }

    }

    public Integer getInteger() {
        try{
            String str = breader.readLine();

            return Integer.parseInt(str);
        }
        catch (IOException ioe){
            return null;
        }
    }

    @Override
    public String toString() {
        return filename;
    }
}
