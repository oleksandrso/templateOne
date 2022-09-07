package autotest.tests.testSuits;

import autotest.tests.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static io.qameta.allure.Allure.step;

@Tag("regression")

@DisplayName("Logo click")
public class LogoClick extends TestBase {


    @CsvSource(value = {

            "Sport Page|sport/#/",
            "Promotion Page|promotions/",
            "Loyalty Page|loyalty/",
            "Home Page| ",
            "Single Promotion Page|promotions/welcome-package/"
    }, delimiter = '|')
    @ParameterizedTest(name = "Click to Logo on {0} return to Home Page")
    void CookiePolicyVisibleIfNoClosedVerticals(String pageName, String urlSecondPart) {
        step("Open " + pageName, () -> {
            open(baseUrl + urlSecondPart);
            sleep(2000);
            webdriver().shouldHave(urlContaining(baseUrl + urlSecondPart));
        });
        step("Click to Logo ", () -> {
            $(".header-logo").click();
            sleep(2000);
            webdriver().shouldHave(url(baseUrl));
        });
    }
}
