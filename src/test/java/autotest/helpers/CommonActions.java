package autotest.helpers;

import autotest.tests.User;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class CommonActions {


    public static void waitFullLoad() {
        sleep(10000);
        $("#asg-top-menu-desktop").shouldBe(Condition.visible);
        $(".games-menu-list").shouldBe(Condition.visible);
    }

    public static void login(int i) {
        User defaultUser = new User("Engish", "qa_asgauto1", "qa_asgauto11");
        User deUser = new User("German", "qa_asggerm1", "Test123test!");
        User ukUser = new User("United Kingdom", "qa_asguk1", "Test123test");
        String login, password;

        if (i == 1) {
            login = defaultUser.getLogin();
            password = defaultUser.getPassword();
        }
        if (i == 2) {
            login = deUser.getLogin();
            password = deUser.getPassword();
        } else {
            login = ukUser.getLogin();
            password = ukUser.getPassword();
        }

        $(".header-login__btn.header-btn").click();
        sleep(3000);
        $("[tabindex=1]").setValue(login);
        $("[tabindex=2]").setValue(password).pressEnter();
        sleep(5000);
    }


}
