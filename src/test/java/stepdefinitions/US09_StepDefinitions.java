package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US9Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US09_StepDefinitions {
US9Page us9Page =new US9Page();


//tc1
    @Given("kullanici {string} sayfasina gider")
    public void kullaniciSayfasinaGider(String a) {
        Driver.getDriver().get(ConfigReader.getProperty(a));
    }

    @Then("kullanici gecerli bilgileri girerek basarili giris yapar")
    public void kullanici_gecerli_bilgileri_girerek_basarili_giris_yapar() {
us9Page.EntryButton.click();
us9Page.singInButton.click();
us9Page.usernameButton.sendKeys("UserAG");
us9Page.passwordButton.sendKeys("1203bakii1203");
us9Page.singInButton2.click();
    }
    @Then("kullanici My pages butonuna tiklar açılan sekmeden In Patient secer")
    public void kullaniciMyPagesButonunaTiklarAçılanSekmedenInPatientSecer() {
us9Page.MyPagesButtonStaff.click();
us9Page.InpatientButton.click();

    }

    @Then("acilan sayfa da görüntülenen hastalardan ilk sırada olan hasta secilir")
    public void acilan_sayfa_da_görüntülenen_hastalardan_ilk_sırada_olan_hasta_secilir() {
us9Page.InpatientInformation.click();

    }
    @And("hasta bilgilerinin acildigi sayfa Patient yazısının görüldügü ile test edilir")
    public void hastaBilgilerininAcildigiSayfaPatientYazısınınGörüldügüIleTestEdilir() {
Assert.assertTrue(us9Page.InPatientsText.isDisplayed());

    }

    //tc2

    @Then("kullanici edit butonuna tıklar")
    public void kullanici_edit_butonuna_tıklar() {

              JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();

               javascriptExecutor.executeScript("window.scrollBy(0,400)");
        ReusableMethods.waitForVisibility(us9Page.patientEdit,5);
        us9Page.patientEdit.click();

    }
    @Then("kullanici acilan sayfa da firstname,lastname,email.phone bilgilerini düzenler")
    public void kullanici_acilan_sayfa_da_firstname_lastname_email_phone_bilgilerini_düzenler() {
us9Page.firstNameButton.sendKeys("AAA");
us9Page.lastNameButton.sendKeys("BBB");
us9Page.emailNameButton.sendKeys("CCC");

    }
    @Then("kullanici save butonuna basarak bilgilerin kaydedildigini test eder")
    public void kullanici_save_butonuna_basarak_bilgilerin_kaydedildigini_test_eder() throws InterruptedException {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(5);
        javascriptExecutor.executeScript("window.scrollBy(0,800)");
        ReusableMethods.waitForVisibility(us9Page.saveButton,5);
        Thread.sleep(5);
ReusableMethods.waitForClickablility(us9Page.saveButton,5);
       Assert.assertTrue(us9Page.saveButton.isDisplayed());
        Thread.sleep(5);
        us9Page.saveButton.click();
    }


    //tc3
    @Then("kullanici My pages butonuna tiklar açılan sekmeden Search Patient secer")
    public void kullanici_my_pages_butonuna_tiklar_açılan_sekmeden_search_patient_secer() {

        us9Page.MyPagesButtonStaff.click();
        us9Page.searchPatientButton.click();
    }
    @Then("kullanici SSN kutusuna gecerli bir SSN numarası girer")
    public void kullanici_ssn_kutusuna_gecerli_bir_ssn_numarası_girer() {
us9Page.searchSSNbutton.sendKeys("111-11-1111");

    }
    @Then("kullanici gelen bilgilerden ilk sirada olan hastayi secer")
    public void kullanici_gelen_bilgilerden_ilk_sirada_olan_hastayi_secer() {
us9Page.viewButton.click();
    }
    @Then("acilan sayfada edit butonuna tiklanir")
    public void acilan_sayfada_edit_butonuna_tiklanir() throws InterruptedException {

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();

        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",us9Page.editButonu);
        Actions actions=new Actions(Driver.getDriver());
        actions.keyDown(Keys.DOWN).keyDown(Keys.DOWN).perform();

        us9Page.editButonu.click();

    }
    @Then("kullanici acilan sayfada firstname,lastname,email,phone boxlarinin bos olmadigini test eder")
    public void kullanici_acilan_sayfada_firstname_lastname_email_phone_boxlarinin_bos_olmadigini_test_eder() {
Assert.assertTrue(us9Page.firstNameButton2.isDisplayed());
        Assert.assertTrue(us9Page.lastNameButton2.isDisplayed());
        Assert.assertTrue(us9Page.emailButton2.isDisplayed());
    }

//tc4

    @Then("kullanici firstname textini siler ve silindigini test eder")
    public void kullaniciFirstnameTextiniSilerVeSilindiginiTestEder() {
us9Page.firstNameButton2.clear();

Assert.assertTrue(us9Page.firstNameButton2.isDisplayed());
    }



    //US10 TC01

    @And("kullanici My Appointments sekmesine tıklar")
    public void kullaniciMyAppointmentsSekmesineTıklar() {
us9Page.doctorMyPages.click();
us9Page.myAppointments.click();
    }

    @And("kullanici randevu listesini ve zaman dilimlerini bu sekmede görür")
    public void kullaniciRandevuListesiniVeZamanDilimleriniBuSekmedeGörür() {
Assert.assertTrue(us9Page.appointmentsText.isDisplayed());
    }



    //US10 TC02

    @And("kullanici cikan listede en üst sırada olani secer")
    public void kullaniciCikanListedeEnÜstSıradaOlaniSecer() {
        us9Page.firstPatient.click();

    }


    @And("kullanici edit butonuna tıklayip patient id, start date, end date, status bilgilerinin görüldügünü test eder")
    public void kullaniciEditButonunaTıklayipPatientIdStartDateEndDateStatusBilgilerininGörüldügünüTestEder() {

Assert.assertTrue(us9Page.doctorSSN.isDisplayed());
Assert.assertTrue(us9Page.doctorFirstName.isDisplayed());
Assert.assertTrue(us9Page.doctorLastName.isDisplayed());

    }


    //us9 tc-5
    @And("kullanici staff olarak hastaları silemedigini test eder")
    public void kullaniciStaffOlarakHastalarıSilemediginiTestEder() {
        Assert.assertFalse(us9Page.adminDelete.isDisplayed());
    }

//us9 tc-6
    @Given("kullanici Admin olarak giris yapar")
    public void kullaniciAdminOlarakGirisYapar() {
        us9Page.EntryButton.click();
        us9Page.singInButton.click();
        us9Page.usernameButton.sendKeys("Team85Admin");
        us9Page.passwordButton.sendKeys("Batch44+");
        us9Page.singInButton2.click();
    }

    @And("kullanici hastalari SSN kimlik numaralarina göre arama yapamadigini test eder")
    public void kullaniciHastalariSSNKimlikNumaralarinaGöreAramaYapamadiginiTestEder() {

    }




}
