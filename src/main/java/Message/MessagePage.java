package Message;
import utils.BasePage;
import utils.User;
import org.junit.Assert;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import java.util.ArrayList;
import java.util.List;

public class MessagePage extends BasePage {
    public MessagePage(){
        isLoaded();
    }

    String messageIdXpath  = "//msg-chats-list-item[@data-item-id='']";
    public List<String> messageElements = new ArrayList<String>();
    @Override
    protected void isLoaded() {
        $(By.xpath("//*[contains(@data-l, 'navigationToolbar')]")).shouldBe(visible.because("Нет  верхнего тулбара"));
        $(By.xpath("//msg-chats-list[contains(@class='custom-scrollbar']")).shouldBe(visible.because("Нет списка диалогов"));
        $(By.xpath("//div[contains(@class='contacts_list']")).shouldBe(visible.because("Нет списка контактов"));
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
        $(By.xpath(messageElements.get(index))).shouldBe(visible.because("Не отображается сообщение")).click();
        $(By.xpath("//msg-input")).setValue(textMessageSent).pressEnter();
        String textMessageReceived = $(By.xpath("//msg-message[(@mine)]//div/msg-parsed-text)[last()]")).getText();
        System.out.println(textMessageReceived.length() +" "+ textMessageSent.length());
        if(textMessageSent.equals(textMessageReceived)) return true;
        else return false;
    };

    public void hideMessage(int index) {
        Assert.assertTrue("Данного сообщения в списке нет", $(By.xpath(messageElements.get(index))).exists());
        $(By.xpath(messageElements.get(index))).click();
        $(By.xpath("//msg-button[@title='Настройки']")).shouldBe(visible.because("Не отображается кнопка настроек")).click();
        $(By.xpath("//msg-l10n[@key='hide-chat']")).shouldBe(visible.because("Не отображается кнопка скрытия чата")).click();
        Assert.assertTrue($(By.xpath("//msg-button[@data-tsid='confirm-primary']")).isDisplayed());
        $(By.xpath("//msg-button[@data-tsid='confirm-primary']")).shouldBe(visible.because("Не отображается окно подтверждения скрытия сообщения")).click();
        Assert.assertFalse("Не удалось удалить сообщение", $(By.xpath(messageElements.get(index))).isDisplayed());
    };


}
