package Login;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BaseTest;
import utils.User;

import static com.google.common.truth.Truth.assertThat;

public class LoginTest  extends BaseTest{

    private User user1 = new User.UserBuilder("89188704358", "lalalalol3395527").withName("Oksana").withSurname("Shalina").build();

    @BeforeEach
    public void llogin(){
        loginPage.login(user1);
    };

    @DisplayName("Тест на корректный вход")
    @Test
    public void loginTest() {

        mainPage.isLoginSuccess();

                String nname1 = mainPage.getFullNameFromPage();
                System.out.println("MainPage.MainPage data: " + nname1 + ", " + "length: " + nname1.length());

                String nname2 = user1.getFullNameFromUser();
                System.out.println("User.User's data: " + nname2+ ", " + "length: " + nname2.length());

                assertThat(nname1).isEqualTo(nname2);
                System.out.println("Right user!");

    }
}
