import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class WebPageTest {

    @Test
    public void shouldGetMessage() {
        open("http://localhost:9999");
        $x("//input[@placeholder='Город']").setValue("Москва");
        $("[data-test-id=date] [value]").click();
        LocalDate dateDefault = LocalDate.now().plusDays(3);
        LocalDate dateOfMeeting = LocalDate.now().plusDays(30);
        String stringToSearch = dateOfMeeting.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String dayToSearch = String.valueOf(dateOfMeeting.getDayOfMonth());
        if (dateOfMeeting.getMonthValue()>dateDefault.getMonthValue()|dateOfMeeting.getYear()>dateDefault.getYear()){
            $(".calendar__arrow_direction_right[data-step='1']").click();
        }
        $$("td.calendar__day").find(exactText(dayToSearch)).click();
        $x("//input[@name='name']").setValue("Николай Васильев");
        $x("//input[@name='phone']").setValue("+78888888888");
        $x("//label[@data-test-id='agreement']").click();
        $x("//button[@class='button button_view_extra button_size_m button_theme_alfa-on-white']").click();
        $x("//div[@class='notification notification_visible notification_has-closer notification_stick-to_right notification_theme_alfa-on-white']").shouldBe(visible, Duration.ofSeconds(15));
    }
}
