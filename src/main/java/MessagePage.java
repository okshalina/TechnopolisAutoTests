import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class MessagePage {
    User user;
    MessagePage(User user){
        this.user=user;
    };
    public boolean checkMessage(String textMessageSent, int index){
        $(By.xpath(user.xpathMessages.get(index))).click();
        $(By.xpath("//msg-input")).setValue(textMessageSent).pressEnter();
        String textMessageReceived = $(By.xpath("//*[@id='msg_layer']/msg-app/main/msg-page/div[2]/msg-chat/main/section/div/msg-message-list/div/div[3]/msg-message[8]/div[1]/div/div/msg-parsed-text")).getText();
        if(textMessageSent.equals(textMessageReceived)) return true;
        else return false;
    };


}
