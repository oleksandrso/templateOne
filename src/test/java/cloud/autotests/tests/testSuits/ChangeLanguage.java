package cloud.autotests.tests.testSuits;

import cloud.autotests.tests.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;

@Tag("regression")
@Tag("sanity")
@Tag("blocker")
public class ChangeLanguage extends TestBase {

    @CsvSource(value = {
            "Deutsch|de",
            "Norsk|no",
            "Suomi|fi",
            "Portuguese (BR)|br",
            "Español|es"
    }, delimiter = '|')
    @ParameterizedTest(name = "Language can be changed to {0}")
    void ChangeLanguageFromList(String language, String urlLanguage) {
        String s = baseUrl.substring(baseUrl.lastIndexOf(':')+3);
        String fullUrlLanguage="https://"+urlLanguage+"."+s;
        step("Open language menu", () -> {
            $(".header-language-switcher__btn").click();
        });
        step("Change language to {0}", () -> {
            $(".header-language-switcher__menu").$(byText(language)).click();
            sleep(2000);
        });
        step("Correct link {1} opened", () -> {
            webdriver().shouldHave(url(fullUrlLanguage));
        });
    }
}
