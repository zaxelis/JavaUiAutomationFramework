package md.opencart;

import md.opencart.managers.DataFakerManager;
import md.opencart.managers.DriverManager;
import md.opencart.pageobjects.AccountCreatedPage;
import md.opencart.pageobjects.HomePage;
import md.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        driver.get("https://andreisecuqa.host/");

        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPageFromHeaderMenu();

        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String randomEmail = DataFakerManager.getRandomEmail();
        String password = DataFakerManager.getRandomPass();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, password);
        registerPage.switchOnThePrivacyToggle(driver);
        registerPage.clickOnContinueBtn();
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());

        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.logoutFromTheAccount();
        Thread.sleep(1000);
        System.out.println(driver.getCurrentUrl());

        driver.quit();

        System.out.println("The execution was finished");
    }

}
