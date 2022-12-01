package simbirsoft.eshevtsova.test;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegistrationFormTest {

    @BeforeAll
    static void beforeAll(){

        System.setProperty("webdriver.gecko.driver", "c:\\geckodriver.exe");
        Configuration.browser="FIREFOX";
        Configuration.browserSize = "1600x900";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillStudentRegistrationForm(){

        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("alex.ivanov@qwe.test");
        $(byXpath("//label[text()='Male']")).click();
        $("#userNumber").setValue("9874521478");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1987");
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__day--014").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $(byXpath("//label[text()='Sports']")).click();
        $(byXpath("//label[text()='Reading']")).click();
        $(byXpath("//label[text()='Music']")).click();
        $("#uploadPicture").uploadFromClasspath("images/testfile.png");
        $("#currentAddress").setValue("Kamishinskaya, 56");
        $("#submit").scrollIntoView(true);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(byXpath("//td[text()='Student Name']")).parent().shouldHave(text("Alex Ivanov"));
        $(byXpath("//td[text()='Student Email']")).parent().shouldHave(text("alex.ivanov@qwe.test"));
        $(byXpath("//td[text()='Gender']")).parent().shouldHave(text("Male"));
        $(byXpath("//td[text()='Mobile']")).parent().shouldHave(text("9874521478"));
        $(byXpath("//td[text()='Date of Birth']")).parent().shouldHave(text("14 September,1987"));
        $(byXpath("//td[text()='Subjects']")).parent().shouldHave(text("English"));
        $(byXpath("//td[text()='Hobbies']")).parent().shouldHave(text("Sports, Reading, Music"));
        $(byXpath("//td[text()='Picture']")).parent().shouldHave(text("testfile.png"));
        $(byXpath("//td[text()='Address']")).parent().shouldHave(text("Kamishinskaya, 56"));
        $(byXpath("//td[text()='State and City']")).parent().shouldHave(text("Uttar Pradesh Agra"));










  //      $x("//td[text()='Student Name']").parent().shouldHave(text("Alex Ivanov"));








    }
}
