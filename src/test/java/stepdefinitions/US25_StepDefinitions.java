package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.US25_Page;

public class US25_StepDefinitions {
US25_Page us25_page=new US25_Page();

    @Given("PatientAG {string} sayfasina gider")
    public void patientagSayfasinaGider(String arg0) {
    }


    @Then("PatientAG gecerli bilgileri girerek basarili giris yapar")
    public void patientagGecerliBilgileriGirerekBasariliGirisYapar() {
        
    }

    @And("PatientAG My Pages sayfasi altinda Make an Appointment butonuna tiklar")
    public void patientagMyPagesSayfasiAltindaMakeAnAppointmentButonunaTiklar() {
        
    }

    @Then("PatientAG firstname,lastname,SSN,email,phone,appointment date kutularini doldurur")
    public void patientagFirstnameLastnameSSNEmailPhoneAppointmentDateKutulariniDoldurur() {
        
    }

    @And("PatientAG Send an appointment request butonuna tiklayarak cikan mesajdan randevu olusturuldugunu dogrular")
    public void patientagSendAnAppointmentRequestButonunaTiklayarakCikanMesajdanRandevuOlusturuldugunuDogrular() {
        
    }

    @And("PatientAG Contact sayfasina tiklar")
    public void patientagContactSayfasinaTiklar() {
        
    }

    @Then("PatientAG name,email,subject,message kutularini doldurur")
    public void patientagNameEmailSubjectMessageKutulariniDoldurur() {
        
    }

    @And("PatientAG Send butonuna tiklayarak cikan mesajdan iletisim istegi gönderildigini dogrular")
    public void patientagSendButonunaTiklayarakCikanMesajdanIletisimIstegiGönderildiginiDogrular() {
    }
}
