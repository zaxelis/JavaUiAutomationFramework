package md.opencart.pageobjects;

import md.opencart.managers.DriverManager;
import md.opencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;
    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;
    @FindBy(id = "input-email")
    private WebElement emailInput;
    @FindBy(id = "input-password")
    private WebElement passwordInput;
    @FindBy(css = "input[value='1'][name='agree']")
    private WebElement privacyToggle;
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    private WebElement continuebtn;

    public void fillInTheRegisterForm(String firstName, String lastName, String email, String password){
        firstNameInput.sendKeys(firstName);
        System.out.println("The entered First Name is: " + firstName);

        lastNameInput.sendKeys(lastName);
        System.out.println("The entered Last Name is: " + lastName);

        emailInput.sendKeys(email);
        System.out.println("The entered email is: " + email);

        passwordInput.sendKeys(password);
        System.out.println("The entered password is: " + password);
    }

    public void switchOnThePrivacyToggle(WebDriver driver) throws InterruptedException {
        ScrollManager.scrollToElement(driver, privacyToggle);
        privacyToggle.click();
    }

    public void clickOnContinueBtn() throws InterruptedException {
        ScrollManager.scrollToElement(DriverManager.getInstance().getDriver(), continuebtn);
        continuebtn.click();
    }
}
