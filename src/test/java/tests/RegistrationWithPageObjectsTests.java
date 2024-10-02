package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.RegistrationPage;
import utils.Gender;
import utils.RandomUtils;

public class RegistrationWithPageObjectsTests extends TestBase {

    private  final RegistrationPage registrationPage = new RegistrationPage();
    private  final RandomUtils randomUtils = new RandomUtils();


    @ValueSource(strings = {"roman@qa.guru", "roman.belov@ya.ru", "roma3@guru.qa"})
    @ParameterizedTest(name = "Успешная регистрация с почтой: email = {0}")
    public void successfulRegistrationWithValueSourceAnnotation(String userEmail) {

        String firstName = randomUtils.getFirstName();
        String lastName = randomUtils.getLastName();
        String gender = randomUtils.getGender();
        String userNumber = randomUtils.getUserNumber();
        String dayOfBirth = randomUtils.gerDayOfBirth();
        String monthOfBirth = randomUtils.getMonthBirth();
        String yearOfBirth = randomUtils.getYearOfBirth();
        String subjectsOne = randomUtils.getSubjects();
        String hobbiesOne = randomUtils.getHobbies();
        String pictureName = "ava.png";
        String address = randomUtils.getAddress();
        String state = randomUtils.getState();
        String city = randomUtils.getCity(state);

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subjectsOne)
                .setHobby(hobbiesOne)
                .uploadPicture(pictureName)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjectsOne)
                .checkResult("Hobbies", hobbiesOne)
                .checkResult("Picture", pictureName)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }

    @CsvFileSource(resources = "/data/testData.csv")
    @ParameterizedTest(name = "Успешная регистрация с параметрами: firstName = {0} и lastName = {1}")
    void successfulRegistrationWithCsvFileSourceAnnotation(String firstName, String lastName) {

        String userEmail = randomUtils.getUserEmail();
        String gender = randomUtils.getGender();
        String userNumber = randomUtils.getUserNumber();
        String dayOfBirth = randomUtils.gerDayOfBirth();
        String monthOfBirth = randomUtils.getMonthBirth();
        String yearOfBirth = randomUtils.getYearOfBirth();
        String subjectsOne = randomUtils.getSubjects();
        String hobbiesOne = randomUtils.getHobbies();
        String pictureName = "ava.png";
        String address = randomUtils.getAddress();
        String state = randomUtils.getState();
        String city = randomUtils.getCity(state);

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subjectsOne)
                .setHobby(hobbiesOne)
                .uploadPicture(pictureName)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjectsOne)
                .checkResult("Hobbies", hobbiesOne)
                .checkResult("Picture", pictureName)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }

    @EnumSource(Gender.class)
    @ParameterizedTest(name = "Успешная регистрация с параметром: gender = {0}")
    void successfulRegistrationWithEnumSourceAnnotation(Gender gender)  {

        String firstName = randomUtils.getFirstName();
        String lastName = randomUtils.getLastName();
        String userEmail = randomUtils.getUserEmail();
        String userNumber = randomUtils.getUserNumber();
        String dayOfBirth = randomUtils.gerDayOfBirth();
        String monthOfBirth = randomUtils.getMonthBirth();
        String yearOfBirth = randomUtils.getYearOfBirth();
        String subjectsOne = randomUtils.getSubjects();
        String hobbiesOne = randomUtils.getHobbies();
        String pictureName = "ava.png";
        String address = randomUtils.getAddress();
        String state = randomUtils.getState();
        String city = randomUtils.getCity(state);

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subjectsOne)
                .setHobby(hobbiesOne)
                .uploadPicture(pictureName)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender.getTitle())
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjectsOne)
                .checkResult("Hobbies", hobbiesOne)
                .checkResult("Picture", pictureName)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }

}