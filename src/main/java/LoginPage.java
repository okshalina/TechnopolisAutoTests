import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
     public static final String button = "//input[@value='Войти в Одноклассники']";
     MainPage login(User user){
          $(By.xpath("//input[@name='st.email']")).setValue(user.login);
          $(By.xpath("//input[@name='st.password']")).setValue(user.password);
          $(By.xpath("//input[@value='Войти в Одноклассники']")).click();
          return new MainPage(user);
     };


}
