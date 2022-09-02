package cloud.autotests.tests.testSuits;

import cloud.autotests.tests.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("regression")
@Tag("onetest")
@DisplayName("Game Tests")
public class Games extends TestBase {

    @Test
    @DisplayName("More Games button load more button")
    void moreGamesButtonLoadGames() {

        step("Click to button more games", () -> {
            int firstGameNumber = $$(".row.bottom-grid li").size();

            step("Scroll to Page End", () -> {
                for (int i = 0; i < 4; i++) {
                    $$(".row.bottom-grid li").last().scrollTo();
                    sleep(1000);
                }
            });

            step("Click More Games button", () -> {
                $(".close-games").click();
                sleep(1000);
                int secondGameNumber = $$(".row.bottom-grid li").size();
                assertTrue(secondGameNumber > firstGameNumber);
            });
        });
    }

}
