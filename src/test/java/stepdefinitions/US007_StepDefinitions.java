package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.US007Page;
import utilities.ConfigReader;
import utilities.Driver;

public class US007_StepDefinitions {

    US007Page us007_tc01_tc02 = new US007Page();


    @Given("Hydr hasta medunna anasayfasina gider")
    public void hydrHastaMedunnaAnasayfasinaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaURL"));
    }

    @And("Hydr isim olarak {string} girer")
    public void hydrIsimOlarakGirer(String firstname) {
        us007_tc01_tc02.firstName.sendKeys(firstname);
    }

    @And("Hydr soyisim olarak {string} girer")
    public void hydrSoyisimOlarakGirer(String lastname) {
        us007_tc01_tc02.lastName.sendKeys(lastname);
    }

    @And("Hydr SSN {string} girer")
    public void hydrSSNGirer(String SSN) {
        us007_tc01_tc02.SSN.sendKeys(SSN);
    }

    @And("Hydr email {string} girer")
    public void hydrEmailGirer(String Email) { us007_tc01_tc02.email.sendKeys(Email);

    }

    @And("Hydr telNo {string} girer")
    public void hydrTelNoGirer(String PhoneNumber) {
        us007_tc01_tc02.phone.sendKeys(PhoneNumber);

    }

    @And("Hydr gecerli randevu tarihi {string} girer")
    public void hydrGecerliRandevuTarihiGirer(String RandevuTarihi) {
        us007_tc01_tc02.randevuTarihi.sendKeys(RandevuTarihi);
    }

    @And("Hydr Send an Appointment Request butonuna tiklar")
    public void hydrSendAnAppointmentRequestButonunaTiklar() {
        us007_tc01_tc02.sendAppnmtButton.submit();

    }

    @Then("Hydr randevu tarihi olusturuldugunu kontrol eder")
    public void hydrRandevuTarihiOlusturuldugunuKontrolEder() throws InterruptedException {
        Thread.sleep(1);

        Assert.assertTrue(us007_tc01_tc02.toastifyBasarili.isDisplayed());
    }


    @And("Hydr randevu tarihi {string} girer")
    public void hydrRandevuTarihiGirer(String RandevuTarihi) {
        us007_tc01_tc02.randevuTarihi.sendKeys(RandevuTarihi);
    }

    @Then("Hydr randevu tarihi olusturulmadigini kontrol eder")
    public void hydrRandevuTarihiOlusturulmadiginiKontrolEder() throws InterruptedException {

        Thread.sleep(1);

        Assert.assertTrue(us007_tc01_tc02.pastDateText.isDisplayed());
    }



}
