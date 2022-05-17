package test;
import Login.LoginPage;
import MainPage.MainPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    protected LoginPage loginPage = new LoginPage();
    protected MainPage mainPage = new MainPage();

    @BeforeEach
    protected void init(){
        Selenide.open("https://ok.ru/");
    };

    @AfterEach
    protected void close(){
        Selenide.close();
    };
}
