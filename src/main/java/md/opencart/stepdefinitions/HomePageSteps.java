package md.opencart.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import md.opencart.managers.DriverManager;
import md.opencart.pageobjects.HomePage;

public class HomePageSteps {

    HomePage homePage = new HomePage (DriverManager.getInstance().getDriver());

    @Given("Home Page is accessed")
    public void homePageIsAccessed() {
        DriverManager.getInstance().getDriver().get("https://andreisecuqa.host/");
    }

    @And("RegisterPage is accessed from HomePage menu")
    public void registerPageIsAccessedFromHomePageMenu() {
        homePage.navigateToRegisterPageFromHeaderMenu();
    }
}
