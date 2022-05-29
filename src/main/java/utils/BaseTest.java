package utils;
import Login.LoginPage;
import MainPage.MainPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    protected LoginPage loginPage = new LoginPage();
    protected MainPage mainPage = new MainPage();
    private static final String urlOK = "https://ok.ru/";
    @BeforeEach
    protected void init(){
        Selenide.open(urlOK);
    }

    @AfterEach
    protected void close(){
        Selenide.close();
    }
}
