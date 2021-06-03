package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    public void setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
    }

    public void setLastName(String lastName) {
        $("#lastName").setValue(lastName);
    }

    public void setEmail(String email) {
        $("#userEmail").setValue(email);
    }

    public void setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        $("#userNumber").setValue(phoneNumber);
    }

    public void setDateOfBirth(String dayOfBirth,
                               String monthOfBirth,
                               String yearOfBirth) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", dayOfBirth)).click();
    }

    public void setSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
    }

    public void setHobby(String hobby) {
        $(byText(hobby)).click();
    }

    public void uploadPicture(String picture) {
        $("#uploadPicture").uploadFromClasspath(picture);
    }

    public void setCurrentAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
    }

    public void setStateAndCity(String state, String city) {
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#city").click();
        $(byText(city)).click();
    }

    public void submitForm() {
        $("#submit").click();
    }
    public void checkDataEntered(String firstName,
                                 String lastName,
                                 String email,
                                 String gender,
                                 String phoneNumber,
                                 String dayOfBirth,
                                 String monthOfBirth,
                                 String yearOfBirth,
                                 String subject,
                                 String hobby,
                                 String picture,
                                 String currentAddress,
                                 String state,
                                 String city)
    {
        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName),
                text(email),
                text(gender),
                text(phoneNumber),
                text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth),
                text(subject),
                text(hobby),
                text(picture),
                text(currentAddress),
                text(state + " " + city));
    }





}
