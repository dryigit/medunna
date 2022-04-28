package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.US24_Page;
import utilities.ConfigReader;
import utilities.Driver;

public class US024_StepDefinitions {

    US24_Page us24_page = new US24_Page();
    Actions actions = new Actions(Driver.getDriver());

    @Given("Kullanici url'ye gider.")
    public void kullanici_url_ye_gider() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("MedunnaURL"));
        Thread.sleep(3000);
    }
    @Given("Kullanici insan ikonuna tiklar.")
    public void kullanici_insan_ikonuna_tiklar() {
        us24_page.insanIkonButton.click();
    }
    @Given("Kullanici Sign In butonuna tiklar.")
    public void kullanici_sign_in_butonuna_tiklar() {
        us24_page.signInButton.click();
    }
    @Given("Kullanici Username kismina valid patient deger girer.")
    public void kullanici_username_kismina_valid_patient_deger_girer() {
        us24_page.userNameButton.sendKeys("senoll");
    }
    @Given("Kullanici Password kismina valid patient deger girer ve Sign In butonua tiklar.")
    public void kullanici_password_kismina_valid_patient_deger_girer_ve_sign_in_butonua_tiklar() throws InterruptedException {
        us24_page.passButton.sendKeys("Batch44+");
        Thread.sleep(3000);
        us24_page.signInButton2.click();
        Thread.sleep(3000);
    }
    @Given("Kullanici My Pages Patient yazisina tiklar.")
    public void kullanici_my_pages_patient_yazisina_tiklar() {
        us24_page.myPagesButtonPatient.click();
    }
    @Given("Kullanici acilan alt menude My Appointment yazisina tiklar.")
    public void kullanici_acilan_alt_menude_my_appointment_yazisina_tiklar() {
        us24_page.myAppointmentsButton.click();
    }
    @Given("Kullanici tarihleri olusturulan appointmente gore degistirir.")
    public void kullanici_tarihleri_olusturulan_appointmente_gore_degistirir() throws InterruptedException {

        us24_page.fromDateButton.sendKeys("05/08/2022");
        Thread.sleep(3000);
        us24_page.toDateButton.sendKeys("05/22/2022");
        Thread.sleep(3000);
    }
    @Given("Kullanici acilan sayfada Show Tests butonuna tiklar.")
    public void kullanici_acilan_sayfada_show_tests_butonuna_tiklar() throws InterruptedException {

        Thread.sleep(3000);
        us24_page.showTestsButton.click();
        Thread.sleep(3000);
    }
    @Given("Kullanici acian Tests sayfasinda View Results yazisina tiklar.")
    public void kullanici_acian_tests_sayfasinda_view_results_yazisina_tiklar() throws InterruptedException {
        us24_page.viewResultsButton.click();
        Thread.sleep(3000);
    }
    @Then("Kullanici Test Results sayfasinda {string} bölümlerinin goruldugunu dogrular.")
    public void kullanici_test_results_sayfasinda_bölümlerinin_goruldugunu_dogrular(String string) {
        Assert.assertTrue("id gozukmuyor",us24_page.idText.isDisplayed());
        Assert.assertTrue("test ismi gozukmuyor.",us24_page.nameText.isDisplayed());
        Assert.assertTrue("Default Min. Value degeri gozukmuyor.",us24_page.defaultMinValueText.isDisplayed());
        Assert.assertTrue("Default Max. Value degeri gozukmuyor.",us24_page.defaultMaxValueText.isDisplayed());
        Assert.assertTrue("Hastanin test degeri gozukmuyor.",us24_page.testSonucText.isDisplayed());
        Assert.assertTrue("Appointment date gozukmuyor.",us24_page.dateText.isDisplayed());
    }


    @And("Kullanici Show Invoice yazisina tiklar.")
    public void kullaniciShowInvoiceYazisinaTiklar() throws InterruptedException {

        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        us24_page.showInvoiceButton.click();
        Thread.sleep(5000);

    }

    @Then("Kullanici faturasinin gozuktugunu dogrular.")
    public void kullaniciFaturasininGozuktugunuDogrular() {
        Assert.assertTrue("Hasta faturasi gozukmuyor.",us24_page.invoiceText.isDisplayed());
    }




}
