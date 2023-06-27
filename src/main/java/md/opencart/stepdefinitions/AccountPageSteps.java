package md.opencart.stepdefinitions;

import io.cucumber.java.en.Then;
import md.opencart.managers.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AccountPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Then("the new page url contains {string} keyword")
    public void theNewPageUrlContainsKeyword(String collectedKeyword) throws InterruptedException {
        Thread.sleep(500);
        boolean urlContainsCollectedKeyword = driver.getCurrentUrl().contains(collectedKeyword);
        System.out.println(driver.getCurrentUrl());
        Assertions.assertTrue(urlContainsCollectedKeyword, "The " + collectedKeyword + " is present on our URL");


    }
}
