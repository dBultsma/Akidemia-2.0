package sample;

import java.io.*;
import java.util.*;

public class ReadFile {

    private Scanner s;

    public void openFile(String file){
        try{
            s = new Scanner(new File("%s", file));
        }
        catch(Exception e){
            System.out.println("file not found");
        }
    }

    public String readData(){
        // hasNext until end of file
        while(s.hasNext()){
            String data = s.next();
            return data;
        }
    }

    public void closeFile(){
        s.close();
    }

    //ReadFile readPassword = new ReadFile();
    //readPassword.openFile(filename);
    //readPassword.readData();
    //readPassword.closeFile();
}
