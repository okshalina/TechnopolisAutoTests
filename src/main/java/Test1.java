import org.apache.xerces.xs.StringList;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import com.codeborne.selenide.*;
import java.util.ArrayList;
import java.util.Arrays;


import static com.codeborne.selenide.Selenide.*;

public class Test1 {
    String messageId1 = "//msg-chats-list-item[@data-item-id='4177128197']";
    String messageId2 = "//msg-chats-list-item[@data-item-id='-82584779118262']";
    String messageId3 = "//msg-chats-list-item[@data-item-id='53270269560']";
    MessageElement messageElement1 = new MessageElement(messageId1);
    MessageElement messageElement2 = new MessageElement(messageId2);
    MessageElement messageElement3 = new MessageElement(messageId3);
    User user1 = new User("OksanaShalina", "123", "Oksana", "Shalina", new ArrayList<>(Arrays.asList(messageElement1, messageElement2, messageElement3)));

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
    public void messageSendTest(){
        Selenide.open("https://ok.ru");
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.login(user1);
        String textMessageSent = "Hello, how are you?";
        MessagePage messagePage = mainPage.getMessagePage();
        boolean result = messagePage.checkMessage(textMessageSent, 0);
        if(result == true) System.out.println("Message sent successfully");
        else System.out.println("Message sent unsuccessfully");
    }

    @Test
    public void messageHideTest(){
        Selenide.open("https://ok.ru");
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.login(user1);
        MessagePage messagePage = mainPage.getMessagePage();
        try {
            messagePage.isLoaded();
            messagePage.hideMessage(1);
        }
        catch (Error e){
            System.out.println(e);
        }
    }
}