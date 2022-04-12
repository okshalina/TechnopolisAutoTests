import com.codeborne.selenide.conditions.Value;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
public class MessageElement {
    String conversationName;
    String imageXpath;
    String lastTextMessage;
    String messageId;  //непосредственно сам блок сообщения
    MessageElement(String messageId){
        this.messageId=messageId;
    };
}
