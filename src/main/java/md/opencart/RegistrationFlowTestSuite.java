package md.opencart;

import md.opencart.managers.DataFakerManager;
import md.opencart.managers.DriverManager;
import md.opencart.pageobjects.HomePage;
import md.opencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class RegistrationFlowTestSuite {

    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    static int counter = 0;

    @BeforeEach
    public void executeTheCodeBeforeEachExec(){
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        counter ++;
        System.out.println("The test number " + counter + " started");
    }
    @Test
    @DisplayName("The URL contains succses keyword after registration with valid data")
    public void registerFlowRedirectTheUserToTheCorrectUrl() throws Throwable {
        homePage.navigateToRegisterPageFromHeaderMenu();

        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String randomEmail = DataFakerManager.getRandomEmail();
        String password = DataFakerManager.getRandomPass();

        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, password);
        registerPage.switchOnThePrivacyToggle(driver);
        registerPage.clickOnContinueBtn();
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());

        boolean urlContainsTheCorrectKeywords = driver.getCurrentUrl().contains("/index.php?route=account/success&language");
        Assertions.assertTrue(urlContainsTheCorrectKeywords, "The Url" + driver.getCurrentUrl() + "contain success keyword");

    }

    @Test
    @DisplayName("The URL contains register keyword when privacy policy is not accepted")
    public void registerFlowIsBlockedByPrivacyPolicyToggle() throws Throwable {
        homePage.navigateToRegisterPageFromHeaderMenu();

        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String randomEmail = DataFakerManager.getRandomEmail();
        String password = DataFakerManager.getRandomPass();

        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, password);
        //registerPage.switchOnThePrivacyToggle(driver);
        registerPage.clickOnContinueBtn();
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());

        boolean urlContainsTheCorrectKeywords = driver.getCurrentUrl().contains("/index.php?route=account/success&language");
        Assertions.assertFalse(urlContainsTheCorrectKeywords, "The Url" + driver.getCurrentUrl() + "does not contain success keyword");

        boolean urlContainsRegisterKeyword = driver.getCurrentUrl().contains("register");
        Assertions.assertTrue(urlContainsRegisterKeyword, "The url belongs to register page");

    }

    @AfterEach
    public void executeThisMetodAfterEachExec(){
        DriverManager.getInstance().quitTheDriver();
        System.out.println("The test number " + counter + " finished");
    }
}
