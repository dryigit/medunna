package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.Us013_Page;
import pages.Us014_Page;
import utilities.Driver;
import utilities.ReusableMethods;

public class US0014_StepDefinitions {


    Us013_Page us013_page=new Us013_Page();
    Us014_Page us014_page=new Us014_Page();
    Actions actions=new Actions(Driver.getDriver());







    @Then("My Inpatients butonuna tiklar")
    public void myInpatientsButonunaTiklar() {
       us013_page .yatılıHastaButonu.click();
    }

    @And("Yatili Hasta bilgileri için edit tiklanir")
    public void yatiliHastaBilgileriIçinEditTiklanir() {

        us014_page.yatiliHastaEdit.click();

    }



    @Then("doktor yatili hatasta bilgilerini görebilmeli")
    public void doktorYatiliHatastaBilgileriniGörebilmeli() {

        ReusableMethods.waitFor(2);
        Assert.assertTrue(us014_page.idAlani.isDisplayed());
        Assert.assertTrue(us014_page.startDateAlani.isDisplayed());

        ReusableMethods.waitFor(2);
        Assert.assertTrue(us014_page.endDateAlani.isDisplayed());
        Assert.assertTrue(us014_page.descriptionAlani.isDisplayed());
        Assert.assertTrue(us014_page.createdDateAlani.isDisplayed());

        actions.sendKeys(Keys.PAGE_DOWN).perform();

       Assert.assertTrue(us014_page.appointmentidAlani.isDisplayed());
        ReusableMethods.waitForVisibility(us014_page.statusAlani,2);
        Assert.assertTrue(us014_page.statusAlani.isDisplayed());
        ReusableMethods.waitFor(2);
        Assert.assertTrue(us014_page.roomidAlani.isDisplayed());
        Assert.assertTrue(us014_page.patientidAlani.isDisplayed());

        ReusableMethods.waitForClickablility(us014_page.saveButonu,5);

//        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
//        jsexecutor.executeScript("arguments[0].click();", us014_page.saveButonu);





    }

    @And("doktor yatili hasta bilgilerini günceller")
    public void doktorYatiliHastaBilgileriniGünceller() {




        actions.sendKeys(Keys.PAGE_UP).perform();

        us014_page.idAlani.sendKeys("50000");
        us014_page.startDateAlani.sendKeys("11.05.2022");
        us014_page.endDateAlani.sendKeys("11.07.2022 15:00");
        us014_page.descriptionAlani.sendKeys("yaşıyacak");
        actions.sendKeys(Keys.TAB).perform();
        us014_page.createdDateAlani.sendKeys("14.05.2022" );
        actions.sendKeys(Keys.TAB).perform();
        us014_page.createdDateAlani.sendKeys("12:25" );
        actions.sendKeys(Keys.TAB).perform();
        Assert.assertFalse(us014_page.appointmentidAlani.isEnabled());

        Select select=new Select(us014_page.statusAlani);
        select.selectByValue("STAYING");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Select select1=new Select(us014_page.roomidAlani);
        select1.selectByVisibleText("122:TWIN free room");

        Assert.assertFalse(us014_page.patientidAlani.isEnabled());



       // ReusableMethods.waitForClickablility(us014_page.saveButonu,5);

        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].click();", us014_page.saveButonu);


    }

    //********************tc002

    @Given("status bilgilerini güncelleyebilmeli")
    public void statusBilgileriniGüncelleyebilmeli() {


     //  ReusableMethods.scrollToWebEementVisivle(us014_page.statusAlanı);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        Select select2=new Select(us014_page.statusAlani);
        select2.selectByIndex(1);

    }




    //tc003*************************

    @Given("oda güncelleme")
    public void odaGüncelleme() {

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Select select3=new Select(us014_page.roomidAlani);
        select3.selectByIndex(4);
    }















}
