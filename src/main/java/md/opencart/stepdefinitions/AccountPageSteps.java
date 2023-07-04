package md.opencart.stepdefinitions;

import io.cucumber.java.en.Then;
import md.opencart.managers.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AccountPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Then("the new page url contains {string} keyword")
    public void theNewPageUrlContainsKeyword(String collectedKeyword) throws InterruptedException {


    }
}
