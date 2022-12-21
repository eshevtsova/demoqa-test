package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;
public class RegistrationPage {

    private static final String FORM_TITLE = "Student Registration Form";
    private static final String MODAL_TITLE = "Thanks for submitting the form";
    private final CalendarComponent calendar = new CalendarComponent();
    private final SelenideElement modal = $(".modal-title");

    public RegistrationPage openPage() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPage typeFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    public RegistrationPage typeEmail(String eMail) {
        $("#userEmail").setValue(eMail);
        return this;
    }

    public RegistrationPage selectGender(String gender) {
        $(format("[name=gender][value=%s]", gender)).parent().click();
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage typeUserNumber(String number) {
        $("#userNumber").setValue(number);
        return this;
    }

    public RegistrationPage setSubjects(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String pictureFileName) {
        $("#uploadPicture").uploadFromClasspath(pictureFileName);
        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public void submit() {
        $("#submit").click();
    }

    public void scroll() {
        $("#submit").scrollIntoView(true);
    }

    public void checkResultsTitle() {
        modal.shouldHave(text(MODAL_TITLE));
    }

    public RegistrationPage checkStudentName(String firstName, String lastName) {
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        return this;
    }

    public RegistrationPage checkStudentEmail(String eMail) {
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(eMail));
        return this;
    }

    public RegistrationPage checkGender(String gender) {
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        return this;
    }

    public RegistrationPage checkMobile(String mobile) {
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(mobile));
        return this;
    }

    public RegistrationPage checkDateOfBirth(String date, String month, String year) {
        $(".table-responsive").$(byText("Date of Birth"))
                .parent().shouldHave(text(date + " " + month + "," + year));
        return this;
    }

    public RegistrationPage checkSubjects(String subject) {
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subject));
        return this;
    }

    public RegistrationPage checkHobbies(String hobby) {
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobby));
        return this;
    }

    public RegistrationPage checkPicture(String fileName) {
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(fileName));
        return this;
    }

    public RegistrationPage checkAddress(String address) {
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(address));
        return this;
    }

    public RegistrationPage checkStateAndCity(String state, String city) {
        $(".table-responsive").$(byText("State and City"))
                .parent().shouldHave(text(state + " " + city));
        return this;
    }
}
