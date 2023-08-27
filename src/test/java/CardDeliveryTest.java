import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CardDeliveryTest {
        private  String generateDate(int addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }
    @Test
   public void shouldRegisterDateOfDeliveryCard() {
      open("http://localhost:9999");
     $("[data-test-id='city'] input").setValue("Омск");
     String possibleDate = generateDate(3,"dd.MM.yyyy");
     $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
     $("[data-test-id='date'] input").sendKeys(possibleDate);
     $("[data-test-id='name'] input").setValue("Рукавишникова Алена");
     $("[data-test-id='phone'] input").setValue("+79510000000");
     $("[data-test-id='agreement']").click();
     $("button.button").click();
     $(".notification__content").shouldBe(Condition.visible, Duration.ofSeconds(15))
     .shouldHave(Condition.exactText("Встреча успешно забронирована на " + possibleDate));

    }

}
