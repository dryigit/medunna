package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.US011Page;
import utilities.ConfigReader;
import utilities.Driver;

public class US0011StepDefinitions {
US011Page uspage=new US011Page();

    @Given("yep goes to {string} website")
    public void yepGoesToWebsite(String website) {
        Driver.getDriver().get(ConfigReader.getProperty(website));
    }

    @Then("yep click about")
    public void yepClickAbout() {

        uspage.aboutlink.click();
    }
}
