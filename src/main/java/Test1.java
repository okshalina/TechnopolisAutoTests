import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import com.codeborne.selenide.*;
import org.openqa.selenium.By.*;
import static com.codeborne.selenide.Selenide.*;

public class Test1 {
    @Test
    public void ExTest() {
        User user1 = new User("OksanaShalina", "123", "Oksana", "Shalina");
        LoginPage lp = new LoginPage(user1);
        MainPage mp = new MainPage(user1);

        // Код с использованием Selenide
        Configuration.browser="chrome";
        Selenide.open("https://ok.ru");
        $(By.xpath("//input[@name='st.email']")).setValue(lp.login);
        $(By.xpath("//input[@name='st.password']")).setValue(lp.password);
        $(By.xpath("//input[@value='Войти в Одноклассники']")).click();
        if($(By.xpath("//input[@value='Войти в Одноклассники']")).exists()) System.out.println("Wrong password or login");
        else {
            try {
                String nname1 = mp.getFullName();
                String nname2 = $(By.xpath("//*[@id='hook_Block_Navigation']/div/div/a[1]/div")).getText();
                System.out.println("User's data: " + nname1+ ", " + "length: " + nname1.length());
                System.out.println("MainPage data: " + nname2 + ", " + "length: " + nname2.length());
                if (nname1.equals(nname2)) System.out.println("Right user!");
                else System.out.println("Wrong user!");
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Код с использованием Selenium; если хотите его запустить, закомментите кчасть кода выше (16-33 строки)

        /*WebDriver driver = new ChromeDriver();
        driver.get("https://ok.ru");
        driver.findElement(By.xpath("//input[@name='st.email']")).sendKeys(lp.login);
        driver.findElement(By.xpath("//input[@name='st.password']")).sendKeys(lp.password);
        driver.findElement(By.xpath("//input[@value='Войти в Одноклассники']")).click();
        if(driver.findElements(By.xpath("//input[@value='Войти в Одноклассники']")).size()>0) System.out.println("Wrong password or login");
        else {
            try {
                String nname1 = mp.getFullName();
                WebElement element = driver.findElement(By.xpath("//*[@id='hook_Block_Navigation']/div/div/a[1]/div"));
                String nname2 = element.getText();
                System.out.println(nname1);
                System.out.println(nname2);
                if (nname1.equals(nname2)) System.out.println("Right user!");
                else System.out.println("Wrong user!");
            } catch (Exception e) {
                System.out.println(e);
            }
        }*/
    }

}