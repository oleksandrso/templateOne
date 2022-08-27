package cloud.autotests.tests.testSuits;

import cloud.autotests.tests.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("regression")
public class CookiePolicy extends TestBase {

    @Test
    @DisplayName("Click Close Item on Cookie Policy closes Them")
    void CookiePolicyClose() {
        step("", () -> {
            $(".cockie-popup-wrap.show-cookie-popup").shouldBe(visible);
            $(".cockie-popup-close").click();
            $(".cockie-popup-inner").shouldBe(hidden);
        });
    }

    @Test
    @DisplayName("Click on Cookie Policy is opening Privacy pop-up")
    void CookiePolicyPopUp() {
        step("Open popup", () -> {
            $(".cockie-popup-wrap.show-cookie-popup").shouldBe(visible);
            $("[data-action=openInfoPopup]").click();
            sleep(3000);
            $("#popup-notification").shouldBe(visible);
        });
    }

    @ValueSource(strings = {"Exclusive club","Promotions","Games"})
    @ParameterizedTest(name = "Cookie Policy is shown on {0} page when wasn't closed on Home page")
    void CookiePolicyVisibleIfNoClosedSubMenu(String btnName) {
        step("Open popup", () -> {
            $(byText(btnName)).click();
            sleep(10000);
            $(".cockie-popup-wrap.show-cookie-popup").shouldBe(visible);
        });

    }

    @ValueSource(strings = {"liveCasino", "casino", "sport"})
    @ParameterizedTest(name = "Cookie Policy is shown on Vertical='{0}' page when wasn't closed on Home page")
    void CookiePolicyVisibleIfNoClosedVerticals(String btnName) {
        step("Open popup", () -> {
            $("[data-vertical-id=" + btnName + "]").click();
            sleep(10000);
            $(".cockie-popup-inner").shouldBe(visible);
        });
    }
}
