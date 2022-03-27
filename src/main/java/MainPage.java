public class MainPage {
    String name;
    String surname;
    MainPage(User user){
        this.name=user.name;
        this.surname=user.surname;
    };
    String getFullName(){
        return  name + " " + surname;
    };
}
