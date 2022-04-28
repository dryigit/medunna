package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US021_US022Page;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class US021_US022StepDefinitions {

    US021_US022Page us021Page= new US021_US022Page();
    Actions actions=new Actions(Driver.getDriver());

    @Given("Kullanici anasayfaya gider")
    public void kullanici_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaURL"));
    }


    @Given("Kullanici seceneklerden Sign in secer")
    public void kullanici_seceneklerden_sign_in_secer() {
        us021Page.signinsecenegi.click();
    }

    @Given("Kullanici username ve password bilgilerini girer")
    public void kullanici_username_ve_password_bilgilerini_girer() {
        us021Page.usernametexbox.click();
        us021Page.usernametexbox.sendKeys("staffmerveoo");
        us021Page.passwordtexbox.click();
        us021Page.passwordtexbox.sendKeys("merve8280");
    }

    @Given("Kullanici seceneklerden In Patient secer")
    public void kullanici_seceneklerden_in_patient_secer() {
        us021Page.inpatientbutonu.click();
    }

    @Given("Kullanici Start DateTime texboxini gunceller")
    public void kullanici_start_datetime_texboxini_gunceller() {
        us021Page.startdatetexbox.click();
        actions.click(us021Page.startdatetexbox)
                .sendKeys("02.04.2022")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("02.04.2022").perform();

    }


    @Given("Kullanici seceneklerden Search Patient secer")
    public void kullanici_seceneklerden_search_patient_secer() {
        us021Page.searchpatientbutonu.click();
    }

    @Given("Kullanici Patient SSN texboxina hastanin SSN nosunu girer")
    public void kullanici_patient_ssn_texboxina_hastanin_ssn_nosunu_girer() {
        us021Page.patientssntexbox.click();
        us021Page.patientssntexbox.sendKeys("888-89-8970");
    }

    @Given("Kullanici Edit butonuna tiklar")
    public void kullanici_edit_butonuna_tiklar() {
        us021Page.editbutonu.click();
    }

    @When("Kullanici Status texboxina tiklar")
    public void kullanici_status_texboxina_tiklar() {

    }

    @When("Kullanici Unapproved,Pending ve Cancelled secenegini secebildigini test eder")
    public void kullanici_unapproved_secenegini_secebildigini_test_eder() throws InterruptedException {
       Select select=new Select(us021Page.statustexbox);
        List<WebElement> status = select.getOptions();
        WebElement first = status.get(0);
        System.out.println("birinci eleman = " + first.getText().toString());
        Thread.sleep(3000);
        select.selectByIndex(0);
        Assert.assertTrue(status.get(0).isSelected());
        select.selectByIndex(1);
        Assert.assertTrue(status.get(1).isSelected());
        select.selectByIndex(3);
        Assert.assertTrue(status.get(3).isSelected());
    }


    @When("Kullanici Completed secenegini secemedigini test eder")
    public void kullanici_unapproved_secenegini_secemedigini_test_eder() {
        Select select =new Select(us021Page.statustexbox);
        List<WebElement> status = select.getOptions();
        WebElement third = status.get(2);
        System.out.println("ucuncu eleman = " + third.getText().toString());
        select.selectByIndex(2);
        Assert.assertFalse(status.get(2).isSelected());
    }

    @Given("Kullanici Show Appointments butonuna tiklar")
    public void kullanici_show_appointments_butonuna_tiklar() {
        us021Page.showappaointmentsbutonu.click();
    }

    @When("Kullanici Anamnesis, Treatment ve Diagnosis texboxina tiklayabildigini test eder")
    public void kullanici_anamnesis_texboxina_tiklayabildigini_test_eder() {
        //us021Page.anamnesistexbox.click();
        Assert.assertFalse(us021Page.anamnesistexbox.isEnabled());
        Assert.assertFalse(us021Page.treatmenttexbox.isEnabled());
        Assert.assertFalse(us021Page.diagnosistexbox.isEnabled());

    }

    @And("Kullanici Physician texboxinda doktoru secer")
    public void kullaniciPhysicianTexboxindaDoktoruSecer() throws InterruptedException {

        Select doktor=new Select(us021Page.physiciantexbox);
        doktor.selectByVisibleText("46051:Merve doktor:PSYCHIATRY");

    }

    @Then("Kullanici Save butonuna tiklar")
    public void kullanici_save_butonuna_tiklar() throws InterruptedException {
      //Thread.sleep(3000);
       //actions.click(us021Page.savebutonu).perform();
        Thread.sleep(2000);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();

        javascriptExecutor.executeScript("arguments[0].click();", us021Page.savebutonu);
        Thread.sleep(2000);
    }


    @Then("Kullanici SignIn butonuna tiklar.")
    public void kullaniciSignInButonunaTiklar() {
        us021Page.signinbutonu.click();

    }

    @Given("Kullanici MyPages yazisina tiklar.")
    public void kullaniciMyPagesYazisinaTiklar() {
        us021Page.mypagesbutonu.click();
    }


    @Then("Kullanici randevu bilgilerine ulasabildigini test eder")
    public void kullaniciRandevuBilgilerineUlasabildiginiTestEder() {
        Assert.assertTrue(us021Page.startdatetexbox.isDisplayed());
        Assert.assertTrue(us021Page.enddatetimetexbox.isDisplayed());
        Assert.assertTrue(us021Page.statustexbox.isDisplayed());
        Assert.assertTrue(us021Page.physiciantexbox.isDisplayed());
    }

    @And("Kullanici Show Tests butonuna tiklar.")
    public void kullaniciShowTestsButonunaTiklar() {
        us021Page.showtestbutonu.click();
    }

    @And("Kullanici View Results butonuna tiklar")
    public void kullaniciViewResultsButonunaTiklar() {
        us021Page.viewresultsbutonu.click();
    }

    @Then("Kullanici test sonuclarini görür")
    public void kullaniciTestSonuclariniGörür() {
        Assert.assertTrue(us021Page.testID.isDisplayed());
        Assert.assertTrue(us021Page.testName.isDisplayed());
        Assert.assertTrue(us021Page.testResult.isDisplayed());
    }

    @And("Kullanici bilgileri gunceller")
    public void kullaniciBilgileriGunceller() {
        us021Page.resultedit.click();
        us021Page.resultedit.sendKeys("14");

    }
}