package md.opencart.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import md.opencart.managers.DataFakerManager;
import md.opencart.managers.DriverManager;
import md.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

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

    @And("the privacyToggle is enabled")
    public void thePrivacyToggleIsEnabled() throws InterruptedException {
        registerPage.switchOnThePrivacyToggle(driver);
        
    }

    @And("continueBtn is clicked")
    public void continuebtnIsClicked() throws InterruptedException {
        registerPage.clickOnContinueBtn();
    }
}
