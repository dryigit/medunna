package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US008Page;
import pages.US019_Page;
import utilities.ConfigReader;
import utilities.Driver;


import static utilities.ReusableMethods.waitForClickablility;

public class US019_StepDefinitions {

    US008Page us008Page = new US008Page();
    US019_Page us019_page = new US019_Page();

    @Given("AdminOkan signs in from home page by own admin {string} and {string}")
    public void adminokanSignsInFromHomePageByOwnAdminAnd(String username, String password) {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaURL"));

        us008Page.ikon.click();
        us008Page.ikonSignIn.click();
        us008Page.username.sendKeys(username);
        us008Page.password.sendKeys(password);
        us008Page.signInSignInButton.click();

    }

    @Then("AdminOkan clicks the User Management from Administration title")
    public void adminokanClicksTheUserManagementFromAdministrationTitle() {

        us019_page.administrationTitle.click();
        us019_page.userManagementButton.click();

    }

    @And("AdminOkan clicks the Create a new User")
    public void adminokanClicksTheCreateANewUser() {
        us019_page.createNewUserButton.click();

    }

    @And("AdminOkan enters the info all text boxs, select the language & role and clicks the save button")
    public void adminokanEntersTheInfoAllTextBoxsSelectTheLanguageRoleAndClicksTheSaveButton()  {

        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());

        actions.click(us019_page.createLogin).sendKeys(faker.name().username()).perform();

        actions.click(us019_page.createFirstName).sendKeys(faker.name().firstName()).perform();

        actions.click(us019_page.createLastName).sendKeys(faker.name().lastName()).perform();

        actions.click(us019_page.createEmail).sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).perform();

        // sonraki test case'lere ait steplerde kullanmak icin SSN'i bir variable atıyoruz
        String SSN = faker.idNumber().ssnValid();
        System.out.println(SSN);
        us019_page.createSSN.sendKeys(SSN);
        actions.sendKeys(Keys.TAB);

        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.TAB).perform();

        // dropdown menu
        Select select = new Select(us019_page.selectProfile);
        select.selectByIndex(3);

        waitForClickablility(us019_page.saveButton, 3);
        us019_page.saveButton.submit();
    }

    @And("AdminOkan verifies the successful save process")
    public void adminokanVerifiesTheSuccessfulSaveProcess() {
        Assert.assertTrue(us019_page.toastifyBasariliSave.isDisplayed());
    }


    @Then("AdminOkan clicks the Staff in dropdown menu from Items&Titles")
    public void adminokanClicksTheStaffInDropdownMenuFromItemsTitles() {

    }

    @And("AdminOkan enters the SSN and searches")
    public void adminokanEntersTheSSNAndSearches() {
    }

    @And("AdminOkan should populate the text box which is null {string} {string} {string} and save")
    public void adminokanShouldPopulateTheTextBoxWhichIsNullAndSave(String arg0, String arg1, String arg2) {
    }
}
