import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.open;

class CardDeliveryTest {
    @Test
    void shouldRegisterDateOfDeliveryCard() {
        open("http://localhost:9999");
     //   String possibleDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
