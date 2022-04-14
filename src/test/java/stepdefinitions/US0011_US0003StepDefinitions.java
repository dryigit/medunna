package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US011_US003Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;

public class US0011_US0003StepDefinitions {
    US011_US003Page uspage = new US011_US003Page();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();

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
        Actions actions = new Actions(Driver.getDriver());
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


    @Then("yep verify tostify text {string}")
    public void yepVerifyTostifyText(String metin) throws IOException {
        ReusableMethods.getScreenshot("tostify");
        String toasttext = uspage.toasttify.getText().toString();
        System.out.println("writen text " + toasttext);
        Assert.assertTrue(toasttext.contains(metin));
    }

    @And("yep click to popup")
    public void yepClickToPopup() {
        uspage.popup.click();
    }

    @Then("yep click to logIn")
    public void yepClickToLogIn() {
        uspage.signin.click();
    }

    @And("yep give username and pasword to sign in")
    public void yepGiveUsernameAndPaswordToSignIn() {
        uspage.signinUsername.sendKeys(ConfigReader.getProperty("US11doctor"));
        uspage.signinPasword.sendKeys(ConfigReader.getProperty("US11Password"));
        uspage.submit.click();
    }

    @Then("yep doctor click to Mypages and myappointments")
    public void yepDoctorClickToMypagesAndMyappointments() {
      uspage.mypages.click();
       uspage.doctorMyappointments.click();
    }

    @And("yep doctor choose date")
    public void yepDoctorChooseDate() {
        uspage.appFromDate.sendKeys("4/10/2022");
        uspage.apptoDate.sendKeys("4/24/2022");

/*uspage.appFromDate.sendKeys("4");
actions.sendKeys(Keys.TAB).sendKeys("10").sendKeys(Keys.TAB).
        sendKeys(Keys.TAB).sendKeys("4").sendKeys(Keys.TAB).sendKeys("24").sendKeys(Keys.TAB).perform();
      */
        // uspage.appFromDate.sendKeys("22");
        //    uspage.appFromDate.sendKeys("2022");


//uspage.apptoDate.sendKeys("04/24");
    }

    @Then("yep doctor edits {string} number appointment")
    public void yepDoctorEditsNumberAppointment(String hastano) {

        String xpath = "//tbody//tr[" + hastano + "]//td[13]";
        WebElement patientEditButton = Driver.getDriver().findElement(By.xpath(xpath));
        ReusableMethods.waitForVisibility(patientEditButton, 5);
        patientEditButton.click();

    }

