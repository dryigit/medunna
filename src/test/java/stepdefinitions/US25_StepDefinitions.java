package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.US25_Page;
import pages.US9Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;


public class US25_StepDefinitions {
    US25_Page us25_page = new US25_Page();
    US9Page us9Page = new US9Page();

    @Given("PatientAG {string} sayfasina gider")
    public void patientagSayfasinaGider(String a) {
        Driver.getDriver().get(ConfigReader.getProperty(a));
    }


    @Then("PatientAG gecerli bilgileri girerek basarili giris yapar")
    public void patientagGecerliBilgileriGirerekBasariliGirisYapar() throws InterruptedException {

        us9Page.EntryButton.click();
        us9Page.singInButton.click();
        us9Page.usernameButton.sendKeys("PatientAG");
        us9Page.passwordButton.sendKeys("1203bakii1203");
        us9Page.singInButton2.click();


    }

    @And("PatientAG My Pages sayfasi altinda Make an Appointment butonuna tiklar")
    public void patientagMyPagesSayfasiAltindaMakeAnAppointmentButonunaTiklar() {
        us25_page.myPagesbuttonPatient.click();
        us25_page.makeAnAppointment.click();

    }

    @Then("PatientAG firstname,lastname,SSN,email,phone,appointment date kutularini doldurur")
    public void patientagFirstnameLastnameSSNEmailPhoneAppointmentDateKutulariniDoldurur() {
        us25_page.firstName.clear();
        us25_page.firstName.sendKeys("Ali");
        us25_page.lastName.clear();
        us25_page.lastName.sendKeys("Baba");
        us25_page.SSN.clear();
        us25_page.SSN.sendKeys("123-66-1289");
        us25_page.email.clear();
        us25_page.email.sendKeys("test@gmail.com");
        us25_page.phone.clear();
        us25_page.phone.sendKeys("123-345-1234");


    }

    @And("PatientAG Send an appointment request butonuna tiklayarak cikan mesajdan randevu olusturuldugunu dogrular")
    public void patientagSendAnAppointmentRequestButonunaTiklayarakCikanMesajdanRandevuOlusturuldugunuDogrular() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();

        javascriptExecutor.executeScript("window.scrollBy(0,500)");

        JSUtils.clickElementByJS(us25_page.sendAppnmtButton);
        ReusableMethods.waitForVisibility(us25_page.toasttify, 5);
        Assert.assertTrue(us25_page.toasttify.isDisplayed());
    }

    @And("PatientAG Contact sayfasina tiklar")
    public void patientagContactSayfasinaTiklar() {

        JSUtils.clickElementByJS(us25_page.contactButton);
    }

    @Then("PatientAG name,email,subject,message kutularini doldurur")
    public void patientagNameEmailSubjectMessageKutulariniDoldurur() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();

        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", us25_page.contactName);

        us25_page.contactName.sendKeys("Cabbar");
        us25_page.contactEmail.sendKeys("test@gmail.com");
        us25_page.contactSubject.sendKeys("bravo");
        us25_page.contactMessage.sendKeys("tebrıkler");

     JSUtils.clickElementByJS( us25_page.contactSendButton);
    }


    @And("PatientAG Send butonuna tiklayarak cikan mesajdan iletisim istegi gonderildigini dogrular")
    public void patientagSendButonunaTiklayarakCikanMesajdanIletisimIstegiGonderildiginiDogrular() {
        Assert.assertTrue(us25_page.toastMessage.isDisplayed());
    }
}
