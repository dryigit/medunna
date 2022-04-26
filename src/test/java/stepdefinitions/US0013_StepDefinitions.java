package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.Us013_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US0013_StepDefinitions {

    Us013_Page us013_page=new Us013_Page();
    Actions actions=new Actions(Driver.getDriver());

    @Given("Doktor url gider")
    public void doktor_url_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("MedunnaURL"));

    }


    @Then("Sing in Tiklar")
    public void sing_in_tiklar() {

        us013_page.loginIkon.click();

        us013_page.singInButton.click();

    }


    @Then("Username ve Password ile giris yapar")
    public void username_ve_password_ile_giris_yapar() {
        us013_page.username.sendKeys(ConfigReader.getProperty("TC_drUsername"));
        us013_page.password.sendKeys(ConfigReader.getProperty("TC_drpassword"));
        us013_page.singInEnter.click();

    }


    @Then("My Pages Buttonunu Tiklar")
    public void my_pages_buttonunu_tiklar() throws InterruptedException {

        us013_page.myPagesButonu.click();
        Thread.sleep(3000);


    }


    @Then("My Appointments tiklar")
    public void my_appointments_tiklar() {

        us013_page.myAppoinButonu.click();

    }


    @Then("Hasta bilgileri icin edit tiklanir")
    public void hasta_bilgileri_icin_edit_tiklanir() {
        us013_page.editButonu.click();

    }


    @Then("Guncellenen test sonuclari icin Show Test Results tiklanir")
    public void guncellenen_test_sonuclari_icin_show_test_Results_tiklanir() {

        ReusableMethods.waitFor(3);
        us013_page.testSonuclariniGoster.click();

    }


    @Then("Gelen sonuc icin View Results tiklanir")
    public void gelen_sonuc_icin_view_results_tiklanir() {

        ReusableMethods.waitFor(3);
        us013_page.viewResults.click();

    }


    @Then("Ilgli alanlar kontrol edilir")
    public void Ilgli_alanlar_kontrol_edilir() {

        Assert.assertTrue(us013_page.idBaslik.isEnabled());
        Assert.assertTrue(us013_page.nameBaslik.isEnabled());
        Assert.assertTrue(us013_page.defaultMinBaslik.isEnabled());
        Assert.assertTrue(us013_page.defaultMaxBaslik.isEnabled());
        Assert.assertTrue(us013_page.testBaslik.isEnabled());
        Assert.assertTrue(us013_page.tarihBaslik.isEnabled());


    }

    @Then("Yatili hasta icin ilgili alanlar doldurulur")
    public void Yatili_hasta_icin_ilgili_alanlar_doldurulur() {

        us013_page.anamnesisAlani.sendKeys("bla");
        us013_page.tedaviAlani.sendKeys("bla");
        us013_page.teshisAlani.sendKeys("bla");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        us013_page.receteAlani.sendKeys("bla");
        us013_page.taniAlani.sendKeys("bla");





    }
    @Then("Request Impatient tiklanir")
    public void request_impatient_tiklanir() {

        actions.sendKeys(Keys.PAGE_UP).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(3);
        us013_page.requestImpatientButonu.click();

        String text=us013_page.toastify.getText().toString();
        System.out.println("toastify"+text);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(us013_page.toastify.isDisplayed());

        //getAttribute("innerText"));


    }


}
