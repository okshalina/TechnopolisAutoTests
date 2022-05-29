package MainPage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.BaseTest;
import utils.User;

public class LogoutTest extends BaseTest {
    private User user1 = new User.UserBuilder("89188704358", "lalalalol3395527").withName("Oksana").withSurname("Shalina").build();

    @BeforeEach
    public void llogin(){
        mainPage.isLoginSuccess();
        loginPage.login(user1);
    };

    @Test
    public void logoutTest() {
        mainPage.logout();
    }
}
