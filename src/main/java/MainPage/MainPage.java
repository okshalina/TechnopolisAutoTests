package MainPage;
import Friends.FriendsPage;
import Login.*;
import Message.MessagePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.User;
import static com.codeborne.selenide.Selenide.$;


public class MainPage {
    public User user;
    public MainPage(User user){
        this.user=user;
    };
    public MainPage(){};
    public String getFullNameFromPage(){
        return  $(By.xpath("//div[@class='tico ellip']")).getText();
    };
    public void isLoginSuccess() {
        Assert.assertFalse("Не удалось войти, неверный логин или пароль", $(LoginPage.GET_BUTTON()).exists());
    };
    public MessagePage getMessagePage(){
        $(By.xpath("//div[@class='toolbar_nav_a toolbar_nav_a__messa js-msg-tt h-mod']")).click();
        return new MessagePage();
    };

    public FriendsPage getFriendsPage(){
        $(By.xpath("//a[@data-l='t,userFriend']")).click();
        return new FriendsPage();
    };
}
