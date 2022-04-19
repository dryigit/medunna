package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin={"html:target//cucumber-reports.html",
                    "json:target/json-reports/cucumber.json",
                    "rerun:target/failedRerun.txt"},
            features="src/test/resources/features",
            glue="stepdefinitions",
            tags="@US16",
            dryRun=false
    )

    public class Runner {
}
