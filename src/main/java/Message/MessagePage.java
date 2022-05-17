package Message;
import utils.User;
import org.junit.Assert;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import java.util.ArrayList;
import java.util.List;

public class MessagePage {

    String messageIdXpath  = "//msg-chats-list-item[@data-item-id='']";
    public List<String> messageElements = new ArrayList<String>();

    public void isLoaded() throws Error{
        Assert.assertTrue("Не произошла загрузка диалогов", $(By.xpath("//msg-search-input[@name='chat-search']")).shouldBe(visible).isDisplayed());
    };
    public List<String> formMessageList(User user){
        Assert.assertTrue("У данного пользователя нет сообщений", user.getMessageIds().size()>0);
        int in;
        for(in=0;in<user.getMessageIds().size();in++){
            String messageElement = messageIdXpath.substring(0,37) + user.getMessageIds().get(in) + messageIdXpath.substring(37);
            messageElements.add(messageElement);
        };
        return messageElements;
    };

    public boolean checkMessage(String textMessageSent, int index){
        $(By.xpath(messageElements.get(index))).click();
        $(By.xpath("//msg-input")).setValue(textMessageSent).pressEnter();
        String textMessageReceived = $(By.xpath("//div[@class='cnt __bg __last'][last()]")).getText();
        System.out.println(textMessageReceived.length() +" "+ textMessageSent.length());
        if(textMessageSent.equals(textMessageReceived)) return true;
        else return false;
    };

    public void hideMessage(int index) {
        Assert.assertTrue("Данного сообщения в списке нет", $(By.xpath(messageElements.get(index))).exists());
        $(By.xpath(messageElements.get(index))).click();
        $(By.xpath("//msg-button[@title='Настройки']")).click();
        $(By.xpath("//msg-l10n[@key='hide-chat']")).click();
        Assert.assertTrue($(By.xpath("//msg-button[@data-tsid='confirm-primary']")).exists());
        $(By.xpath("//msg-button[@data-tsid='confirm-primary']")).click();
        Assert.assertFalse("Не удалось удалить сообщение", $(By.xpath(messageElements.get(index))).isDisplayed());
    };


}
