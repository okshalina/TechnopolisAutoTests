import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    String login;
    String password;
    String name;
    String surname;
    List<String> xpathMessages = new ArrayList<String>();
    User(String login, String password, String name, String surname, ArrayList<String> list){
        this.login=login;
        this.name=name;
        this.surname=surname;
        this.password=password;
        this.xpathMessages = list;
    };
    String getFullNameFromUser(){
       return name + " " + surname;
    };
}
