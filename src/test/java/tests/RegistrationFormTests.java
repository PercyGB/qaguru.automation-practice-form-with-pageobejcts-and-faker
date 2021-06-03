package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static utils.RandomUtils.*;

public class RegistrationFormTests extends TestBase {

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = getRandomGender(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            dayOfBirth = getRandomDay(),
            monthOfBirth = getRandomMonth(),
            yearOfBirth = "1991",
            subject = "Computer Science",
            hobby = getRandomHobby(),
            picture = "john-doe-photo.jpg",
            currentAddress = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi";

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void successfullFormSubmitTest(){
        // Open Page
        registrationFormPage.openPage();

        // Fill Form
        registrationFormPage.setFirstName(firstName);
        registrationFormPage.setLastName(lastName);
        registrationFormPage.setEmail(email);
        registrationFormPage.setGender(gender);
        registrationFormPage.setPhoneNumber(phoneNumber);
        registrationFormPage.setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);
        registrationFormPage.setSubject(subject);
        registrationFormPage.setHobby(hobby);
        registrationFormPage.uploadPicture(picture);
        registrationFormPage.setCurrentAddress(currentAddress);
        registrationFormPage.setStateAndCity(state, city);

        // Submit Form
        registrationFormPage.submitForm();

        //Check Data
        registrationFormPage.checkDataEntered(
                firstName,
                lastName,
                email,
                gender,
                phoneNumber,
                dayOfBirth,
                monthOfBirth,
                yearOfBirth,
                subject,
                hobby,
                picture,
                currentAddress,
                state,
                city);
    }
}
