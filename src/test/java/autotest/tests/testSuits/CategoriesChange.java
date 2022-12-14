package autotest.tests.testSuits;

import autotest.tests.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;

@Tag("regression")
@DisplayName("Change Category")
public class CategoriesChange extends TestBase {


    @CsvSource(value = {
            "liveCasino|live-casino/",
            "sport|sport/#/"
    }, delimiter = '|')
    @ParameterizedTest(name = "Verticals can be changed to {0}")
    void clickButtonChangeCategory(String btnName, String urlSecondPart) {
        step("Open verticals", () -> {
            $("[data-vertical-id=" + btnName + "]").click();
            sleep(2000);
            webdriver().shouldHave(url(baseUrl + urlSecondPart));
        });
    }

    @Test
    @DisplayName("Verticals can be changed to casino")
    void clickButtonChangeCategoryCasino() {
        step("Open verticals", () -> {
            $("[data-vertical-id=casino]").click();
            webdriver().shouldHave(url(baseUrl));
        });
    }
}