    @And("yep doctor can see patient knowledge")
    public void yepDoctorCanSeePatientKnowledge() {
        ReusableMethods.waitForVisibility(uspage.apppatientId, 5);
        Assert.assertTrue(uspage.apppatientId.isDisplayed());
        Assert.assertTrue(uspage.appstartdate.isDisplayed());
        Assert.assertTrue(uspage.appenddate.isDisplayed());

        Select select = new Select(uspage.appstatus);


        List<WebElement> status = select.getOptions();
        WebElement third = status.get(2);
        System.out.println("ucuncu option " + third.getText().toString());
        select.selectByIndex(2);
        Assert.assertTrue(status.get(2).isSelected());
        select.selectByIndex(1);
        Assert.assertTrue(status.get(1).isSelected());
        select.selectByIndex(3);
        Assert.assertTrue(status.get(3).isSelected());
        // JSUtils.scrollIntoVIewJS(uspage.treatmnt);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(uspage.anemsis.isDisplayed());

        uspage.anemsis.click();
        uspage.treatmnt.click();
        actions.sendKeys(Keys.TAB).perform();
        String path = "(//div[@class='invalid-feedback'])[1]";

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath(path)).isDisplayed());
        Assert.assertTrue(uspage.treatmnt.isDisplayed());
        actions.sendKeys(Keys.TAB).perform();
        String path2 = "(//div[@class='invalid-feedback'])[2]";

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath(path2)).isDisplayed());
        Assert.assertTrue(uspage.diagnos.isDisplayed());
        uspage.diagnos.click();
        actions.sendKeys(Keys.TAB).perform();
        uspage.prescrip.click();
        //     CSSValue==
        uspage.descript.click();

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        String path3 = "(//div[@class='invalid-feedback'])[3]";
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath(path3)).isDisplayed());
        //JSUtils.scrollIntoVIewJS(uspage.appstatus);
        Assert.assertTrue(uspage.appstatus.isDisplayed());
        //JSUtils.scrollIntoVIewJS(uspage.apppyschn);
        JSUtils.scrollIntoVIewJS(uspage.appsave);
        Assert.assertTrue(uspage.apppyschn.isDisplayed());

    }

    @Then("yep click to register")
    public void yepClickToRegister() {
        uspage.register.click();

    }


    @And("yep give {string} and {string} and {string}and {string} and {string}")
    public void yepGiveAndAndAndAnd(String ssn, String firstname, String lastname, String username, String email) {
        uspage.ssn.sendKeys(ssn);
        actions.sendKeys(Keys.TAB).sendKeys(firstname).
                sendKeys(Keys.TAB).sendKeys(lastname).
                sendKeys(Keys.TAB).sendKeys(username).
                sendKeys(Keys.TAB).sendKeys(email).perform();


    }


    @And("yep give username and pasword to sign in as a staff")
    public void yepGiveUsernameAndPaswordToSignInAsAStaff() {
        uspage.signinUsername.sendKeys("staffjos");
        uspage.signinPasword.sendKeys(ConfigReader.getProperty("US11Password"));
        uspage.submit.click();
       uspage.mypages.click();
        uspage.searchpat.click();
        uspage.ssn.sendKeys(ConfigReader.getProperty("US11SSN"));
        actions.dragAndDrop(uspage.tableresp, uspage.showapp).perform();
        uspage.showapp.click();
        uspage.appedit.click();
        JSUtils.scrollIntoVIewJS(uspage.appstatus);

        Select select = new Select(uspage.appstatus);
        select.selectByIndex(1);
//JSUtils.scrollIntoVIewJS(uspage.apppyschn);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Select select1 = new Select(uspage.apppyschn);
        select1.selectByValue("46096");
        uspage.appsave.click();

    }

    @Then("yep staff can see updating message")
    public void yepStaffCanSeeUpdatingMessage() throws InterruptedException {
        Thread.sleep(2);
        String tostos = uspage.toasttify.getText().toString();
        System.out.println("tostos mesaji : " + tostos);
        Assert.assertTrue(tostos.contains("date"));

    }

    @Then("yep give password different conditions")
    public void yepGivePasswordDifferentConditions() {

    }

    @And("yep verfy password strength conditions")
    public void yepVerfyPasswordStrengthConditions() {
        actions.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.waitForVisibility(uspage.password, 5);

        // Assert.assertTrue(uspage.passwordFirstCond.isDisplayed());
/*
        WebElement element = Driver.getDriver().findElement(By.xpath("(//li[@class='point'])[1]"));
        String color = element.getAttribute("style");
        System.out.println("colour : " + color); */
/*
rgb renk kodlari :
rgb(221, 221, 221);   gri
rgb(255, 0, 0);      kirmizi
 rgb(0, 255, 0);     yesil
 */

        for (int i = 1; i < 6; i++) {

            switch (i) {
                case 1:
                    uspage.password.sendKeys("123-AAA");
                    for (int j = 1; j < 6; j++) {// ilk 4 ü yesil 5. gri mi
                        WebElement con1 = Driver.getDriver().findElement(By.xpath("(//li[@class='point'])[" + j + "]"));
                        String renk = con1.getAttribute("style");
                        System.out.println("password  123-AAA  iken :" + j + " . part renk durumu  " + renk);
                        if (j!=5)
                            Assert.assertTrue(con1.getAttribute("style").contains("rgb(153, 255, 0)"));
                        else
                            Assert.assertTrue(con1.getAttribute("style").contains("rgb(221, 221, 221)"));

                    }

                    uspage.password.sendKeys("a");
                    for (int j = 1; j < 6; j++) {
                        WebElement con1 = Driver.getDriver().findElement(By.xpath("(//li[@class='point'])[" + j + "]"));
                        String renk = con1.getAttribute("style");
                        System.out.println("password  123-AAAa  iken :" + j + " . part renk durumu  " + renk);
                        // hepsi yesil
                        Assert.assertTrue(con1.getAttribute("style").contains("rgb(0, 255, 0)")); // hepsi yesilmi
                    }
                    uspage.password.clear();
                    break;
                case 2:
                    uspage.password.sendKeys("123-aaa");
                    for (int j = 1; j < 6; j++) {
                        WebElement con1 = Driver.getDriver().findElement(By.xpath("(//li[@class='point'])[" + j + "]"));
                        String renk = con1.getAttribute("style");
                        System.out.println("password  123-aaa  iken :" + j + " . part renk durumu  " + renk);
                        // ilk 4 ü yesil 5. gri mi
                        if (j!=5)
                            Assert.assertTrue(con1.getAttribute("style").contains("rgb(153, 255, 0)"));
                        else
                            Assert.assertTrue(con1.getAttribute("style").contains("rgb(221, 221, 221)"));

                    }
                    uspage.password.sendKeys("A");
                    for (int j = 1; j < 6; j++) {
                        WebElement con1 = Driver.getDriver().findElement(By.xpath("(//li[@class='point'])[" + j + "]"));
                        String renk = con1.getAttribute("style");
                        System.out.println("password  123-aaaA  iken :" + j + " . part renk durumu  " + renk);
                        // hepsi yesil
                        Assert.assertTrue(con1.getAttribute("style").contains("rgb(0, 255, 0)"));// hepsi yesilmi
                    }
                    uspage.password.clear();
                    break;
                case 3:
                    uspage.password.sendKeys("AAA-aaa");
                    for (int j = 1; j < 6; j++) {
                        WebElement con1 = Driver.getDriver().findElement(By.xpath("(//li[@class='point'])[" + j + "]"));
                        String renk = con1.getAttribute("style");
                        System.out.println("password  AAA-aaa  iken :" + j + " . part renk durumu  " + renk);
                        // ilk 4 ü yesil 5. gri mi
                        if (j!=5)
                            Assert.assertTrue(con1.getAttribute("style").contains("rgb(153, 255, 0)"));
                        else
                            Assert.assertTrue(con1.getAttribute("style").contains("rgb(221, 221, 221)"));
                    }
                    uspage.password.sendKeys("1");
                    for (int j = 1; j < 6; j++) {
                        WebElement con1 = Driver.getDriver().findElement(By.xpath("(//li[@class='point'])[" + j + "]"));
                        String renk = con1.getAttribute("style");
                        System.out.println("password  AAA-aaa1  iken :" + j + " . part renk durumu  " + renk);
                        Assert.assertTrue(con1.getAttribute("style").contains("rgb(0, 255, 0)"));// hepsi yesilmi
                    }
                    uspage.password.clear();
                    break;

                case 4:
                    uspage.password.sendKeys("AAA1aaa");
                    for (int j = 1; j < 6; j++) {
                        WebElement con1 = Driver.getDriver().findElement(By.xpath("(//li[@class='point'])[" + j + "]"));
                        String renk = con1.getAttribute("style");
                        System.out.println("password  AAA1aaa  iken :" + j + " . part renk durumu  " + renk);
                        // ilk 4 ü yesil 5. gri mi
                        if (j!=5)
                            Assert.assertTrue(con1.getAttribute("style").contains("rgb(153, 255, 0)"));
                        else
                            Assert.assertTrue(con1.getAttribute("style").contains("rgb(221, 221, 221)"));
                    }
                    uspage.password.sendKeys("-");
                    for (int j = 1; j < 6; j++) {
                        WebElement con1 = Driver.getDriver().findElement(By.xpath("(//li[@class='point'])[" + j + "]"));
                        String renk = con1.getAttribute("style");
                        System.out.println("password  AAA1aaa-  iken :" + j + " . part renk durumu  " + renk);
                        Assert.assertTrue(con1.getAttribute("style").contains("rgb(0, 255, 0)"));// hepsi yesilmi
                    }
                    uspage.password.clear();
                    break;

                case 5:
                    uspage.password.sendKeys("A.11a-");
                    for (int j = 1; j < 6; j++) {
                        WebElement con1 = Driver.getDriver().findElement(By.xpath("(//li[@class='point'])[" + j + "]"));
                        String renk = con1.getAttribute("style");
                        System.out.println("password  A.11a-  iken :" + j + " . part renk durumu  " + renk);
                        // ilk 4 ü yesil 5. gri mi
                        if (j==1)
                            Assert.assertTrue(con1.getAttribute("style").contains("rgb(255, 0, 0)"));
                        else
                            Assert.assertTrue(con1.getAttribute("style").contains("rgb(221, 221, 221)"));
                    }
                    uspage.password.sendKeys("1");
                    for (int j = 1; j < 6; j++) {
                        WebElement con1 = Driver.getDriver().findElement(By.xpath("(//li[@class='point'])[" + j + "]"));
                        String renk = con1.getAttribute("style");
                        System.out.println("password  A.11a-1  iken :" + j + " . part renk durumu  " + renk);
                        Assert.assertTrue(con1.getAttribute("style").contains("rgb(0, 255, 0)"));// hepsi yesilmi
                    }
                    uspage.password.clear();
                    break;


            }


        }
    }


}
