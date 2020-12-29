package ru.netology.domain;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static ru.netology.domain.DataGeneration.Registration.*;

public class TestApp {
    private RegistrationInfo registrationInfo = DataGeneration.Registration.generate();

    @Test
    void ShouldSuccessfulRequestChangeMeet() {
        open("http://localhost:9999");
        SelenideElement form = $(".form");
        $("[data-test-id=city] input").setValue(registrationInfo.getCity());
        $("[data-test-id=date] input").doubleClick();
        $("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(getDate(3));
        $("[data-test-id=name] input").setValue(registrationInfo.getName());
        $("[data-test-id=phone] input").setValue(registrationInfo.getPhoneNumber());
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=success-notification]").shouldBe(visible);
        $("[data-test-id=success-notification] .notification__content")
                .shouldHave(exactText("Встреча успешно запланирована на " + getDate(3)));
        $("[data-test-id=date] input").doubleClick();
        $("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(getDate(6));
        $(".button").click();
        $$(".button").find(exactText("Перепланировать")).click();
        $("[data-test-id=success-notification]").shouldBe(visible);
        $("[data-test-id=success-notification] .notification__content")
                .shouldHave(exactText("Встреча успешно запланирована на " + getDate(6)));
    }
}
