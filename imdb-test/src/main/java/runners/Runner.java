package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"features"},
        glue = {"steps"},
        dryRun = false
)
public class Runner extends AbstractTestNGCucumberTests{
}