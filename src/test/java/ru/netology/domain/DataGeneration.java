package ru.netology.domain;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataGeneration {
    private DataGeneration() {}

    public static class Registration {
        private Registration() {}


        public static String getCity(){
            final String[] city = {
                    "Москва",
                    "Санкт-Петербург",
                    "Новосибирск",
                    "Екатеринбург",
                    "Нижний Новгород",
                    "Казань",
                    "Челябинск",
                    "Омск",
                    "Самара",
                    "Ростов-на-Дону",
                    "Уфа",
                    "Красноярск",
                    "Пермь",
                    "Воронеж",
                    "Волгоград",
                    "Краснодар",
                    "Москва",
                    "Санкт-Петербург",
                    "Новосибирск",
                    "Екатеринбург",
                    "Нижний Новгород",
                    "Казань",
                    "Челябинск",
                    "Омск",
                    "Самара",
                    "Ростов-на-Дону",
                    "Уфа",
                    "Красноярск",
                    "Пермь",
                    "Воронеж",
                    "Волгоград",
                    "Краснодар"};
            Random random = new Random();
            int index = random.nextInt(city.length);
            return city[index];
        }

        public static RegistrationInfo generate() {
            Faker faker = new Faker(new Locale("ru"));
            return new RegistrationInfo(
                    getCity(),
                    faker.name().lastName()+" "+faker.name().firstName(),
                    faker.numerify("+79#########"));
        }

        public static String getDate(int shift){
            return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }
}
