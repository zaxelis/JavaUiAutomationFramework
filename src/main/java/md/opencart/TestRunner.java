package md.opencart;

import md.opencart.managers.DataFakerManager;
import md.opencart.managers.DriverManager;
import org.openqa.selenium.*;

public class TestRunner {

    public static void main(String[] args) throws InterruptedException {
        DriverManager driverManager = DriverManager.getInstance();
        WebDriver driver = driverManager.getDriver();

        driver.get("https://www.google.com/");

        String currentWindowName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://andreisecuqa.host/");

        WebElement accountIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        accountIcon.click();

        WebElement registerBtn = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerBtn.click();

        String firstName = DataFakerManager.getRandomName();
        System.out.println("The generated first name is: " + firstName);

        String lastName = DataFakerManager.getRandomName();
        System.out.println("The generated last name is: " + lastName);

        String email = DataFakerManager.getRandomEmail();
        System.out.println("The generated email name is: " + email);

        String passowrd = DataFakerManager.getRandomPass();
        System.out.println("The generated password is: " + passowrd);

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys(firstName);

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys(lastName);

        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys((passowrd));

        WebElement privateToggle = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privateToggle);
        Thread.sleep(500);
        privateToggle.click();

        WebElement continueBtn = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        continueBtn.click();

        Thread.sleep(5000);

        System.out.println(driver.getCurrentUrl());

        driver.close();
        driver.switchTo().window(currentWindowName);

        driver.get(("https://andreisecuqa.host/"));

        driver.quit();

        System.out.println("The execution was finished");


    }
}