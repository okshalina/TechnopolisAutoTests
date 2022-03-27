
public class LoginPage {
     LoginPage(String log, String pass){
          this.login=log;
          this.password=pass;
     };
     LoginPage(User user){
          this.login=user.login;
          this.password=user.password;
     };
     String login;
     String password;
     String button;

}
