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
import utilities.Driver;
import utilities.ReusableMethods;

public class US0014_StepDefinitions {


    Us013_Page us013_page=new Us013_Page();
    Us014_Page us014_page=new Us014_Page();
    Actions actions=new Actions(Driver.getDriver());







    @Then("My Inpatients butonuna tıklar")
    public void myInpatientsButonunaTıklar() {
       us013_page .yatılıHastaButonu.click();
    }

    @And("Yatılı Hasta bilgileri için edit tıklanır")
    public void yatılıHastaBilgileriIçinEditTıklanır() {

        us014_page.yatılıHastaEdit.click();

    }



    @Then("doktor yatılı hatasta bilgilerini görebilmeli")
    public void doktorYatılıHatastaBilgileriniGörebilmeli() {

        ReusableMethods.waitFor(2);
        Assert.assertTrue(us014_page.idAlanı.isDisplayed());
        Assert.assertTrue(us014_page.startDateAlanı.isDisplayed());

        ReusableMethods.waitFor(2);
        Assert.assertTrue(us014_page.endDateAlanı.isDisplayed());
        Assert.assertTrue(us014_page.descriptionAlanı.isDisplayed());
        Assert.assertTrue(us014_page.createdDateAlanı.isDisplayed());

        actions.sendKeys(Keys.PAGE_DOWN).perform();

       Assert.assertTrue(us014_page.appointmentidAlanı.isDisplayed());
        ReusableMethods.waitForVisibility(us014_page.statusAlanı,2);
        Assert.assertTrue(us014_page.statusAlanı.isDisplayed());
        ReusableMethods.waitFor(2);
        Assert.assertTrue(us014_page.roomidAlanı.isDisplayed());
        Assert.assertTrue(us014_page.patientidAlanı.isDisplayed());

        ReusableMethods.waitForClickablility(us014_page.saveButonu,5);

//        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
//        jsexecutor.executeScript("arguments[0].click();", us014_page.saveButonu);





    }

    @And("doktor yatılı hasta bilgilerini günceller")
    public void doktorYatılıHastaBilgileriniGünceller() {




        actions.sendKeys(Keys.PAGE_UP).perform();

        us014_page.idAlanı.sendKeys("50000");
        us014_page.startDateAlanı.sendKeys("11.05.2022");
        us014_page.endDateAlanı.sendKeys("11.07.2022 15:00");
        us014_page.descriptionAlanı.sendKeys("yaşıyacak");
        actions.sendKeys(Keys.TAB).perform();
        us014_page.createdDateAlanı.sendKeys("14.05.2022" );
        actions.sendKeys(Keys.TAB).perform();
        us014_page.createdDateAlanı.sendKeys("12:25" );
        actions.sendKeys(Keys.TAB).perform();
        Assert.assertFalse(us014_page.appointmentidAlanı.isEnabled());

        Select select=new Select(us014_page.statusAlanı);
        select.selectByValue("STAYING");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Select select1=new Select(us014_page.roomidAlanı);
        select1.selectByVisibleText("122:TWIN free room");

        Assert.assertFalse(us014_page.patientidAlanı.isEnabled());



       // ReusableMethods.waitForClickablility(us014_page.saveButonu,5);

        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].click();", us014_page.saveButonu);


    }

    //********************tc002

    @Given("status bilgilerini güncelleyebilmeli")
    public void statusBilgileriniGüncelleyebilmeli() {


     //  ReusableMethods.scrollToWebEementVisivle(us014_page.statusAlanı);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        Select select2=new Select(us014_page.statusAlanı);
        select2.selectByIndex(1);

    }




    //tc003*************************

    @Given("oda güncelleme")
    public void odaGüncelleme() {

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Select select3=new Select(us014_page.roomidAlanı);
        select3.selectByIndex(4);
    }















}
