package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {
    Faker faker = new Faker(new Locale("en-GB"));

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getUserEmail() {
        return faker.internet().emailAddress();
    }

    public String getGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String getUserNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String gerDayOfBirth() {
        return String.format("%02d", faker.number().numberBetween(1, 28));
    }

    public String getMonthBirth() {
        return faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    public String getYearOfBirth() {
        return String.valueOf(faker.number().numberBetween(1900, 2024));
    }

    public String getSubjects() {
        return faker.options().option("History", "Maths");
    }

    public String getHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String getAddress() {
        return faker.address().fullAddress();
    }

    public String getState() {
        return faker.options().option("NCR", "Haryana", "Uttar Pradesh");
    }

    public String getCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Lucknow", "Mathura", "Varanasi");
            case "Haryana" -> faker.options().option("Chandigarh", "Gurgaon", "Karnal");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaisalmer");
            default -> "";
        };
    }
}