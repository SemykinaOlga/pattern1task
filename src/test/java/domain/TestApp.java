package domain;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TestApp {
    private RegistrationInfo registrationInfo = DataGeneration.Registration.generate();

    @Test
    void ShouldSuccessfulRequestChangeMeet() {
        open("http://localhost:9999");
        SelenideElement form = $(".form");
        $("[data-test-id=city] input").setValue(registrationInfo.getCity());
        $("[data-test-id=date] input").doubleClick();
        $("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(registrationInfo.getDateFirstMeeting());
        $("[data-test-id=name] input").setValue(registrationInfo.getLastName() + " " + registrationInfo.getFirstName());
        $("[data-test-id=phone] input").setValue(registrationInfo.getPhoneNumber());
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=date] input").doubleClick();
        $("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(registrationInfo.getDateSecondMeeting());
        $(".button").click();
        $$(".button").find(exactText("Перепланировать")).click();
        $("[data-test-id=success-notification]").shouldBe(visible);
        //$("[data-test-id=success-notification]").shouldHave(exactText("Встреча успешно забронирована на " + (registrationInfo.getDateSecondMeeting())));
    }
}
