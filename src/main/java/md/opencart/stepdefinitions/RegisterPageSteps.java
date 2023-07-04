package md.opencart.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import md.opencart.managers.DataFakerManager;
import md.opencart.managers.DriverManager;
import md.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @When("the registration form is completed with valid data")
    public void theRegistrationFormIsCompletedWithValidData() {
        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String randomEmail = DataFakerManager.getRandomEmail();
        String password = DataFakerManager.getRandomPass();

        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, password);

    }

    @And("the registration form is completed with the following data:")
    public void theRegistrationFormIsCompletedWithTheFollowingData(Map<String, String> userDetailsMap) {

        String firstNameValue = userDetailsMap.get("firstName");
        if (firstNameValue != null && firstNameValue.toUpperCase().equals("RANDOM")) {
            firstNameValue = DataFakerManager.getRandomName();
        }

        String lastNameValue = userDetailsMap.get("lastName");
        if (lastNameValue != null && lastNameValue.toUpperCase().equals("RANDOM")) {
            lastNameValue = DataFakerManager.getRandomName();
        }

        String emailValue = userDetailsMap.get("email");
        if (emailValue != null && emailValue.toUpperCase().equals("RANDOM")){
            emailValue = DataFakerManager.getRandomEmail();
        }

        String passwordValue = userDetailsMap.get("password");
        if (passwordValue != null && passwordValue.toUpperCase().equals("RANDOM")){
            passwordValue = DataFakerManager.getRandomPass();
        }

        registerPage.fillInTheRegisterForm(firstNameValue, lastNameValue, emailValue, passwordValue);

    }
}
