package Friends;
import Message.MessagePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.User;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.google.common.truth.Truth.assertThat;


public class FriendsPage {

    private List<FriendsElement> friendsElements = new ArrayList<FriendsElement>();
    public List<FriendsElement> getFriendsElements(){ return friendsElements;};

    public List<FriendsElement> formFriendsList(User user){
        Assert.assertTrue("У данного пользователя нет друзей", user.getFriendsIds().size()>0);
        int in;
        for(in=0;in < user.getFriendsIds().size();in++){
            FriendsElement friend = new FriendsElement();
            friend.createFriendElement(user, in);
            friendsElements.add(friend);
        };
        return friendsElements;
    };
    public MessagePage getMessagePageFromFriendsPage(int index){
        $(By.xpath(friendsElements.get(index).getMessageButton())).click();
        return new MessagePage();
    };
    public void checkDuplicates(){
        assertThat(friendsElements.size()>0).isTrue();
        assertThat(friendsElements).containsNoDuplicates();
    }
    public void callAFriend(int index){
        assertThat(friendsElements.size()>0).isTrue();
        $(By.xpath(friendsElements.get(index).getPhoneButton())).click();
        $(By.xpath("//msg-call")).shouldBe(visible.because("Была нажата кнопка позвонить"));
        assertThat($(By.xpath("//msg-call")).isDisplayed()).isTrue();
    }
}
