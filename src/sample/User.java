package sample;

public class User {
    private String username = "";
    private String password = "";

    public User(){}

    public User(String newPassword){//(String newUsername, String newPassword){
        //setUsername(newUsername);
        setPassword(newPassword);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
        System.out.println( getPassword());
    }
}
