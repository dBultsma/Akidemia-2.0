package sample;

import java.util.ArrayList;

public class DataBase {

    ArrayList <User> data = new ArrayList <User>();

    public void addUserToDataBase(String password) {
        User newUser = new User(password);
        data.add(newUser);
    }

    public void viewDataBase(){
        for(int i=0; i < data.size(); i++){
            System.out.println("Data base " + i + ": " + data.get(i).getPassword());
        }
        System.out.println("End of data base");
    }

    public void checkPasswordFromDataBase(){
        for(int i = 0; i < data.size(); i++)
            if(data.get(i).getPassword().equals(password))
                System.out.println("found");


    }
}
