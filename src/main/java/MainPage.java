import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    User user;
    MainPage(User user){
        this.user=user;
    };
    String getFullNameFromPage(){
        return  $(By.xpath("//*[@id='hook_Block_Navigation']/div/div/a[1]/div")).getText();
    };
    public MessagePage getMessagePage(){
        $(By.xpath("//div[@class='toolbar_nav_a toolbar_nav_a__messa js-msg-tt h-mod']")).click();
        return new MessagePage(user);
    };
}
