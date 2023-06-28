package md.opencart;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/md/opencart/features",
        glue = "md/opencart/stepdefinitions",
        tags = "",
        plugin = {"pretty", "html:target/cucumber-reports"}
)

public class CucumberTestRunner {
}
