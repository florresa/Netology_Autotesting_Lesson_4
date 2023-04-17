import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class WebPageTest {

    @Test
    public void shouldGetMessage() {
        open("http://localhost:9999");
        $x("//input[@placeholder='Город']").setValue("Москва");
        $x("//input[@placeholder='Дата встречи']").sendKeys(Keys.CONTROL + "A");
        $x("//input[@placeholder='Дата встречи']").sendKeys(Keys.BACK_SPACE);
        $x("//input[@placeholder='Дата встречи']").setValue("25.04.2023");
        $x("//input[@name='name']").setValue("Николай Васильев");
        $x("//input[@name='phone']").setValue("+78888888888");
        $x("//label[@data-test-id='agreement']").click();
        $x("//button[@class='button button_view_extra button_size_m button_theme_alfa-on-white']").click();
        $x("//div[@class='notification notification_visible notification_has-closer notification_stick-to_right notification_theme_alfa-on-white']").shouldBe(visible, Duration.ofSeconds(15));
    }
}
