package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.US007_TC01_TC02;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.File;

import static utilities.ReusableMethods.getScreenshot;

public class US007_StepDefinitions {

    US007_TC01_TC02 us007_tc01_tc02 = new US007_TC01_TC02();

    @Given("Hydr hasta medunna anasayfasına gider")
    public void hydr_hasta_medunna_anasayfasına_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaURL"));

    }

    @And("isim olarak {string} girer")
    public void isimOlarakGirer(String firstname) {
        us007_tc01_tc02.firstName.sendKeys(firstname);
    }

    @And("soyisim olarak {string} girer")
    public void soyisimOlarakGirer(String lastname) {
        us007_tc01_tc02.lastName.sendKeys(lastname);
    }

    @And("SSN {string} girer")
    public void ssnGirer(String SSN) {
        us007_tc01_tc02.SSN.sendKeys(SSN);
    }

    @And("email {string} girer")
    public void emailGirer(String Email) {
        us007_tc01_tc02.email.sendKeys(Email);
    }

    @And("telNo {string} girer")
    public void telnoGirer(String PhoneNumber) {
        us007_tc01_tc02.phone.sendKeys(PhoneNumber);
    }

    @And("randevu tarihi {string} girer")
    public void randevuTarihiGirer(String RandevuTarihi) {
        us007_tc01_tc02.randevuTarihi.sendKeys(RandevuTarihi);
    }


    @And("Send an Appointment Request butonuna tıklar")
    public void sendAnAppointmentRequestButonunaTıklar() {
        us007_tc01_tc02.sendAppnmtButton.submit();
    }

    @Then("Randevu tarihi olusturuldugunu kontrol eder")
    public void randevuTarihiOlusturuldugunuKontrolEder() throws InterruptedException {
        Thread.sleep(1);

    Assert.assertTrue(us007_tc01_tc02.toastifyBasarili.isDisplayed());

    }

    @Then("Randevu tarihi olusturulmadıgını kontrol eder")
    public void randevuTarihiOlusturulmadıgınıKontrolEder() throws InterruptedException {
        Thread.sleep(1);

    Assert.assertTrue(us007_tc01_tc02.pastDateText.isDisplayed());

    }

}
