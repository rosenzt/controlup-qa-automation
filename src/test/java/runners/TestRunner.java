package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * TestRunner - Executes Cucumber tests using TestNG.
 * Loads feature files and binds step definitions.
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "apiSteps", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}//class
