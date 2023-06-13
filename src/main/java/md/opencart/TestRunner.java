package md.opencart;

import md.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        DriverManager driverManager = DriverManager.getInstance();
        WebDriver driver = driverManager.getDriver();

        driver.get("https://www.google.com/");
        Thread.sleep(1000);
        String currentWindowName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://tekwill.md/tekwill-academy/");
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window((currentWindowName));

        driver.get("https://www.youtube.com/");
        Thread.sleep(1000);

        driver.quit();

        System.out.println("The code was executed successfully");

    }
}