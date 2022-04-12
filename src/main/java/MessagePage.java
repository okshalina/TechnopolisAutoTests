import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MessagePage {
    User user;
    MessagePage(User user){
        this.user=user;
    };
    public void isLoaded() throws Error{
        Assert.assertTrue("Не произошла загрузка диалогов", $(By.xpath("//msg-search-input[@name='chat-search']")).shouldBe(visible).isDisplayed());
    };

    public boolean checkMessage(String textMessageSent, int index){
        $(By.xpath(user.messageElements.get(index).messageId)).click();
        $(By.xpath("//msg-input")).setValue(textMessageSent).pressEnter();
        String textMessageReceived = $(By.xpath("//*[@id='msg_layer']/msg-app/main/msg-page/div[2]/msg-chat/main/section/div/msg-message-list/div/div[3]/msg-message[8]/div[1]/div/div/msg-parsed-text")).getText();
        if(textMessageSent.equals(textMessageReceived)) return true;
        else return false;
    };

    public void hideMessage(int index) throws Error{
        Assert.assertTrue("Данного сообщения в списке нет", $(By.xpath(user.messageElements.get(index).messageId)).isDisplayed());
        $(By.xpath(user.messageElements.get(index).messageId)).click();
        $(By.xpath("//msg-button[@title='Настройки']")).click();
        $(By.xpath("//msg-l10n[@key='hide-chat']")).click();
        Assert.assertTrue($(By.xpath("//msg-button[@data-tsid='confirm-primary']")).exists());
        $(By.xpath("//msg-button[@data-tsid='confirm-primary']")).click();
        Assert.assertFalse("Не удалось удалить сообщение", $(By.xpath(user.messageElements.get(index).messageId)).isDisplayed());
    };

}
