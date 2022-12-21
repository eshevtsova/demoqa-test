package simbirsoft.eshevtsova.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class StudentRegistrationFormWithPOTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            eMail = faker.internet().emailAddress(),
            gender = "Male",
            number = faker.numerify("9#########"),
            subject = "English",
            hobby = "Music",
            address = faker.address().fullAddress(),
            state = "Uttar Pradesh",
            city = "Agra",
            picturePath = "./images/",
            pictureFileName = "testfile.png",
            date = "14",
            month = "September",
            year = "1987";

    @Test
    void positiveTest() {

        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(eMail)
                .selectGender(gender)
                .typeUserNumber(number)
                .setDateOfBirth(date, month, year)
                .setSubjects(subject)
                .setHobby(hobby)
                .uploadPicture(picturePath + pictureFileName)
                .setCurrentAddress(address);
        registrationPage.scroll();
        registrationPage.setState(state)
                .setCity(city)
                .submit();

        registrationPage.checkStudentName(firstName, lastName)
                .checkStudentEmail(eMail)
                .checkMobile(number)
                .checkDateOfBirth(date, month, year)
                .checkSubjects(subject)
                .checkHobbies(hobby)
                .checkPicture(pictureFileName)
                .checkAddress(address)
                .checkStateAndCity(state, city);
    }
}
