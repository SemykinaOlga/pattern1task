package domain;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DataGeneration {
    private DataGeneration() {}

    public static class Registration {
        private Registration() {}

        public static RegistrationInfo generate() {
            Faker faker = new Faker(new Locale("ru"));
            return new RegistrationInfo(
                    faker.address().city(),
                    LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    faker.name().lastName(),
                    faker.name().firstName(),
                    faker.phoneNumber().cellPhone(),
                    LocalDate.now().plusDays(6).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        }
    }
}
