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
    public void username_ve_password_ile_giriş_yapar() {
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
    public void my_appointments_tıklar() {

        us013_page.myAppoinButonu.click();

    }


    @Then("Hasta bilgileri için edit tıklanır")
    public void hasta_bilgileri_için_edit_tıklanır() {
        us013_page.editButonu.click();

    }


    @Then("Güncellenen test sonuclari icin Show Test Results tiklanir")
    public void güncellenen_test_sonuçları_için_show_test_results_tıklanır() {

        ReusableMethods.waitFor(3);
        us013_page.testSonuçlarınıGöster.click();

    }


    @Then("Gelen sonuc icin View Results tiklanir")
    public void gelen_sonuç_için_view_results_tıklanır() {

        ReusableMethods.waitFor(3);
        us013_page.viewResults.click();

    }


    @Then("İlgli alanlar kontrol edilir")
    public void i̇lgli_alanlar_kontrol_edilir() {

        Assert.assertTrue(us013_page.ıdBaslık.isEnabled());
        Assert.assertTrue(us013_page.nameBaslık.isEnabled());
        Assert.assertTrue(us013_page.defaultMinBaslık.isEnabled());
        Assert.assertTrue(us013_page.defaultMaxBaslık.isEnabled());
        Assert.assertTrue(us013_page.testBaslık.isEnabled());
        Assert.assertTrue(us013_page.tarihBaslık.isEnabled());


    }

    @Then("Yatili hasta icin ilgili alanlar doldurulur")
    public void yatılı_hasta_için_ilgili_alanlar_doldurulur() {

        us013_page.anamnesisAlanı.sendKeys("bla");
        us013_page.tedaviAlanı.sendKeys("bla");
        us013_page.teşhisAlanı.sendKeys("bla");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        us013_page.receteAlanı.sendKeys("bla");
        us013_page.tanıAlanı.sendKeys("bla");





    }
    @Then("Request Impatient tiklanir")
    public void request_impatient_tıklanır() {

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
