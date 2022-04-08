package stepdefinitions;

import com.beust.ah.A;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AppointmentPage;

public class US005_StepDefinitions   {

    AppointmentPage appointmentPage = new AppointmentPage();
    Faker faker = new Faker();

    @Given("kullanici {string} anasayfasına gider")
    public void kullaniciAnasayfasınaGider(String arg0) {
    }

    @Then("kullanici Make an Appointment butonuna tıklar")
    public void kullanici_make_an_appointment_butonuna_tıklar() {

    }
    @Given("name olarak {string} girer")
    public void name_olarak_girer(String string) {

    }
    @Given("lastname olarak {string} girer")
    public void lastname_olarak_girer(String string) {

    }
    @Given("SSN numarası olarak {string} girer")
    public void ssn_numarası_olarak_girer(String string) {

    }
    @Given("e-posta  {string} girer")
    public void e_posta_girer(String string) {

    }
    @Given("date olarak {string} girer")
    public void date_olarak_girer(String string) {

    }
    @Then("send an appointment request butonuna tıklar")
    public void send_an_appointment_request_butonuna_tıklar() {

    }
    @Then("randevu tarihi olusturuldugunu kontrol eder")
    public void randevu_tarihi_olusturuldugunu_kontrol_eder() {

    }


}
