import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    String login;
    String password;
    String name;
    String surname;
    List<MessageElement> messageElements = new ArrayList<MessageElement>();
    User(String login, String password, String name, String surname, ArrayList<MessageElement> list){
        this.login=login;
        this.name=name;
        this.surname=surname;
        this.password=password;
        this.messageElements = list;
    };
    String getFullNameFromUser(){
       return name + " " + surname;
    };
}
