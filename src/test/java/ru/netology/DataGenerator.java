package ru.netology;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    @AllArgsConstructor
    @Data
    public static class CreateUser {

        public static User generateUser() {
            Faker faker = new Faker(new Locale("RU"));
            String newName = faker.name().lastName() + " " + faker.name().firstName();
            String newPhone = faker.phoneNumber().phoneNumber();
            String[] centersOfSubjects = {"Майкоп", "Горно-Алтайск", "Уфа", "Улан-Удэ", "Махачкала", "Магас", "Нальчик", "Элиста", "Черкесск", "Петрозаводск", "Сыктывкар", "Симферополь", "Йошкар-Ола", "Саранск", "Якутск", "Владикавказ", "Казань", "Кызыл", "Ижевск", "Абакан", "Грозный", "Чебоксары", "Барнаул", "Чита", "Петропавловск-Камчатский", "Краснодар", "Красноярск", "Пермь", "Владивосток", "Ставрополь", "Хабаровск", "Благовещенск", "Архангельск", "Астрахань", "Белгород", "Брянск", "Владимир", "Волгоград", "Вологда", "Воронеж", "Иваново", "Иркутск", "Калининград", "Калуга", "Кемерово", "Киров", "Кострома", "Курган", "Курск", "Санкт-Петербург", "Липецк", "Магадан", "Москва", "Мурманск", "Нижний Новгород", "Великий Новгород", "Новосибирск", "Омск", "Оренбург", "Орёл", "Пенза", "Псков", "Ростов-на-Дону", "Рязань", "Самара", "Саратов", "Южно-Сахалинск", "Екатеринбург", "Смоленск", "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Ульяновск", "Челябинск", "Ярославль", "Нарьян-Мар", "Ханты-Мансийск", "Анадырь", "Салехард"};
            Random random = new Random();
            String newAddress = centersOfSubjects[random.nextInt(centersOfSubjects.length)];
            return new User(newName, newPhone, newAddress);
        }

        public static String generateInvalidName() {
            Faker faker = new Faker(new Locale("EN"));
            return faker.name().lastName() + " " + faker.name().firstName();
        }

        public static String generateInvalidPhone() {
            Faker faker = new Faker(new Locale("RU"));
            return faker.phoneNumber().subscriberNumber(5);
        }

        public static String generateInvalidCity() {
            Faker faker = new Faker(new Locale("RU"));
            return faker.address().streetName();
        }

        public static String generateNameWithLetterYo() {
            Faker faker = new Faker(new Locale("RU"));
            String[] specialName = {"Фёдор", "Алёна", "Семён", "Артём", "Фёкла", "Нефёд", "Ярём", "Аксён"};
            Random random = new Random();
            return faker.name().lastName() + " " + specialName[random.nextInt(specialName.length)];
        }
    }

    public static class RandomiseDate {

        public static String getDateIncrement() {
            Random random = new Random();
            int increment = random.nextInt(7) + 1;
            LocalDate date = LocalDate.now().plusDays(3 + increment);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return formatter.format(date);
        }

        public static String getTomorrowDate() {
            LocalDate date = LocalDate.now().plusDays(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return formatter.format(date);
        }
    }
}