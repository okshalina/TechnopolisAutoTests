package MainPage;
import Friends.FriendsPage;
import Login.*;
import Message.MessagePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.BasePage;
import utils.User;
import static com.google.common.truth.Truth.assertThat;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class MainPage extends BasePage {
    public MainPage(){
        isLoaded();
    }
    public User user;
    public MainPage(User user){
        isLoaded();
        this.user=user;
    }
    @Override
    protected void isLoaded(){
        $(By.xpath("//*[contains(@data-l, 'navigationToolbar')]")).shouldBe(visible.because("Нет  верхнего тулбара"));
        $(By.xpath("//a[contains(@class, 'nav-side_i') and contains(@data-l, 'userPage')]")).shouldBe(visible.because("Нет имени и фамилии пользователя"));
        $(By.xpath("//div[contains(@data-l='t,navigation', @class='navigation')]")).shouldBe(visible.because("Нет  левого тулбара"));
    }

    public String getFullNameFromPage(){
        return  $(By.xpath("//div[@class='tico ellip']")).getText();
    };

    public void isLoginSuccess() {
        Assert.assertFalse("Не удалось войти, неверный логин или пароль", $(LoginPage.GET_BUTTON()).exists());
    }

    public MessagePage getMessagePage(){
        $(By.xpath("//div[@class='toolbar_nav_a toolbar_nav_a__messa js-msg-tt h-mod']")).click();
        return new MessagePage();
    }

    public FriendsPage getFriendsPage(){
        $(By.xpath("//a[@data-l='t,userFriend']")).click();
        return new FriendsPage();
    }

    public void logout(){
        $(By.xpath("//div[@class='ucard-mini toolbar_ucard js-toolbar-menu']")).shouldBe(visible.because("Не отображается мини тулбар для выхода")).click();
        $(By.xpath("//a[contains(@data='t,logout', @class='lp')]")).shouldBe(visible.because("Не отображается кнопка выхода")).click();
        assertThat($(LoginPage.GET_BUTTON()).isDisplayed()).isTrue();
    }
}
