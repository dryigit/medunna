package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US008Page;
import pages.US019_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;


import static utilities.Driver.driver;
import static utilities.ReusableMethods.scrollToWebEementVisivle;
import static utilities.ReusableMethods.waitForClickablility;

public class US019_StepDefinitions {

    US008Page us008Page = new US008Page();
    US019_Page us019_page = new US019_Page();
    static String SSN=null;

    // US019_TC_01_Admin can create a new staff

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
        waitForClickablility(us019_page.administrationTitle, 10);
        us019_page.administrationTitle.click();

        waitForClickablility(us019_page.userManagementButton, 10);
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
        SSN = faker.idNumber().ssnValid();
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
        System.out.println(us019_page.toastifyBasariliSave.getText()); // ya toastify i yakalayamıyor ya da text yok
        System.out.println(SSN);
    }

    @Then("AdminOkan sign out yapar")
    public void adminokanSignOutYapar() {

        us019_page.userMenuDropdown.click();
        us019_page.signOutDropdown.click();
    }


    // US019_TC_02_Admin can search new Staff among registered people using their SSN

    @Then("AdminOkan clicks the Staff in dropdown menu from Items&Titles")
    public void adminokanClicksTheStaffInDropdownMenuFromItemsTitles() {
        us019_page.itemTitlesMenu.click();
        us019_page.staffButton.click();

       // Select select = new Select(us019_page.itemTitlesDropdown);
       // select.selectByValue("Staff");

    }

    @And("AdminOkan clicks the Create a new Staff")
    public void adminokanClicksTheCreateANewStaff() {

        us019_page.createNewStaff.click();
    }

    @And("AdminOkan enters the SSN {string} and searches")
    public void adminokanEntersTheSSNAndSearches(String SSN) {

        us019_page.ssnSearchCheckBox.click();
        us019_page.ssnSearchBox.sendKeys(SSN);
        us019_page.ssnSearchButton.click();

    }

    @And("AdminOkan should populate the text box which is null {string} {string} {string} and save")
    public void adminokanShouldPopulateTheTextBoxWhichIsNullAndSave(String phone, String address, String description)  {

        us019_page.staffPhone.sendKeys(phone);
        us019_page.staffAddress.sendKeys(address);
        us019_page.staffDesc.sendKeys(description);

        waitForClickablility(us019_page.staffCountryDropdown, 2);

        Select select = new Select(us019_page.staffCountryDropdown);
        select.selectByIndex(1);
        us019_page.staffCountryDropdown.submit();

        /*
        scrollToWebEementVisivle(us019_page.staffStateDropdown);

        Select select1 = new Select(us019_page.staffStateDropdown);
        select1.selectByIndex(0);
        */
        // State/City locate almıyor ya da görünmüyor

        scrollToWebEementVisivle(us019_page.saveButtonCreateStaff);
        us019_page.saveButtonCreateStaff.isEnabled();
        // manuel ve otomasyonda save yapmıyor; internal server error hatası veriyor
    }

    @And("AdminOkan verifies the search result")
    public void adminokanVerifiesTheSearchResult() {

    }

    // US019_TC_03_Admin can edit staff information

    @And("AdminOkan finds the record to edit")
    public void adminokanFindsTheRecordToEdit() {

        us019_page.idButton.click();
        us019_page.editButton.click();
    }
    @And("AdminOkan edits some info {string} and save")
    public void adminokanEditsSomeInfoAndSave(String email) {

        us019_page.editEmail.clear();
        us019_page.editEmail.sendKeys(email);

        waitForClickablility(us019_page.editSaveButton, 10);
        JSUtils.clickElementByJS(us019_page.editSaveButton);

        //JSUtils.scrollIntoVIewJS(us019_page.editSaveButton);
        //us019_page.editSaveButton.click();
    }

    @And("AdminOkan verifies the successful edit process")
    public void adminokanVerifiesTheSuccessfulEditProcess() {

    }


    // US019_TC_04_Admin can select a user from the existing users
    @And("AdminOkan can select a user from the existing users")
    public void adminokanCanSelectAUserFromTheExistingUsers() {
        us019_page.viewButton.click();

    }

    @And("AdminOkan verifies the visibility of selected user info")
    public void adminokanVerifiesTheVisibilityOfSelectedUserInfo() {
       // us019_page.userSystema.getText().contains("systema");


    }

    // US019_TC_05_Admin can delete created Staff
    @And("AdminOkan finds the record of newly staff")
    public void adminokanFindsTheRecordOfNewlyStaff() {

       us019_page.idButton.click();

    }

    @And("AdminOkan deletes the new staff record")
    public void adminokanDeletesTheNewStaffRecord() {

        String actualStaffSSN = us019_page.newlyStaffSSN.getText();
        System.out.println("Expected SSN :" + SSN);
        System.out.println("Actual SSN :" + actualStaffSSN);
/*
        Assert.assertEquals(SSN, actualStaffSSN);

*/
        waitForClickablility(us019_page.deleteButton, 10);
        us019_page.deleteButton.click();

         // confirm Delete
        //JSUtils.clickElementByJS(us019_page.deleteConfirmButton);
        waitForClickablility(us019_page.deleteConfirmButton, 5);
        us019_page.deleteConfirmButton.click();
    }

    @Then("AdminOkan verifies the successful delete process")
    public void adminokanVerifiesTheSuccessfulDeleteProcess() {


        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();

        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", us019_page.toastifyDeleteConfirm);

    }

}
