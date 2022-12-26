package simbirsoft.eshevtsova.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormTest {
    @BeforeAll
    static void beforeAll() {

        System.setProperty("webdriver.gecko.driver", "c:\\geckodriver.exe");
        Configuration.browser = "FIREFOX";
        Configuration.browserSize = "1600x900";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillStudentRegistrationForm() {

        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("alex.ivanov@qwe.test");
        $("[name=gender][value=Male]").parent().click();
        $("#userNumber").setValue("9874521478");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1987");
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__day--014").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("images/testfile.png");
        $("#currentAddress").setValue("Kamishinskaya, 56");
        $("#submit").scrollIntoView(true);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Alex Ivanov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("alex.ivanov@qwe.test"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9874521478"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("14 September,1987"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("testfile.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Kamishinskaya, 56"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Agra"));
    }
}
