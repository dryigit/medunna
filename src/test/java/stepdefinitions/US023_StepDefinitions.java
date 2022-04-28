package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import pages.US23_Page;
import pages.US24_Page;
import pages.US9Page;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.awt.*;
import java.security.Key;
import java.time.LocalDate;


import static utilities.ReusableMethods.getScreenshot;
import static utilities.ReusableMethods.waitForClickablility;

public class US023_StepDefinitions {
    public static void main(String[] args) {
        LocalDate localDate=LocalDate.now();
        System.out.println(localDate);
    }

    US23_Page us23_page = new US23_Page();
    US24_Page us24_page = new US24_Page();
    US9Page us9Page = new US9Page();

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

    @And("Kullanici Kullanici My Pages yazisina tiklar.")
    public void kullaniciKullaniciMyPagesYazisinaTiklar() {
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
        Thread.sleep(5000);

    }
    @Given("Kullanici acilan sayfada Patient icin Show Appointments kismina tiklar.")
    public void kullanici_acilan_sayfada_patient_icin_show_appointments_kismina_tiklar() throws InterruptedException {
      actions.sendKeys(Keys.PAGE_UP).perform();
      Thread.sleep(3000);
       us23_page.showAppointmentsButton.click();
       Thread.sleep(3000);
    }
    @Given("Kullanici acilan sayfada Payment Invoice Process butonuna tiklar.")
    public void kullanici_acilan_sayfada_payment_invoice_process_butonuna_tiklar() throws InterruptedException {

       // actions.moveToElement(us23_page.paymentInvoiceProcessButton).perform();

       //actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(3000);
       us23_page.paymentInvoiceProcessButton.click();



    }
    @Given("Kullanici Payment Detail ekranindan Creat Invoice kismina tiklar.")
    public void kullanici_payment_detail_ekranindan_creat_invoice_kismina_tiklar() throws InterruptedException {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        us23_page.createInvoiceButton.click();
        Thread.sleep(3000);

    }
    @Given("Kullanici Create or Edit a Bill sayfasinda patient odeme turunu secer ve Save tusuna basar.")
    public void kullanici_create_or_edit_a_bill_sayfasinda_patient_odeme_turunu_secer_ve_save_tusuna_basar() throws InterruptedException {
        actions.sendKeys(Keys.PAGE_DOWN).click().perform();
        Thread.sleep(3000);
        us23_page.descriptionText.sendKeys("asedefegeheje");
        Thread.sleep(2000);
       // actions.sendKeys(Keys.PAGE_DOWN).click().perform();
        us23_page.saveButton.click();
    }


    @Given("Kullanici Payment Detail sayfasinda Show Invoice yazisina tiklar.")
    public void kullanici_payment_detail_sayfasinda_show_invoice_yazisina_tiklar() throws InterruptedException {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        us24_page.showInvoiceButton.click();
    }
    @Given("Kullanici acilan sayfada INVOICE yazisinin oldugunu dogrular.")
    public void kullanici_acilan_sayfada_invoice_yazisinin_oldugunu_dogrular() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue("Fatura gozukmuyor.",us24_page.invoiceText.isDisplayed());
    }


    @And("Kullanici Payment Detail sayfasindan test ve muayene ucretlerinin goruldugunu dogrular.")
    public void kullaniciPaymentDetailSayfasindanTestVeMuayeneUcretlerininGoruldugunuDogrular() {
        Assert.assertTrue("Exam Fee gorunmuyor",us23_page.examFeeText.isDisplayed());
        Assert.assertTrue("Urea item fee gorunmuyor.",us23_page.ureaFeeText.isDisplayed());
        Assert.assertTrue("Creatine item fee gorunmuyor.",us23_page.creatinineFeeText.isDisplayed());
       // Assert.assertTrue("Soidum item fee gorunmuyor.",us23_page.creatinineFeeText.isDisplayed());

    }

    @Then("Kullanici Appointments sayfasinda Status kisminda Completed ya da Cancelled yazisinin goruldugunu dogrular.")
    public void kullaniciAppointmentsSayfasindaStatusKismindaCompletedYaDaCancelledYazisininGoruldugunuDogrular() {
        Assert.assertEquals("COMPLETED",us23_page.statusTextCompleted.getText());

    }

    @And("Kullanici A Bill is updated with identifier mesajini aldigini dogrular.")
    public void kullaniciABillIsUpdatedWithIdentifierMesajiniAldiginiDogrular() {
      //  JSUtils.clickElementByJS(us23_page.toastify);
        Assert.assertTrue("Fatura olusturulamadi.",us23_page.toastify.isDisplayed());

    }

    @And("Kullanici Patient Detail sayfasinda Show Invoice yazisina tiklar.")
    public void kullaniciPatientDetailSayfasindaShowInvoiceYazisinaTiklar() throws InterruptedException {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(4000);
        us23_page.showInvoicePaymentButton.click();
    }


    @Given("make an appointmnet bas")
    public void make_an_appointmnet_bas() throws InterruptedException {
        us23_page.appointmentButoon.click();
        Thread.sleep(8000);
    }
    @Given("date gir")
    public void date_gir() {
        LocalDate localDate=LocalDate.now();
        System.out.println(localDate);
        us23_page.appoDATe.sendKeys("localDate");
        String actual = us23_page.appoDATe.getText();
        System.out.println(actual);
    }
    @Given("verify")
    public void verify() {
       // Assert.assertEquals(,us23_page.appoDATe);
    }

}
