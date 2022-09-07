package cloud.autotests.tests.testSuits;

import cloud.autotests.tests.TestBase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.helpers.CommonActions.login;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

@Tag("regression")
@Tag("onetest")
@DisplayName("Chat Open")
public class ChatOpen extends TestBase {
    @Test
    @DisplayName("Chat opens in pre-login")
    void ChatOpensPreLogin() {
        $(byText("Help")).click();
        $(".asg-context-menu__menu").$(byText("Contact Us")).click();
        sleep(2000);
        webdriver().shouldHave(url(baseUrl + "contact-us/"));
        $("#form").shouldBe(visible);
    }

    @Disabled("credentials for uat")
    @Test
    @DisplayName("Chat opens in post-login")
    void ChatOpensPostLogin() {
        login(1);
        $(byText("Help")).click();
        $(".asg-context-menu__menu").$(byText("Contact Us")).click();
        sleep(2000);
        webdriver().shouldHave(url(baseUrl + "contact-us/"));
        $("#form").shouldBe(visible);

    }
}
