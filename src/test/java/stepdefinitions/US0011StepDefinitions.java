package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
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

    @Then("yep click Appointment link")
    public void yepClickAppointmentLink() {
        uspage.makeAnApp.click();
    }

    @And("yep write information to make an appoinment")
    public void yepWriteInformationToMakeAnAppoinment() {

        uspage.appFirstname.sendKeys(ConfigReader.getProperty("US11FirstName"));
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("US11LastName")).
                sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("US11SSN")).
                sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("US11Mail")).
                sendKeys(Keys.TAB).sendKeys("1234567890").
                sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("US11Mail")).
        perform();
               }

    @Then("yep send an appointment request")
    public void yepSendAnAppointmentRequest() {
        uspage.appReqSubButton.click();
    }
}
