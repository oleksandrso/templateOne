package cloud.autotests.tests.testSuits;

import cloud.autotests.tests.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Tag("regression")
@Tag("onetest")
@DisplayName("Banner tests")
public class Banners extends TestBase {

    @Test
    @DisplayName("Click Close Item on Cookie Policy closes Them")
    void CookiePolicyClose() {
        step("", () -> {
            $(".cockie-popup-wrap.show-cookie-popup").shouldBe(visible);
            $(".cockie-popup-close").click();
            $(".cockie-popup-inner").shouldBe(hidden);
        });
    }

}
