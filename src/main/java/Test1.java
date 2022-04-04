import org.apache.xerces.xs.StringList;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import com.codeborne.selenide.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class Test1 {
    String messageElement1 = "//msg-chats-list-item[@data-item-id='4177128197']";
    String messageElement2 = "//msg-chats-list-item[@data-item-id='-82584779118262']";
    User user1 = new User("89188704358", "lalalalol3395527", "Oksana", "Shalina", new ArrayList<>(Arrays.asList(messageElement1, messageElement2)));

    @Test
    public void loginTest() {
        LoginPage lp = new LoginPage();
        // Код с использованием Selenide
        //Configuration.browser="chrome";
        Selenide.open("https://ok.ru");
        MainPage mp = lp.login(user1); // try to log in

        if($(By.xpath(LoginPage.button)).exists()) System.out.println("Can't log in. Wrong password or login");
        else {
            try {
                String nname1 = mp.getFullNameFromPage();
                System.out.println("MainPage data: " + nname1 + ", " + "length: " + nname1.length());

                String nname2 = user1.getFullNameFromUser();
                System.out.println("User's data: " + nname2+ ", " + "length: " + nname2.length());

                if (nname1.equals(nname2)) System.out.println("Right user!");
                else System.out.println("Wrong user!");
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
    @Test
    public void messageTest(){
        Selenide.open("https://ok.ru");
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.login(user1);
        String textMessageSent = "Hello, how are you?";
        MessagePage messagePage = mainPage.getMessagePage();
        boolean result = messagePage.checkMessage(textMessageSent, 0);
        if(result == true) System.out.println("Message sent successfully");
        else System.out.println("Message sent unsuccessfully");
    }
}