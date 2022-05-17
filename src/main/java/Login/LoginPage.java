package Login;
import MainPage.MainPage;
import org.openqa.selenium.By;
import utils.User;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
     //public static final String button = "//input[@value='Войти в Одноклассники']";
     //private static final  String loginField ="//input[@name='st.email']";
     //private static final String passwordField = "//input[@name='st.password']";

     private static final By BUTTON = By.xpath("//input[@value='Войти в Одноклассники']");
     private static final  By LOGIN = By.xpath("//input[@name='st.email']");
     private static final By PASSWORD = By.xpath("//input[@name='st.password']");

     public static By GET_BUTTON(){
          return BUTTON;
     };
     public MainPage login(User user){
          $(LOGIN).setValue(user.getLogin());
          $(PASSWORD).setValue(user.getPassword());
          $(BUTTON).click();
          return new MainPage(user);
     };
}
