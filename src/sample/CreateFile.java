package sample;

import java.util.*;

public class CreateFile {

    private Formatter f;

    public void openFile(String file){
        try{
            f = new Formatter( file );
        }
        catch(Exception e){
            System.out.println("error encountered when opening file");
        }
    }

    public void addData(String data){
        f.format("%s", data);
    }

    public void closeFile(){
        f.close();
    }

    // example of usage
    // CreateFile passwordStorage = new CreateFile();
    // passwordStorage.openFile(password.txt);
    // passwordStorage.addData(password);
    // passwordStorage.closeFile();
}
