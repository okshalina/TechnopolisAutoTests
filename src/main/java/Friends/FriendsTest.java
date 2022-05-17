package Friends;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.BaseTest;
import utils.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import utils.User;
import static com.google.common.truth.Truth.assertThat;

public class FriendsTest extends BaseTest {
    String friendId1 = "582037099855";
    String friendId2 = "597466247218";
    String friendId3 = "570743199476";
    User user1 = new User.UserBuilder("OksanaShalina", "lalalalol3395527").withFriendsIds((new ArrayList<>(Arrays.asList(friendId1, friendId2, friendId3)))).build();

    @BeforeEach
    public void llogin() {
        loginPage.login(user1);
        mainPage.isLoginSuccess();
    }

    @Test
    public void checkFriendsForDuplicates() {
        FriendsPage friendsPage = mainPage.getFriendsPage();
        friendsPage.formFriendsList(user1);
        friendsPage.checkDuplicates();
        System.out.println("Все друзья уникальные");
    }

    @Test
    public void initiateACall() {
        FriendsPage friendsPage = mainPage.getFriendsPage();
        friendsPage.formFriendsList(user1);
        friendsPage.callAFriend(0);
        System.out.println("Пользователю можно позвонить");
    }
}
