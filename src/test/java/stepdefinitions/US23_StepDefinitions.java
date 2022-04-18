package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.US23_Page;
import pages.US24_Page;
import utilities.Driver;

public class US23_StepDefinitions {

    US23_Page us23_page = new US23_Page();
    US24_Page us24_page = new US24_Page();

    Actions actions = new Actions(Driver.getDriver());

    @Given("Kullanici Username kismina valid staff deger girer.")
    public void kullanici_username_kismina_valid_staff_deger_girer() {
        us24_page.userNameButton.sendKeys("staffSumey");
    }
    @Given("Kullanici Password kismina valid staff deger girer ve Sign In butonua tiklar.")
    public void kullanici_password_kismina_valid_staff_deger_girer_ve_sign_in_butonua_tiklar() throws InterruptedException {
        us24_page.passButton.sendKeys("Batch44+");
        us24_page.signInButton2.click();
        Thread.sleep(3000);
    }

    @And("Kullanici My Pages yazisina tiklar.")
    public void kullaniciMyPagesYazisinaTiklar() throws InterruptedException {
        Thread.sleep(3000);
        us23_page.myPagesButton.click();
    }
    @Given("Kullanici acilan alt menude Seach Patient yazisina tiklar.")
    public void kullanici_acilan_alt_menude_seach_patient_yazisina_tiklar() throws InterruptedException {
        us23_page.searchPatientButton.click();
        Thread.sleep(3000);
    }
    @Given("Kullanici Patients SSN kismina Patient SSN degeri girer.")
    public void kullanici_patients_ssn_kismina_patient_ssn_degeri_girer() throws InterruptedException {
        us23_page.patientsSSNtextBox.sendKeys("060-06-0541");
        Thread.sleep(3000);
    }
    @Given("Kullanici acilan sayfada Patient icin Show Appointments kismina tiklar.")
    public void kullanici_acilan_sayfada_patient_icin_show_appointments_kismina_tiklar() {
        us23_page.showAppointmentsButton.click();
    }
    @Given("Kullanici acilan sayfada Payment Invoice Process butonuna tiklar.")
    public void kullanici_acilan_sayfada_payment_invoice_process_butonuna_tiklar() {

    }
    @Given("Kullanici Payment Detail ekranindan Creat Invoice kismina tiklar.")
    public void kullanici_payment_detail_ekranindan_creat_invoice_kismina_tiklar() {

    }
    @Given("Kullanici Create or Edit a Bill sayfasinda patient odeme turunu secer ve Save tusuna basar.")
    public void kullanici_create_or_edit_a_bill_sayfasinda_patient_odeme_turunu_secer_ve_save_tusuna_basar() {

    }
    @Given("Kullanici tekrar acilan Patients sayfasinda SSN kismina Patient SSN degeri girer.")
    public void kullanici_tekrar_acilan_patients_sayfasinda_ssn_kismina_patient_ssn_degeri_girer() {

    }
    @Given("Kullanici hastanin Show Appointments kismina tiklar.")
    public void kullanici_hastanin_show_appointments_kismina_tiklar() {

    }
    @Given("Kullanici ilgili randevunun Payment Invoice Process yazisina tiklar.")
    public void kullanici_ilgili_randevunun_payment_invoice_process_yazisina_tiklar() {

    }
    @Given("Kullanici Payment Detail sayfasinda Show Invoice yazisina tiklar.")
    public void kullanici_payment_detail_sayfasinda_show_invoice_yazisina_tiklar() {

    }
    @Given("Kullanici acilan sayfada INVOICE yazisinin oldugunu dogrular.")
    public void kullanici_acilan_sayfada_invoice_yazisinin_oldugunu_dogrular() {

    }


}
