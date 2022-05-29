package Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.BaseTest;
import utils.User;

import java.util.ArrayList;
import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;


public class MessageTest extends BaseTest {

    String messageId1 = "4177128197";
    String messageId2 = "-82584779118262";
    String messageId3 = "53270269560";
    User user1 = new User.UserBuilder("89188704358", "lalalalol3395527").withMessageIds(new ArrayList<>(Arrays.asList(messageId1, messageId2, messageId3))).build();

    @BeforeEach
    public void llogin(){
        loginPage.login(user1);
        mainPage.isLoginSuccess();
    };

    @Test
    public void messageSendTest(){
        MessagePage messagePage = mainPage.getMessagePage();
        messagePage.formMessageList(user1);
        String textMessageSent = "Hello, how are you?";
        boolean result = messagePage.checkMessage(textMessageSent, 0);
        assertThat(result).isTrue();
        System.out.println("Message sent successfully");
    }

    @Test
    public void messageHideTest(){
        MessagePage messagePage = mainPage.getMessagePage();
        messagePage.formMessageList(user1);

        try {
            messagePage.isLoaded();
            messagePage.hideMessage(1);
        }
        catch (Error e){
            System.out.println(e);
        }
    }
}