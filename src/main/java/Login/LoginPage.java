package Login;
import MainPage.MainPage;
import org.openqa.selenium.By;
import utils.BasePage;
import utils.User;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
     public LoginPage(){
          isLoaded();
     }
     private static final By BUTTON = By.xpath("//input[@value='Войти в Одноклассники']");
     private static final  By LOGIN = By.xpath("//input[@name='st.email']");
     private static final By PASSWORD = By.xpath("//input[@name='st.password']");

     @Override
     protected void isLoaded(){
          $(LOGIN).shouldBe(visible.because("Не отображается поле ввода логина"));
          $(PASSWORD).shouldBe(visible.because("Не отображается поле ввода пароля"));
          $(BUTTON).shouldBe(visible.because("Не отображается кнопка 'Войти'"));
     }
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
