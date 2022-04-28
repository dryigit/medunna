package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AppointmentPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US005_StepDefinitions {
    AppointmentPage appointmentPage = new AppointmentPage();
    Faker faker = new Faker();


    @Given("lvnt kullanici {string} sayfasina gider")
    public void lvntKullaniciSayfasinaGider(String arg0) {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaURL"));
    }
    @Then("lvnt kullanici Make an Appointment butonuna tiklar")
    public void lvnt_kullanici_make_an_appointment_butonuna_tiklar() {
        appointmentPage.makeanappointment.click();
    }
    @Given("lvnt name olarak {string} girer")
    public void lvnt_name_olarak_girer(String string) {
        appointmentPage.firstname.sendKeys(faker.name().firstName());
    }
    @Given("lvnt lastname olarak {string} girer")
    public void lvnt_lastname_olarak_girer(String string) {
        appointmentPage.lastname.sendKeys(faker.name().lastName());
    }
    @Given("lvnt SSN numarasi olarak {string} girer")
    public void lvnt_ssn_numarasi_olarak_girer(String string) {
        appointmentPage.ssn.sendKeys(faker.idNumber().ssnValid());
    }
    @Given("lvnt e-posta  {string} girer")
    public void lvnt_e_posta_girer(String string) {
        appointmentPage.email.sendKeys(faker.internet().emailAddress());
    }
    @And("lvnt telefon olarak {string} girer")
    public void lvnt_telefonOlarakGirer(String arg0) {
        appointmentPage.phone.sendKeys("312-212-5555");
    }
    @Given("lvnt date olarak {string} girer")
    public void lvnt_date_olarak_girer(String string) {
        appointmentPage.appoDate.sendKeys("30.04.2022");
    }
    @Then("lvnt send an appointment request butonuna tiklar")
    public void lvnt_send_an_appointment_request_butonuna_tiklar() {
        appointmentPage.requestButton.click();
    }
    @Then("lvnt randevu tarihi olusturuldugunu kontrol eder")
    public void lvnt_randevu_tarihi_olusturuldugunu_kontrol_eder() {
        appointmentPage.toastify.isDisplayed();
    }


    @Given("lvnt name alanini bos birakir")
    public void lvntNameAlaniniBosBirakir() {
        appointmentPage.firstname.sendKeys(" ");
    }

    @Then("lvnt randevu tarihi olusturuldugunu kontrol eder ama negatif sonuc alir")
    public void lvntRandevuTarihiOlusturuldugunuKontrolEderAmaNegatifSonucAlir() {
        appointmentPage.invalidFeedback.isDisplayed();
    }

    @And("lvnt lastname alanini bos birakir")
    public void lvntLastnameAlaniniBosBirakir() {
        appointmentPage.lastname.sendKeys(" ");
    }

    @And("lvnt SSN numarasi alanini bos birakir")
    public void lvntSSNNumarasiAlaniniBosBirakir() {
        appointmentPage.ssn.sendKeys(" ");
    }

    @And("lvnt e-posta alanini bos birakir")
    public void lvntEPostaAlaniniBosBirakir() {
        appointmentPage.email.sendKeys(" ");
    }

    @And("lvnt telefon alanini bos birakir")
    public void lvntTelefonAlaniniBosBirakir() {
        appointmentPage.phone.sendKeys(" ");
    }

    @And("lvnt date alanini bos birakir")
    public void lvntDateAlaniniBosBirakir() {
        appointmentPage.phone.sendKeys(" ");
    }
}
